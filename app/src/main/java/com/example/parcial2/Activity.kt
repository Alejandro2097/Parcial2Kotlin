package com.example.parcial2


import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.activity_second.*

class Activity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_second)

        btn_hora.setOnClickListener{
            mostrarFragmentoHora()

        }

        btn_imagen.setOnClickListener{
            mostrarFragmentoImagen()

        }

        btn_atras.setOnClickListener{
            finish()
        }

    }

    private fun mostrarFragmentoHora(){
        val transaction = supportFragmentManager.beginTransaction()
        transaction.replace(R.id.container, HoraFragment(), null )
        transaction.commit()
    }

    private fun mostrarFragmentoImagen(){
        val transaction = supportFragmentManager.beginTransaction()
        transaction.replace(R.id.container, ImagenFragment(), null )
        transaction.commit()
    }
}