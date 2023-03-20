package com.example.proyectoappmovilesbimestreii

import android.app.Activity
import android.content.Intent
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import androidx.activity.result.contract.ActivityResultContracts
import androidx.core.content.ContextCompat.startActivity
import androidx.recyclerview.widget.RecyclerView

class RV_Historia_Adapter(
    private val contexto:ReportesGeneradosActivity,
    private val lista:ArrayList<Noticia>,
    private val recyclerView: RecyclerView
):RecyclerView.Adapter<RV_Historia_Adapter.MyViewHolder>() {
    inner class MyViewHolder(view: View):RecyclerView.ViewHolder(view){
        val fecha:TextView
        val descripcion:TextView
        val btnPosicion:Button
        val img:ImageView
        val id:TextView

        init {
            fecha=view.findViewById(R.id.tv_historia_fecha)
            descripcion = view.findViewById(R.id.tv_historia_descripcion)
            btnPosicion = view.findViewById(R.id.btn_historia_mapa)
            img = view.findViewById(R.id.iv_historia)
            id=view.findViewById(R.id.tv_id)
            btnPosicion.setOnClickListener {
                val al = lista[id.text.toString().toInt()].ubicacionY
                val la = lista[id.text.toString().toInt()].ubicacionX
                Log.i("test",al.toString())
                Log.i("test",la.toString())
                abrirActividadConParametros(MapaDesastresActivity::class.java,al,la)
            }
        }

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val itemView = LayoutInflater
            .from(parent.context)
            .inflate(R.layout.item_noticia,
                parent,
                false)
        return MyViewHolder(itemView)
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        val noticiaActual = this.lista[position]
        holder.id.text = position.toString()
        holder.fecha.text = noticiaActual.fecha
        holder.descripcion.text = noticiaActual.descripcion
        when(noticiaActual.id){
            1->holder.img.setImageResource(R.drawable.a2)
            2->holder.img.setImageResource(R.drawable.a3)
            3->holder.img.setImageResource(R.drawable.a4)
            4->holder.img.setImageResource(R.drawable.a5)
            else->holder.img.setImageResource(R.drawable.a6)
        }
    }

    override fun getItemCount(): Int {
        return this.lista.size
    }


    fun abrirActividadConParametros(clase:Class<*>,latitud:Double?,altitud:Double?){
        val intentExplicito = Intent(contexto,clase)
        intentExplicito.putExtra("coordenadas", arrayOf(latitud,altitud))
        startActivity(contexto,intentExplicito,null)
    }

}