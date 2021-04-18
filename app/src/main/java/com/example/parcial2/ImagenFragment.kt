package com.example.parcial2

import android.os.Bundle
import android.view.LayoutInflater
import androidx.fragment.app.Fragment
import android.view.View
import android.view.ViewGroup
import kotlinx.android.synthetic.main.fragment_imagen.*

class ImagenFragment : Fragment() {
    var onLine = false
    override fun onCreateView(
            inflater: LayoutInflater, container: ViewGroup?,
            savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_imagen, container, false)
    }


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {

        super.onViewCreated(view, savedInstanceState)
        val imgResId = R.drawable.ic_baseline_wifi_off_24
        imagenView.setImageResource(imgResId)
        button_imagen.setOnClickListener(){
            if(!onLine){
                onLine = true
                val imgResIdNew = R.drawable.ic_baseline_wifi_24
                imagenView.setImageResource(imgResIdNew)
                button_imagen.text = "Desconectar"
            }else{
                onLine = false
                val imgResIdNew = R.drawable.ic_baseline_wifi_off_24
                imagenView.setImageResource(imgResIdNew)
                button_imagen.text = "Conectar"
            }
        }
    }
}