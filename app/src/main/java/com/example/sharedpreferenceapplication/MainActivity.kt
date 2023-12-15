package com.example.sharedpreferenceapplication

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.EditText

class MainActivity : AppCompatActivity() {
    lateinit var name:EditText
    lateinit var age:EditText
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        name=findViewById(R.id.etName)
        age=findViewById(R.id.etAge)
    }

    override fun onResume() {
        super.onResume()
        // Fetching the stored data from the SharedPreference

       val sh=getSharedPreferences("MySharedPref", MODE_PRIVATE)
        val s1=sh.getString("name","")
        val s2=sh.getInt("age",0)
        Log.v("age","$s2")
        // Setting the fetched data in the EditTexts
        name.setText(s1)
        age.setText(s2.toString())


    }
    // Store the data in the SharedPreference in the onPause() method
    // When the user closes the application onPause() will be called and data will be stored

    override fun onPause() {
        super.onPause()
        val sharedPreferen=getSharedPreferences("MySharedPref", MODE_PRIVATE)
        val myEdit=sharedPreferen.edit()
        myEdit.putString("name",name.text.toString())
        myEdit.putInt("age",age.text.toString().toInt())
        myEdit.apply()


    }
}