package com.example.myapplication

import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class HistoricoActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_historico)

        val recyclerView = findViewById<RecyclerView>(R.id.recycler_view_historico)
        recyclerView.layoutManager = LinearLayoutManager(this)

        val consultas = listOf(
            Consulta("01/01/2023", "Check-up", "Dr. João", "Odontologia"),
            Consulta("15/02/2023", "Dor de Dente", "Dra. Ana", "Endodontia"),
            Consulta("10/03/2023", "Limpeza", "Dr. Pedro", "Odontologia"),
            Consulta("22/04/2023", "Restauração", "Dra. Maria", "Dentística"),
            Consulta("05/05/2023", "Avaliação", "Dr. Lucas", "Ortodontia")
        )

        val adapter = HistoricoAdapter(consultas)
        recyclerView.adapter = adapter

        // Botão Voltar
        val buttonVoltar = findViewById<Button>(R.id.button_voltar_historico)
        buttonVoltar.setOnClickListener {
            finish() // Fecha a atividade e volta para a anterior
        }
    }
}

data class Consulta(
    val data: String,
    val motivo: String,
    val medico: String,
    val especialidade: String
)
