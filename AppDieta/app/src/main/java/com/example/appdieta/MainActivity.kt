package com.example.appdieta

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        val cuadroPeso : EditText = findViewById(R.id.editTextText2)

        val cuadroAltura : EditText = findViewById(R.id.editTextText3)

        val cuadroSalida : TextView = findViewById(R.id.textView3)

        val miBoton : Button = findViewById(R.id.miboton)

        miBoton.setOnClickListener{
            val pesoTexto = cuadroPeso.text.toString()
            val alturaTexto = cuadroAltura.text.toString()

            if (pesoTexto.isNotEmpty() && alturaTexto.isNotEmpty()){

                val peso = pesoTexto.toFloat()
                val altura = alturaTexto.toFloat()

                val IMC = calculaIMC(peso,altura)
                val resultado = queResultado(IMC)

                cuadroSalida.text = resultado
            } else {
                cuadroSalida.text = "Por favor, ingresa peso y altura."
            }
        }

    }
    private fun calculaIMC(peso: Float, altura: Float): Float {
        return  (peso / (altura * altura))
    }

    private fun queResultado(IMC: Float): String {
        return when {
            IMC < 18.5 -> "Usted sufre delgadez, debería comer más."
            IMC < 25 -> "Su estado de forma es bueno."
            IMC < 30 -> "Usted sufre sobrepeso, debería cuidarse y llamar a un dietista."
            else -> "Usted sufre obesidad, debería llamar a un médico urgentemente."
        }
    }

}