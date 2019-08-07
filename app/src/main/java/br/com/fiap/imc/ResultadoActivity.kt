package br.com.fiap.imc

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.core.content.ContextCompat
import kotlinx.android.synthetic.main.activity_resultado.*

class ResultadoActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_resultado)

        calcular()
    }

    private fun calcular() {

        val peso = intent.getDoubleExtra("PESO", 0.0)
        val altura = intent.getDoubleExtra("ALTURA", 0.0)
        val sexo = intent.getStringExtra("SEXO") ?: getString(R.string.label_feminino)
        val imc = (peso / (altura * altura))

        tvIMC.text = imc.toFixed(2)

        when(sexo) {
            getString(R.string.label_masculino) -> calculoMasculino(imc)
            getString(R.string.label_feminino) -> calculoFeminino(imc)
            else -> {}
        }
    }

    private fun calculoFeminino(imc: Double) {
        if (imc < 19) {
            tvStatusIMC.text = "Abaixo do peso"
            configuraImagem(R.drawable.fem_abaixo)
        } else if (imc < 24) {
            tvStatusIMC.text = "Normal"
            configuraImagem(R.drawable.fem_ideal)
        } else if (imc < 29) {
            tvStatusIMC.text = "Obesidade leve"
            configuraImagem(R.drawable.fem_sobre)
        } else if (imc < 39) {
            tvStatusIMC.text = "Obesidade moderada"
            configuraImagem(R.drawable.fem_obeso)
        } else {
            tvStatusIMC.text = "Obesidade morbida"
            configuraImagem(R.drawable.fem_extremo_obeso)
        }
    }

    private fun calculoMasculino(imc: Double) {
        if (imc < 20) {
            tvStatusIMC.text = "Abaixo do peso"
            configuraImagem(R.drawable.masc_abaixo)
        } else if (imc < 25) {
            tvStatusIMC.text = "Normal"
            configuraImagem(R.drawable.masc_ideal)
        } else if (imc < 30) {
            tvStatusIMC.text = "Obesidade leve"
            configuraImagem(R.drawable.masc_sobre)
        } else if (imc < 40) {
            tvStatusIMC.text = "Obesidade moderada"
            configuraImagem(R.drawable.masc_obeso)
        } else {
            tvStatusIMC.text = "Obesidade morbida"
            configuraImagem(R.drawable.masc_extremo_obeso)
        }
    }

    private fun configuraImagem(resourceId: Int) {
        ivIMC.setImageDrawable(ContextCompat.getDrawable(this, resourceId))
    }
}
