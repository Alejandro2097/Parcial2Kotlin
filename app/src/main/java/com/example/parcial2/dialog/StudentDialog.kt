package com.example.parcial2.dialog

import android.app.Dialog
import android.content.Context
import android.os.Bundle
import com.example.parcial2.R
import kotlinx.android.synthetic.main.data_student.*
import kotlinx.android.synthetic.main.dialog_student.*

class StudentDialog(context: Context, private val callback: (String, String, String, String) -> Unit) : Dialog(context) {
    override fun onCreate(savedInstanceState: Bundle?){
        super.onCreate(savedInstanceState)
        setContentView(R.layout.dialog_student)
        saveButton.setOnClickListener {
            val name = nameEditText.text.toString()
            val last = lastnameEditText.text.toString()
            val cc = ccEditText.text.toString()
            val tel = telEditText.text.toString()
            callback(name, last, cc, tel)
            dismiss()
        }
    }
}