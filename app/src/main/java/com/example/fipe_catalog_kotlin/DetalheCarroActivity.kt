package com.example.fipe_catalog_kotlin

import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

import android.widget.CheckBox
import android.widget.Toast
import android.widget.Button
import java.text.NumberFormat
import java.util.Locale

class DetalheCarroActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detalhe_carro)

        val nome = intent.getStringExtra("nome")
        val descricao = intent.getStringExtra("descricao")
        val imagem = intent.getIntExtra("imagem", 0)

        val preco = intent.getDoubleExtra("preco", 0.0)
        val ano = intent.getIntExtra("ano", 2024)

        val txtNome = findViewById<TextView>(R.id.txtNomeDetalhe)
        val txtDescricao = findViewById<TextView>(R.id.txtDescricaoDetalhe)
        val img = findViewById<ImageView>(R.id.imgDetalhe)
        val txtPreco = findViewById<TextView>(R.id.txtPrecoDetalhe)
        val txtAno = findViewById<TextView>(R.id.txtAnoDetalhe)

        txtNome.text = nome
        txtDescricao.text = descricao
        img.setImageResource(imagem)

        txtPreco.text = formatarPreco(preco)

        txtAno.text = "📅 Ano: $ano"

        val btnVoltar = findViewById<Button>(R.id.btnVoltar)

        btnVoltar.setOnClickListener {
            finish()
        }

        val prefs = getSharedPreferences("favoritos", MODE_PRIVATE)
        val check = findViewById<CheckBox>(R.id.checkFavoritoDetalhe)

        check.isChecked = prefs.getBoolean(nome, false)

        check.setOnCheckedChangeListener { _, isChecked ->

            prefs.edit().putBoolean(nome, isChecked).apply()

            if (isChecked) {
                Toast.makeText(this, "$nome adicionado aos favoritos", Toast.LENGTH_SHORT).show()
            } else {
                Toast.makeText(this, "$nome removido dos favoritos", Toast.LENGTH_SHORT).show()
            }
        }
    }

    override fun onStart() {
        super.onStart()
        Toast.makeText(this, "Detalhes carregados", Toast.LENGTH_SHORT).show()
    }

    override fun onStop() {
        super.onStop()
        android.util.Log.d("CICLO", "Saiu da tela de detalhes")
    }
    fun formatarPreco(valor: Double): String {

        val formatador = NumberFormat.getCurrencyInstance(Locale("pt", "BR"))

        return formatador.format(valor)
    }
}

