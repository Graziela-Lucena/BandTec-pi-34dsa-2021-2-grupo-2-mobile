package com.example.justgeek_base_app


import android.content.Intent
import android.os.Bundle
import android.service.autofill.UserData
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.AppCompatButton
import androidx.appcompat.widget.AppCompatEditText
import androidx.appcompat.widget.AppCompatTextView
import com.example.justgeek_base_app.data.DataUser
import com.example.justgeek_base_app.retrofit.ApiInterface
import com.example.justgeek_base_app.retrofit.RetrofitInstance
import com.example.justgeek_base_app.data.SignInBody
import com.example.justgeek_base_app.viewmodel.UserViewModel
import okhttp3.ResponseBody
import org.koin.android.viewmodel.ext.android.viewModel
import retrofit2.Response

class LoginActivity: AppCompatActivity(R.layout.activity_main_login) {
    val userViewModel: UserViewModel by viewModel()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val singUpButton = findViewById<AppCompatButton>(R.id.button_sign_up)
        val singInButton = findViewById<AppCompatButton>(R.id.button_sign_in)
        val version = findViewById<AppCompatTextView>(R.id.version)
        version.text = resources.getString(R.string.title_version_app_login, "1.0.0")

        singUpButton.setOnClickListener {
            val intent = Intent(this, OnboardingActivity::class.java)
            startActivity(intent)
        }

        singInButton.setOnClickListener { v -> logged(v) }


    }

    private fun logged(v: View){
        val inputEmail: AppCompatEditText = findViewById(R.id.input_email)
        val inputSenha: AppCompatEditText = findViewById(R.id.input_password)

        signin(inputEmail.text.toString(),inputSenha.text.toString())
    }

    private fun signin(email: String, password: String){
        val retIn = RetrofitInstance.getRetrofitInstance().create(ApiInterface::class.java)
        val signInInfo = SignInBody(email, password)
        retIn.signin(signInInfo).enqueue(object : retrofit2.Callback<ResponseBody> {
            override fun onFailure(call: retrofit2.Call<ResponseBody>, t: Throwable) {
                Toast.makeText(
                    this@LoginActivity,
                    t.message,
                    Toast.LENGTH_SHORT
                ).show()
            }
            override fun onResponse(call: retrofit2.Call<ResponseBody>, response: Response<ResponseBody>) {
                if (response.code() == 200) {
                userViewModel.getUser(1).observe(this@LoginActivity) {
                        data {
                            com.example.justgeek_base_app.data.UserData.userId = it.idUser
                            if(it.isFirstAccess == true) {
                                startActivity(Intent(this@LoginActivity, TutorialAccessFirst::class.java))
                                userViewModel.updateUserInfo(it.idUser, DataUser(
                                    it.idUser,
                                    it.name,
                                    it.lastName,
                                    it.cpf,
                                    it.birthDate,
                                    it.userEmail,
                                    it.cellphone,
                                    it.password,
                                    false,
                                    it.isFirstPurchase
                                ))

                            } else {
                                val intent = Intent(this@LoginActivity, HomePageActivity::class.java)
                                intent.putExtra("idUserExtra", it.idUser)
                                startActivity(intent)
                            }
                        }
                    }
                    Toast.makeText(this@LoginActivity, "Login success!", Toast.LENGTH_SHORT).show()
                } else {
                    Toast.makeText(this@LoginActivity, "Login failed!", Toast.LENGTH_SHORT).show()
                }
            }
        })
    }
}