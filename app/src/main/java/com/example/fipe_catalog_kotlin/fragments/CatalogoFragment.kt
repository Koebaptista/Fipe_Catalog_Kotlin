package com.example.fipe_catalog_kotlin.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.fipe_catalog_kotlin.R
import com.example.fipe_catalog_kotlin.adapter.CarroAdapter
import com.example.fipe_catalog_kotlin.data.DadosCatalogo

class CatalogoFragment : Fragment() {

    lateinit var recycler: RecyclerView

    var categoriaAtual = "todos"

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {

        val view = inflater.inflate(
            R.layout.fragment_catalogo,
            container,
            false
        )

        recycler = view.findViewById(R.id.recyclerCarros)
        recycler.layoutManager = LinearLayoutManager(requireContext())

        carregarCategoria("todos")

        view.findViewById<Button>(R.id.btnSUV).setOnClickListener {
            categoriaAtual = "suv"
            carregarCategoria(categoriaAtual)
        }

        view.findViewById<Button>(R.id.btnEconomicos).setOnClickListener {
            categoriaAtual = "economicos"
            carregarCategoria(categoriaAtual)
        }

        view.findViewById<Button>(R.id.btnEsportivos).setOnClickListener {
            categoriaAtual = "esportivos"
            carregarCategoria(categoriaAtual)
        }

        view.findViewById<Button>(R.id.btnLuxo).setOnClickListener {
            categoriaAtual = "luxo"
            carregarCategoria(categoriaAtual)
        }

        view.findViewById<Button>(R.id.btnEletricos).setOnClickListener {
            categoriaAtual = "eletricos"
            carregarCategoria(categoriaAtual)
        }

        return view
    }

    override fun onResume() {
        super.onResume()
        carregarCategoria(categoriaAtual)
    }

    fun carregarCategoria(cat: String){

        val lista = DadosCatalogo.getLista(cat)

        recycler.adapter = CarroAdapter(
            lista,
            requireContext()
        )
    }

}