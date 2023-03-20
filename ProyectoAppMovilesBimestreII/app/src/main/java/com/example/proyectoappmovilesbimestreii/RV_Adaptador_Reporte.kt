package com.example.proyectoappmovilesbimestreii

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.recyclerview.widget.RecyclerView
import java.lang.reflect.Type
import java.text.FieldPosition
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView.LayoutManager

class RV_Adaptador_Reporte(
    private val contexto: ReporteActivity,
    private val lista:ArrayList<Reporte>,
    private val recyclerView: RecyclerView
):RecyclerView.Adapter<RV_Adaptador_Reporte.MyViewHolder>() {

    inner class MyViewHolder(view: View):RecyclerView.ViewHolder(view){
        val id: TextView
        val descripcion:TextView
        val estado:TextView
        val fecha:TextView
        val parroquia:TextView
        val prioridad:TextView
        val ubicacion:TextView

        init {

            id = view.findViewById(R.id.tv_reporte_id)
            descripcion = view.findViewById(R.id.tv_reporte_descripcion)
            estado = view.findViewById(R.id.tv_reporte_estado)
            fecha = view.findViewById(R.id.tv_reporte_fecha)
            parroquia = view.findViewById(R.id.tv_reporte_parroquia)
            prioridad = view.findViewById(R.id.tv_reporte_prioridad)
            ubicacion = view.findViewById(R.id.tv_reporte_ubicacion)
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val itemView = LayoutInflater
            .from(parent.context)
            .inflate(R.layout.item_reporte,parent,false)
        return MyViewHolder(itemView)
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        val reporteActual = this.lista[position]
        holder.id.text=reporteActual.id.toString()
        holder.descripcion.text = reporteActual.descripcion
        holder.estado.text = reporteActual.estadoActual
        holder.fecha.text = reporteActual.fecha
        holder.parroquia.text = reporteActual.parroquia
        holder.prioridad.text = reporteActual.prioridad
        holder.ubicacion.text = reporteActual.ubicacionX.toString() + reporteActual.ubicacionY.toString()
    }

    override fun getItemCount(): Int {
        return  this.lista.size
    }
}