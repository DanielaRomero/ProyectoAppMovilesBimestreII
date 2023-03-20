package com.example.proyectoappmovilesbimestreii

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageButton

class NuevoReporteActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_nuevo_reporte)

        val botonAtras = findViewById<ImageButton>(R.id.btn_atras)
        botonAtras.setOnClickListener(){
            irActividad(ReporteActivity::class.java)
        }
    }
    private fun irActividad(clase: Class<*>){
        val intent = Intent(this, clase)
        startActivity(intent)
    }
}