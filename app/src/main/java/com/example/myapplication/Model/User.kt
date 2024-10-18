package com.example.myapplication.Model

data class User(
    val nome: String,
    val sobrenome: String,
    val email: String,
    val senha: String,
    val dataNascimento: String,
    val planoSelecionado: String,
    val sexoSelecionado: String,
    val cep: String
)
