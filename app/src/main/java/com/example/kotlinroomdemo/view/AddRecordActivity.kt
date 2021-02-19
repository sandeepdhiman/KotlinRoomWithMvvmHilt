package com.example.kotlinroomdemo.view

import android.os.Bundle
import android.text.TextUtils
import android.util.Patterns
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar
import com.example.kotlinroomdemo.R
import com.example.kotlinroomdemo.database.entity.Employee
import com.example.kotlinroomdemo.viewmodel.AddRecordViewModel
import dagger.hilt.android.AndroidEntryPoint


@AndroidEntryPoint
class AddRecordActivity : AppCompatActivity(), View.OnClickListener {
    lateinit var submitBtn: Button
    lateinit var name : EditText
    lateinit var fatherName:EditText
    lateinit var mobileNumber:EditText
    lateinit var email : EditText
    lateinit var department :EditText

    val addRecordViewModel:AddRecordViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_add_record)
        initializeViews()
    }

    private fun  initializeViews(){
        val toolbar = findViewById<Toolbar>(R.id.toolbar)
        submitBtn = findViewById(R.id.submit)
        name = findViewById(R.id.name)
        fatherName = findViewById(R.id.father_name)
        mobileNumber = findViewById(R.id.mobile)
        email = findViewById(R.id.email)
        department = findViewById(R.id.department)

        submitBtn.setOnClickListener(this)

        toolbar.title = "Add Record"
        setSupportActionBar(toolbar)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        toolbar.setNavigationOnClickListener {
            finish()
        }
    }

    override fun onClick(v: View?) {
        if (name.text.toString() == ""){
            Toast.makeText(this, "Name can't be left empty", Toast.LENGTH_LONG).show()
        }else if(fatherName.text.toString().equals("")){
            Toast.makeText(this, "Father name can't be left empty", Toast.LENGTH_LONG).show()
        }else if (mobileNumber.text.toString() == "" && mobileNumber.text.toString().length<10){
          Toast.makeText(this, "Enter a valid mobile number", Toast.LENGTH_LONG).show()
        }else if (!isValidEmail(email.text.toString())){
           Toast.makeText(this,"Enter valid email address",Toast.LENGTH_LONG).show()
        }else{
            val employee = Employee(
                name.text.toString(),
                fatherName.text.toString(),
                email.text.toString(),
                mobileNumber.text.toString(),
                department.text.toString()
            )
            addRecordViewModel.insertRecord(employee)
            finish()
        }
    }

    fun isValidEmail(target: CharSequence?): Boolean {
        return if (TextUtils.isEmpty(target)) {
            false
        } else {
            Patterns.EMAIL_ADDRESS.matcher(target).matches()
        }
    }

}