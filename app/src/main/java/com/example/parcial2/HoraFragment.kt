package com.example.parcial2

import android.app.TimePickerDialog
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TimePicker
import androidx.fragment.app.Fragment
import kotlinx.android.synthetic.main.fragment_hora.*
import java.util.*

class HoraFragment : Fragment() {


    override fun onCreateView(
            inflater: LayoutInflater, container: ViewGroup?,
            savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_hora, container, false)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        button_cambiar.setOnClickListener {
            val mTimePicker: TimePickerDialog
            val mcurrentTime = Calendar.getInstance()
            val hour = mcurrentTime.get(Calendar.HOUR_OF_DAY)
            val minute = mcurrentTime.get(Calendar.MINUTE)

            mTimePicker = TimePickerDialog(context, object : TimePickerDialog.OnTimeSetListener {
                override fun onTimeSet(view: TimePicker?, hourOfDay: Int, minute: Int) {
                    when{
                        (hourOfDay < 12 ) ->{
                            print("ENTRO A LA TERCERA VALIDACION")
                            textview_hora.setText(String.format("%d : %d AM", hourOfDay, minute))
                        }
                        (hourOfDay >= 12 ) ->{
                            print("ENTRO A LA CUARTA VALIDACION")
                            textview_hora.setText(String.format("%d : %d PM", hourOfDay, minute))
                        }
                    }
                }
            }, hour, minute, false)
            mTimePicker.show()
        }
    }
}