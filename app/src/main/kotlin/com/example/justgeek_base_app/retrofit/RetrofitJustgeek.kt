package com.example.justgeek_base_app.retrofit

import com.example.justgeek_base_app.api.*
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import org.apache.http.conn.ssl.SSLSocketFactory.SSL
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.security.SecureRandom
import java.security.cert.CertificateException
import java.security.cert.X509Certificate
import java.util.concurrent.TimeUnit
import javax.net.ssl.*

object RetrofitJustgeek {
    private fun getUnsafeOkHttpClient(): OkHttpClient? {
        return try {
            val trustAllCerts: Array<TrustManager> = arrayOf<TrustManager>(
                object : X509TrustManager {
                    @Throws(CertificateException::class)
                    override fun checkClientTrusted(
                        chain: Array<X509Certificate?>?,
                        authType: String?
                    ) {
                    }

                    @Throws(CertificateException::class)
                    override fun checkServerTrusted(
                        chain: Array<X509Certificate?>?,
                        authType: String?
                    ) {
                    }

                    override fun getAcceptedIssuers(): Array<X509Certificate> = arrayOf()
                }
            )
            val sslContext: SSLContext =
                SSLContext.getInstance(SSL)
            sslContext.init(null, trustAllCerts, SecureRandom())
            val sslSocketFactory: SSLSocketFactory = sslContext.getSocketFactory()
            val builder = OkHttpClient.Builder()
            builder.sslSocketFactory(sslSocketFactory, trustAllCerts[0] as X509TrustManager)
            builder.hostnameVerifier(object : HostnameVerifier {
                override fun verify(hostname: String?, session: SSLSession?): Boolean {
                    return true
                }
            })
            builder.addInterceptor(HttpLoggingInterceptor().setLevel(HttpLoggingInterceptor.Level.BODY))
                .readTimeout(60, TimeUnit.SECONDS)
                .writeTimeout(60, TimeUnit.SECONDS)
                .connectTimeout(60, TimeUnit.SECONDS)
            builder.build()
        } catch (e: Exception) {
            throw RuntimeException(e)
        }
    }
    fun retrofit(): Retrofit {
        val client = OkHttpClient.Builder()
            .addInterceptor(HttpLoggingInterceptor().apply{
                level = HttpLoggingInterceptor.Level.BODY
            }).build()
        val retrofit = Retrofit.Builder()
            .client(getUnsafeOkHttpClient())
            .baseUrl("http://10.5.0.27:8083")
            .addConverterFactory(GsonConverterFactory.create())
            .build()
        return retrofit
    }
    fun user(retrofit: Retrofit): UserApi {
        return retrofit.create(UserApi::class.java)
    }

    fun product(retrofit: Retrofit): ProductApi {
        return retrofit.create(ProductApi::class.java)
    }

    fun comment(retrofit: Retrofit): CommentApi {
        return retrofit.create(CommentApi::class.java)
    }

    fun category(retrofit: Retrofit) : CategoryApi {
        return retrofit.create(CategoryApi::class.java)
    }

    fun popularArtists(retrofit: Retrofit) : ArtistApi {
        return retrofit.create(ArtistApi::class.java)
    }

}