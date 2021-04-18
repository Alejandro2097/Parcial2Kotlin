package com.example.parcial2


import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class Activity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_second)

        var button1 = findViewById<Button>(R.id.btn_hora)
        var button2 = findViewById<Button>(R.id.btn_imagen)

        button1.setOnClickListener{
            mostrarFragmentoHora()

        }

        button2.setOnClickListener{
            mostrarFragmentoImagen()

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