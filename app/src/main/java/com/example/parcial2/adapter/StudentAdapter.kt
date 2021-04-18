package com.example.parcial2.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.parcial2.R
import com.example.parcial2.data.Student
import kotlinx.android.synthetic.main.data_student.*
import kotlinx.android.synthetic.main.data_student.view.*

class StudentAdapter(val studets:MutableList<Student>, val callback:(Student) -> Unit): RecyclerView.Adapter<StudentAdapter.StudentViewHolder>() {

    class StudentViewHolder(itemView: View, val callback:(Student) -> Unit): RecyclerView.ViewHolder(itemView) {
        fun bind(item: Student){
            itemView.nameTextview.text = item.name
            itemView.lastTextview.text = item.last
            itemView.ccTextview.text = item.cc
            itemView.telTextview.text = item.tel
            itemView.deleteButom.setOnClickListener {
                callback(item)
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): StudentViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.data_student, parent, false)
        return StudentViewHolder(view, callback)
    }

    override fun onBindViewHolder(holder: StudentViewHolder, position: Int) {
        holder.bind(studets[position])
    }

    override fun getItemCount(): Int {
        return studets.size
    }
    fun addStudent(student: Student) {
        studets.add(student)
    }

    fun deleteStudent(student: Student) {
        studets.remove(student)
    }
}