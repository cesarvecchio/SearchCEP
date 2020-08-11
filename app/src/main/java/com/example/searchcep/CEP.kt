package com.example.searchcep

import com.fasterxml.jackson.annotation.JsonIgnoreProperties

@JsonIgnoreProperties("ibge", "gia", "unidade")
class CEP {
    var cep: String? = null
    var logradouro: String? = null
    var complemento: String? = null
    var bairro: String? = null
    var localidade: String? = null
    var uf: String? = null

    override fun toString(): String {
        return """
            CEP: $cep
            Logradouro: $logradouro
            Complemento: $complemento
            Bairro: $bairro
            Localidade:$localidade
            Uf: $uf
            """.trimIndent()
    }
}
