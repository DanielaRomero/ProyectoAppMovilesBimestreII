package com.example.proyectoappmovilesbimestreii

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import android.widget.Button
import android.widget.EditText
import androidx.appcompat.app.AlertDialog
import com.google.firebase.auth.FirebaseAuth


class AuthActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_auth)

        //Setup
        setup()
    }

    private fun setup(){
        title = "Autenticación"

        val email = findViewById<EditText>(R.id.et_email)
        val password = findViewById<EditText>(R.id.et_password)
        val botonSignUp = findViewById<Button>(R.id.btn_signUp)
        val botonSingIn = findViewById<Button>(R.id.btn_singin)

        botonSignUp.setOnClickListener(){
            if (email.text.isNotEmpty() && password.text.isNotEmpty()){
                FirebaseAuth.getInstance()
                    .createUserWithEmailAndPassword(email.text.toString(),password.text.toString())
                    .addOnCompleteListener(){
                        if(it.isSuccessful){
                            showHome(it.result?.user?.email?:"", ProviderType.BASIC)
                        }else{
                            showAlert()
                        }
                    }
            }
        }

        botonSingIn.setOnClickListener(){
            if (email.text.isNotEmpty() && password.text.isNotEmpty()){
                FirebaseAuth.getInstance()
                    .signInWithEmailAndPassword(email.text.toString(),password.text.toString())
                    .addOnCompleteListener(){
                        if(it.isSuccessful){
                            showHome(it.result?.user?.email?:"", ProviderType.BASIC)
                        }else{
                            showAlert()
                        }
                    }
            }
        }

    }

    private fun showAlert(){
        val builder = AlertDialog.Builder(this)
        builder.setTitle("Error")
        builder.setMessage("Se ha producido un error autenticando al usuario")
        builder.setPositiveButton("Aceptar", null)
        val dialog: AlertDialog = builder.create()
        dialog.show()
    }

    private fun showHome(email:String, provider:ProviderType){
        val homeIntent = Intent(this, ReporteActivity::class.java).apply {
            putExtra("email", email)
            putExtra("provider", provider.name)
        }
        startActivity(homeIntent)
    }
}