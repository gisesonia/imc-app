package com.example.imc_app

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.core.widget.doAfterTextChanged
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setListeners()
    }

    private fun setListeners() {
        alturaEDT?.doAfterTextChanged { text ->

        }

        pesoEDT?.doAfterTextChanged { text ->

        }

        calcularBTN?.setOnClickListener {
            calcularIMC(pesoEDT.text.toString(), alturaEDT.text.toString())
        }
    }

    private fun calcularIMC(peso: String, altura: String) {
        val peso = peso.toFloatOrNull()
        val altura = altura.toFloatOrNull()

        if(peso != null && altura != null) {
            val imc = peso / (altura * altura)
            titleTXT.text = "Seu IMC %.2f".format(imc)
        }
    }
}