package com.example.myapplication

import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class HistoricoActivity : AppCompatActivity() {

    private lateinit var recyclerView: RecyclerView
    private lateinit var buttonVoltar: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_historico) // Certifique-se de que o layout correto está sendo usado

        // Inicializando o RecyclerView
        recyclerView = findViewById(R.id.recycler_view_historico)
        recyclerView.layoutManager = LinearLayoutManager(this)

        // Lista de consultas
        val consultas = listOf(
            Consulta("01/01/2023", "Check-up", "Dr. João", "Odontologia"),
            Consulta("15/02/2023", "Dor de Dente", "Dra. Ana", "Endodontia"),
            Consulta("10/03/2023", "Limpeza", "Dr. Pedro", "Odontologia"),
            Consulta("22/04/2023", "Restauração", "Dra. Maria", "Dentística"),
            Consulta("05/05/2023", "Avaliação", "Dr. Lucas", "Ortodontia")
        )

        // Configurando o Adapter
        val adapter = HistoricoAdapter(consultas)
        recyclerView.adapter = adapter

        // Inicializando o botão Voltar
        buttonVoltar = findViewById(R.id.button_voltar_historico)
        buttonVoltar.setOnClickListener {
            finish() // Finaliza a atividade atual e retorna à anterior
        }
    }
}

// Data class para armazenar informações da consulta
data class Consulta(
    val data: String,
    val motivo: String,
    val medico: String,
    val especialidade: String
)
