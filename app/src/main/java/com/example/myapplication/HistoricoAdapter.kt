package com.example.myapplication

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class HistoricoAdapter(private val consultas: List<Consulta>) : RecyclerView.Adapter<HistoricoAdapter.ViewHolder>() {

    class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val textData: TextView = view.findViewById(R.id.text_data)
        val textMotivo: TextView = view.findViewById(R.id.text_motivo)
        val textMedico: TextView = view.findViewById(R.id.text_medico)
        val textEspecialidade: TextView = view.findViewById(R.id.text_especialidade)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_historico, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val consulta = consultas[position]
        holder.textData.text = consulta.data
        holder.textMotivo.text = "Motivo: ${consulta.motivo}"
        holder.textMedico.text = "Médico: ${consulta.medico}"
        holder.textEspecialidade.text = "Especialidade: ${consulta.especialidade}"
    }

    override fun getItemCount() = consultas.size
}
