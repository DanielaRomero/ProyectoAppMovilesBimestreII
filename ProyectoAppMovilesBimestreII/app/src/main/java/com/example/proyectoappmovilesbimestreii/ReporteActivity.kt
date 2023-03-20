package com.example.proyectoappmovilesbimestreii

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle

class ReporteActivity : AppCompatActivity() {
    val datosQuemados = arrayListOf(
        Reporte(1,"san bartolo","Se cayo un arbol"
        ,"N","2020,10,10","A",12.5,58.8),
        Reporte(2,"san bartolo1","Se cayo un arbol"
            ,"N","2020,10,10","A",12.5,58.8),
        Reporte(3,"san bartolo2","Se cayo un arbol"
            ,"N","2020,10,10","A",12.5,58.8),
        Reporte(4,"san bartolo3","Se cayo un arbol"
            ,"N","2020,10,10","A",12.5,58.8),
        Reporte(5,"san bartolo4","Se cayo un arbol"
            ,"N","2020,10,10","A",12.5,58.8),
        Reporte(6,"san bartolo5","Se cayo un arbol"
            ,"N","2020,10,10","A",12.5,58.8),
        Reporte(7,"san bartolo6","Se cayo un arbol"
            ,"N","2020,10,10","A",12.5,58.8)
    )

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_reporte)


    }
}