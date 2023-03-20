package com.example.proyectoappmovilesbimestreii

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import com.google.firebase.auth.FirebaseAuth

enum class ProviderType{
    BASIC
}

class HomeActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)

        //SetUp
        val bundle: Bundle? = intent.extras
        val email: String? = bundle?.getString("email")
        val provider: String? = bundle?.getString("provider")

        setup(email ?:"", provider ?:"")
    }

    private fun setup(email: String, provider: String){
        title="Inicio"

        val emailtv = findViewById<TextView>(R.id.tv_email)
        val providertv = findViewById<TextView>(R.id.tv_provider)
        val botonLogOut = findViewById<Button>(R.id.btn_logout)

        emailtv.text = email
        providertv.text = provider

        botonLogOut.setOnClickListener(){
            FirebaseAuth.getInstance().signOut()
        }
    }

}