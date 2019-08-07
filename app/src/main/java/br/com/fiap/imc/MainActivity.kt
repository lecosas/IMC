package br.com.fiap.imc

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        btCalcular.setOnClickListener {
            var proximaTela = Intent(this, ResultadoActivity::class.java)
            proximaTela.putExtra("PESO", inputPeso.text.toString().toDouble())
            proximaTela.putExtra("ALTURA", inputAltura.text.toString().toDouble())
            proximaTela.putExtra("SEXO", spSexo.selectedItem.toString())
            startActivity(proximaTela)
        }

        btLimpar.setOnClickListener {
            inputAltura.setText("")
            inputPeso.setText("")
        }
    }
}
