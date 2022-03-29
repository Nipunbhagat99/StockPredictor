package com.example.stockpredicter.activities

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.stockpredicter.R
import com.example.stockpredicter.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding : ActivityMainBinding
            
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)

        setContentView(binding.root)


        binding.btnPredict.setOnClickListener{
            val intent = Intent(this , NavigationActivity::class.java)
            startActivity(intent)
            finish()
        }


    }
}