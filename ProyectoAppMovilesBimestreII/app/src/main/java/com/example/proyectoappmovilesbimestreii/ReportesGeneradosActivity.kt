package com.example.proyectoappmovilesbimestreii

import android.annotation.SuppressLint
import android.app.Activity
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.activity.result.contract.ActivityResultContracts
import androidx.recyclerview.widget.RecyclerView

class ReportesGeneradosActivity : AppCompatActivity() {

    val lista = arrayListOf(
        Noticia(1,"Esta es la descripcion","2023-05-10",18.5,11.5),
        Noticia(2,"Esta es la descripcion numero2","2023-05-10",17.5,10.5),
        Noticia(3,"Esta es la descripcion numero3","2023-07-21",9.5,23.5),
        Noticia(4,"Esta es la descripcion numero4","2023-06-15",10.5,14.5),
        Noticia(5,"Esta es la descripcion numero5","2023-08-11",51.5,58.5)
    )

    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_reportes_generados)

        val recyclerView = findViewById<RecyclerView>(R.id.rv_noticia)
        inicializarRecyvlerView(lista,recyclerView)
    }


    fun inicializarRecyvlerView(lista:ArrayList<Noticia>,recyclerView: RecyclerView){
        val adapdtador = RV_Historia_Adapter(
            this,lista,recyclerView
        )
        recyclerView.adapter = adapdtador
        recyclerView.itemAnimator = androidx.recyclerview.widget.DefaultItemAnimator()
        recyclerView.layoutManager = androidx.recyclerview.widget.LinearLayoutManager(this)
        adapdtador.notifyDataSetChanged()
    }
}