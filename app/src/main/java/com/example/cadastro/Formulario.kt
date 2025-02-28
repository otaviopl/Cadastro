package com.example.cadastro

data class Formulario(
    val nome: String,
    val telefone: String,
    val email: String,
    val listaEmail: Boolean,
    val sexo: String,
    val cidade: String,
    val uf: String
) {
    override fun toString(): String {
        return "Nome: $nome\nTelefone: $telefone\nE-mail: $email\n" +
                "Ingressar na lista: $listaEmail\nSexo: $sexo\nCidade: $cidade\nUF: $uf"
    }
}