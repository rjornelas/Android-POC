package com.example.recyclerview

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.recyclerview.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val users = mutableListOf<String>()

        repeat(100){
            users.add("Nome completo de um usuário $it")
        }

        binding.rvUser.adapter = UserAdapter(users){
            Toast.makeText(this, it, Toast.LENGTH_LONG).show()
        }
        binding.rvUser.addItemDecoration(DividerItemDecoration(this, LinearLayoutManager.VERTICAL))
    }
}