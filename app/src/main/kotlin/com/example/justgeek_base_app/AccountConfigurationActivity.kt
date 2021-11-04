package com.example.justgeek_base_app

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle

class AccountConfigurationActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_account_configuration)

        val fragmentTransaction = supportFragmentManager.beginTransaction()
        val address = UserAddressFragment()
        fragmentTransaction.add(R.id.fragment_address, address)
        fragmentTransaction.commit()
    }
}