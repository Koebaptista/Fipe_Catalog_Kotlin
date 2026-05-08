package com.example.fipe_catalog_kotlin.model

data class Carro(
    val nome: String,
    val descricao: String,
    val imagem: Int,
    val preco: Double,
    val ano: Int,
    var favorito: Boolean = false
)