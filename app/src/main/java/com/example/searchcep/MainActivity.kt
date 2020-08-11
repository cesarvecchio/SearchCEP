@file:Suppress("DEPRECATION")

package com.example.searchcep

import android.graphics.Bitmap
import android.graphics.BitmapFactory
import android.os.Bundle
import android.os.Handler
import android.util.Log
import android.widget.Button
import android.widget.EditText
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import java.io.IOException
import java.io.InputStream
import java.net.HttpURLConnection
import java.net.URL

class MainActivity : AppCompatActivity() {

    val handler: Handler = Handler()

    lateinit var etMain_cep: EditText
    lateinit var btnMain_buscarCep: Button
    lateinit var etMain_resposta: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        etMain_cep = findViewById(R.id.etMain_cep)
        btnMain_buscarCep = findViewById(R.id.btnMain_buscarCep)
        etMain_resposta = findViewById(R.id.etMain_resposta)

        btnMain_buscarCep.setOnClickListener {

            var call: Call<CEP> = RetrofitConfig().getCEPService().buscarCEP(etMain_cep.text.toString())
            call.enqueue(object: Callback<CEP> {

                override fun onResponse(call: Call<CEP>, response: Response<CEP>) {
                    val cep: CEP? = response.body()
                    etMain_resposta.text = cep.toString()
                }
                override fun onFailure(call: Call<CEP>, t: Throwable) {
                    Log.e("CEPService ", "Erro ao buscar o cep: ${t.message}")
                }

            })

        }
    }

}