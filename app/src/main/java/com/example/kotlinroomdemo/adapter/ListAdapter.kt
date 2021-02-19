package com.example.kotlinroomdemo.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.Button
import android.widget.TextView
import com.example.kotlinroomdemo.R
import com.example.kotlinroomdemo.database.entity.Employee
import com.example.kotlinroomdemo.view.MainActivity

class ListAdapter constructor(private val context: Context, private val list: List<Employee>): BaseAdapter() {

    override fun getCount(): Int {
    return list.size
    }

    override fun getItem(position: Int): Employee {
        return list.get(position)
    }

    override fun getItemId(position: Int): Long {
        return position.toLong()
    }

    override fun getView(position: Int, convertView: View?, parent: ViewGroup?): View {
        val view: View
        val holder: ViewHolder
        val inflater: LayoutInflater
                = context.getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater

        if (convertView == null) {
            view = inflater.inflate(R.layout.list_item_layout, parent, false)
            holder = ViewHolder()
             holder.empName = view.findViewById(R.id.emp_name)
             holder.fatherName = view.findViewById(R.id.f_name)
             holder.mobileNumber = view.findViewById(R.id.mob_no)
             holder.email = view.findViewById(R.id.email)
             holder.department = view.findViewById(R.id.dep_name)
             holder.removeBtn = view.findViewById(R.id.delete)
             view.tag = holder
        } else {
            view = convertView
            holder = view.tag as ViewHolder
        }

        holder.empName.setText(list.get(position).name)
        holder.fatherName.setText(list.get(position).fatherName)
        holder.mobileNumber.setText(list.get(position).mobileNumber)
        holder.email.setText(list.get(position).email)
        holder.department.setText(list.get(position).department)

        holder.removeBtn.setOnClickListener(View.OnClickListener {
            list.get(position).empId?.let { it1 -> (context as MainActivity).deleteRecord(it1) }
            notifyDataSetChanged()
        })

        return  view
    }
    
    private class ViewHolder(){
        lateinit var empName: TextView
        lateinit var fatherName: TextView
        lateinit var mobileNumber: TextView
        lateinit var email: TextView
        lateinit var department: TextView
        lateinit var removeBtn:Button
    }
}