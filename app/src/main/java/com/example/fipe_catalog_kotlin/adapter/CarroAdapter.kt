package com.example.fipe_catalog_kotlin.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.CheckBox
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import com.example.fipe_catalog_kotlin.model.Carro
import com.example.fipe_catalog_kotlin.R

import android.content.Intent
import com.example.fipe_catalog_kotlin.DetalheCarroActivity

import java.text.NumberFormat
import java.util.Locale

class CarroAdapter(
    private val lista: List<Carro>,
    private val context: Context,
    private val onFavoritoAlterado: (() -> Unit)? = null
) : RecyclerView.Adapter<CarroAdapter.ViewHolder>() {

    class ViewHolder(view: View): RecyclerView.ViewHolder(view){
        val nome: TextView = view.findViewById(R.id.txtNome)
        val descricao: TextView = view.findViewById(R.id.txtDescricao)
        val check: CheckBox = view.findViewById(R.id.checkFavorito)
        val imagem: ImageView = view.findViewById(R.id.imgCarro)
        val preco: TextView = view.findViewById(R.id.txtPreco)
        val ano: TextView = view.findViewById(R.id.txtAno)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder{
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_carro,parent,false)
        return ViewHolder(view)
    }

    override fun getItemCount() = lista.size

    override fun onBindViewHolder(holder: ViewHolder, position: Int){
        val carro = lista[position]

        holder.nome.text = carro.nome
        holder.descricao.text = carro.descricao

        holder.preco.text = formatarPreco(carro.preco)

        holder.imagem.setImageResource(carro.imagem)
        holder.ano.text = "📅 Ano: ${carro.ano}"

        holder.itemView.setOnClickListener {

            val intent = Intent(context, DetalheCarroActivity::class.java)

            intent.putExtra("nome", carro.nome)
            intent.putExtra("descricao", carro.descricao)
            intent.putExtra("imagem", carro.imagem)
            intent.putExtra("preco", carro.preco)
            intent.putExtra("ano", carro.ano)

            context.startActivity(intent)
        }

        val prefs = context.getSharedPreferences("favoritos", Context.MODE_PRIVATE)

        holder.check.isChecked = prefs.getBoolean(carro.nome,false)

        holder.check.setOnCheckedChangeListener{_,isChecked->

            prefs.edit().putBoolean(carro.nome,isChecked).apply()

            if(isChecked){
                Toast.makeText(context, carro.nome + " adicionado aos favoritos", Toast.LENGTH_SHORT).show()
            }else{
                Toast.makeText(context, carro.nome + " removido dos favoritos", Toast.LENGTH_SHORT).show()

                onFavoritoAlterado?.invoke()
            }
        }
    }
    fun formatarPreco(valor: Double): String {

        val formatador = NumberFormat.getCurrencyInstance(Locale("pt", "BR"))

        return formatador.format(valor)
    }
}