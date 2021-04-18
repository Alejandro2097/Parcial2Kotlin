package com.example.parcial2

import android.content.DialogInterface
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.appcompat.app.AlertDialog
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.parcial2.adapter.StudentAdapter
import com.example.parcial2.data.Student
import com.example.parcial2.dialog.StudentDialog
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    private lateinit var adapter: StudentAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setupButtons()
        setupList()
    }
    private fun setupButtons() {
        addButton.setOnClickListener {
            val dialog = StudentDialog(this) { name, last, cc, tel ->
                addStudent(name, last, cc, tel)
            }
            dialog.show()
        }
    }
    private fun setupList() {
        val studets = mutableListOf(Student("DaVid Alejandro","Huertas Castellanos", "1012441263", "+57 3016958448" ),
                Student("Daniel Alfonso", "Cuellar Calvo", "123456789", "+57 3061536957"),
                Student("Jason David", "Pineda Serna", "123456789", "+57 130115682"),
                Student("Miguel Angel", "Perez Cifeuntes", "123456789", "+57 3016987525412"))
        adapter =  StudentAdapter(studets){ item ->
            deleteStudent(item)
        }
        studenttRecyclerView.adapter = adapter
        studenttRecyclerView.layoutManager = LinearLayoutManager(this)
    }
    private fun addStudent(name: String, last: String, cc :String, tel: String) {
        val student = Student(name, last, cc, tel )
        adapter.addStudent(student)
        adapter.notifyDataSetChanged()
    }
    private fun deleteStudent(product: Student) {
        val builder = AlertDialog.Builder(this@MainActivity)
        builder.setMessage("¿Esta seguro que desea eliminar al estudiante?")
                .setPositiveButton("Aceptar",
                        DialogInterface.OnClickListener { dialog, id ->
                            // FIRE ZE MISSILES!
                            adapter.deleteStudent(product)
                            adapter.notifyDataSetChanged()
                        })
                .setNegativeButton("Cancelar",
                        DialogInterface.OnClickListener { dialog, id ->
                            // User cancelled the dialog
                        })
        // Create the AlertDialog object and return it
        builder.create()
        builder.show()

    }
}