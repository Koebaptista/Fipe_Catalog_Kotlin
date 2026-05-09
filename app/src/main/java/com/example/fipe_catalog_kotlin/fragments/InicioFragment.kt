package com.example.fipe_catalog_kotlin.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.fragment.app.Fragment
import com.example.fipe_catalog_kotlin.R
import com.example.fipe_catalog_kotlin.MainActivity

import android.widget.Toast
class InicioFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {

        val view = inflater.inflate(
            R.layout.fragment_inicio,
            container,
            false
        )

        view.findViewById<Button>(R.id.btnEntrar)
            .setOnClickListener {

                (activity as MainActivity)
                    .mostrarBottomNavigation()

                parentFragmentManager
                    .beginTransaction()
                    .replace(R.id.frameContainer, CatalogoFragment())
                    .commit()
            }

        return view
    }

    override fun onStart() {
        super.onStart()

        (activity as MainActivity).esconderBottomNavigation()
    }
}