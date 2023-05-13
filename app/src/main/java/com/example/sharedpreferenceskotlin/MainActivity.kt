package com.example.sharedpreferenceskotlin

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.LayoutInflater
import com.example.sharedpreferenceskotlin.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        // setContentView(R.layout.activity_main)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

          binding.get.setOnClickListener {


              val intent=Intent(this,MainActivity2::class.java)
              startActivity(intent)
          }

        binding.set.setOnClickListener {
            val sharedPreferences = getSharedPreferences("Myfile",Context.MODE_PRIVATE)
            val editor = sharedPreferences.edit()
            editor.putString(binding.key.text.toString(),binding.note.text.toString())
            editor.commit()
            binding.key.setText("")
            binding.note.setText("")
        }


    }



}