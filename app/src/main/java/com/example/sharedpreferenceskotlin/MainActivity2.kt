package com.example.sharedpreferenceskotlin

import android.content.Context
import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.AdapterView
import android.widget.AdapterView.OnItemSelectedListener
import android.widget.ArrayAdapter
import com.example.sharedpreferenceskotlin.databinding.ActivityMain2Binding

class MainActivity2 : AppCompatActivity() {
    private lateinit var binding: ActivityMain2Binding
    private lateinit var adapter: ArrayAdapter<CharSequence>

    // private lateinit var list:  ArrayList<String>?
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        // setContentView(R.layout.activity_main2)
        binding = ActivityMain2Binding.inflate(layoutInflater)
        setContentView(binding.root)
        val sharedPreferences = getSharedPreferences("Myfile", Context.MODE_PRIVATE)

        val list = ArrayList(sharedPreferences.all.keys)

        adapter = ArrayAdapter(
            this, R.layout.spinner_view,
            list.toMutableList() as List<CharSequence>
        )
        binding.spinner.adapter = adapter




        binding.spinner.onItemSelectedListener = object : OnItemSelectedListener {
            override fun onItemSelected(
                parent: AdapterView<*>?,
                view: View?,
                position: Int,
                id: Long
            ) {
                val sharedPreferences = getSharedPreferences("Myfile", Context.MODE_PRIVATE)
                binding.textView.text = sharedPreferences.getString(
                    binding.spinner.adapter.getItem(position) as String,
                    "0"
                )
            }
            override fun onNothingSelected(parent: AdapterView<*>?) {
            }
        }

        binding.delete.setOnClickListener {
            val sharedPreferences=getSharedPreferences("Myfile",Context.MODE_PRIVATE)

            sharedPreferences.edit().remove(binding.spinner.selectedItem.toString()).commit()


            val list = ArrayList(sharedPreferences.all.keys)

            adapter = ArrayAdapter(
                this, R.layout.spinner_view,
                list.toMutableList() as List<CharSequence>
            )
            binding.spinner.adapter = adapter
            binding.textView.text=""


        }


    }
}