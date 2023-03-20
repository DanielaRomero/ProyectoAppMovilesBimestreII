package com.example.proyectoappmovilesbimestreii

import android.annotation.SuppressLint
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.widget.Button
import android.widget.ImageButton
import android.widget.SearchView
import androidx.recyclerview.widget.RecyclerView
import java.util.*
import kotlin.collections.ArrayList

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

        val  recyclerView = findViewById<RecyclerView>(R.id.rv_reporte)
        inicializarRecyvlerView(datosQuemados,recyclerView)

        val btnNoticias = findViewById<ImageButton>(R.id.btn_notificacion)
        btnNoticias.setOnClickListener{
            irActividad(ReportesGeneradosActivity::class.java)
        }

        val botonUsuario = findViewById<ImageButton>(R.id.btn_usuario)
        botonUsuario.setOnClickListener(){
            //irActividad(LogOutActivity)
        }

        val botonNoticias = findViewById<ImageButton>(R.id.btn_notificacion)
        botonNoticias.setOnClickListener(){
            irActividad(ReportesGeneradosActivity::class.java)
        }

        val botonNuevoReporte = findViewById<Button>(R.id.btn_nuevo_reporte)
        botonNuevoReporte.setOnClickListener(){
            irActividad(NuevoReporteActivity::class.java)
        }
    }

    fun inicializarRecyvlerView(lista:ArrayList<Reporte>,recyclerView: RecyclerView){
        val adapdtador = RV_Adaptador_Reporte(
            this,lista,recyclerView
        )
        recyclerView.adapter = adapdtador
        recyclerView.itemAnimator = androidx.recyclerview.widget.DefaultItemAnimator()
        recyclerView.layoutManager = androidx.recyclerview.widget.LinearLayoutManager(this)
        adapdtador.notifyDataSetChanged()
    }

    fun borrar(id:Int,recyclerView: RecyclerView){
        datosQuemados.removeAt(id)
        inicializarRecyvlerView(datosQuemados, recyclerView)
    }
    fun irActividad(clase:Class<*>){
        val intent = Intent(this,clase)
        startActivity(intent)
    }
}