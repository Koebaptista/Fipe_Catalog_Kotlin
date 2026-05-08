package com.example.fipe_catalog_kotlin

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import com.example.fipe_catalog_kotlin.databinding.ActivityMainBinding
import com.example.fipe_catalog_kotlin.fragments.CatalogoFragment
import com.example.fipe_catalog_kotlin.fragments.FavoritosFragment
import com.example.fipe_catalog_kotlin.fragments.SobreFragment
import com.example.fipe_catalog_kotlin.fragments.InicioFragment
import android.view.View
class MainActivity : AppCompatActivity() {

    lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        substituirFragment(InicioFragment())
        binding.bottomNavigation.visibility = View.GONE

        binding.bottomNavigation.setOnItemSelectedListener {

            when(it.itemId){

                R.id.menu_catalogo -> {
                    substituirFragment(CatalogoFragment())
                }

                R.id.menu_favoritos -> {
                    substituirFragment(FavoritosFragment())
                }

                R.id.menu_sobre -> {
                    substituirFragment(SobreFragment())
                }
            }

            true
        }
    }

    fun substituirFragment(fragment: Fragment){

        supportFragmentManager
            .beginTransaction()
            .replace(R.id.frameContainer, fragment)
            .commit()
    }

    fun mostrarBottomNavigation(){
        binding.bottomNavigation.visibility = View.VISIBLE
    }

    fun esconderBottomNavigation(){
        binding.bottomNavigation.visibility = View.GONE
    }
}