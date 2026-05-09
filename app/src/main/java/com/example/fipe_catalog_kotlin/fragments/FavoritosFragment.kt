package com.example.fipe_catalog_kotlin.fragments

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.fipe_catalog_kotlin.R
import com.example.fipe_catalog_kotlin.adapter.CarroAdapter
import com.example.fipe_catalog_kotlin.data.DadosCatalogo
import com.example.fipe_catalog_kotlin.model.Carro

class FavoritosFragment : Fragment() {

    lateinit var recycler: RecyclerView

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {

        val view = inflater.inflate(
            R.layout.fragment_favoritos,
            container,
            false
        )

        recycler = view.findViewById(R.id.recyclerFavoritos)
        recycler.layoutManager = LinearLayoutManager(requireContext())

        atualizarLista()

        return view
    }

    fun carregarFavoritos(): List<Carro>{

        val prefs = requireContext()
            .getSharedPreferences("favoritos", Context.MODE_PRIVATE)

        val todasListas = listOf(
            DadosCatalogo.getLista("suv"),
            DadosCatalogo.getLista("economicos"),
            DadosCatalogo.getLista("esportivos"),
            DadosCatalogo.getLista("luxo"),
            DadosCatalogo.getLista("eletricos")
        )

        val favoritos = mutableListOf<Carro>()

        for(lista in todasListas){

            for(carro in lista){

                if(prefs.getBoolean(carro.nome,false)){

                    favoritos.add(carro)
                }
            }
        }

        return favoritos
    }

    fun atualizarLista(){

        val lista = carregarFavoritos()

        if(lista.isEmpty()){

            Toast.makeText(
                requireContext(),
                "Nenhum favorito ainda",
                Toast.LENGTH_SHORT
            ).show()
        }

        recycler.adapter = CarroAdapter(
            lista,
            requireContext()
        ) {
            atualizarLista()
        }
    }

    override fun onResume() {
        super.onResume()
        atualizarLista()
    }

    override fun onPause() {
        super.onPause()
        // simula pausa de atualização de dados
    }
}