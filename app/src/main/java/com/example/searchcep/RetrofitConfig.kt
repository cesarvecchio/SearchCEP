package com.example.searchcep

import retrofit2.Call
import retrofit2.Retrofit
import retrofit2.converter.jackson.JacksonConverterFactory
import retrofit2.http.GET
import retrofit2.http.Path

class RetrofitConfig {
    private val retrofit: Retrofit

    init {
        retrofit = Retrofit.Builder()
            .baseUrl("https://viacep.com.br/ws/")
            .addConverterFactory(JacksonConverterFactory.create())
            .build()
    }

    fun getCEPService(): CEPService {
        return retrofit.create(CEPService::class.java)
    }

}


interface CEPService {

    // continuação do endpoint
    @GET("{cep}/json")
    fun buscarCEP(@Path("cep") cep: String): Call<CEP>
}
