package com.example.kotlinroomdemo.view

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.ListView
import android.widget.Toast
import androidx.activity.viewModels
import androidx.appcompat.widget.Toolbar
import androidx.lifecycle.Observer
import com.example.kotlinroomdemo.R
import com.example.kotlinroomdemo.adapter.ListAdapter
import com.example.kotlinroomdemo.viewmodel.MainViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : AppCompatActivity(), View.OnClickListener {
    lateinit var listView: ListView
    lateinit var toolbar: Toolbar
    lateinit var addBtn : Button
    val mainViewModel: MainViewModel by  viewModels()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        initializeViews()


    }

    override fun onResume() {
        super.onResume()
        getEmpRecords()
    }
    private fun  initializeViews(){
        listView = findViewById(R.id.listview)
        toolbar = findViewById(R.id.toolbar)
        addBtn = findViewById(R.id.add)
        addBtn.visibility = View.VISIBLE

        addBtn.setOnClickListener(this)


        setSupportActionBar(toolbar)
    }

    private fun getEmpRecords(){
         mainViewModel.getAllEmpRecords()?.observe(this, Observer {
             if (it.isNotEmpty()){
                 val adapter = ListAdapter(this,it)
                 listView.adapter = adapter
             }else{
                 Toast.makeText(this,"Empty list",Toast.LENGTH_LONG).show()
             }
         })
    }

    override fun onClick(v: View?) {
        startActivity(Intent(this,AddRecordActivity::class.java))
    }

    fun deleteRecord(id:Int){
        mainViewModel.removeRecord(id)
    }
}
