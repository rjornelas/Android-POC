package com.example.recyclerview

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.recyclerview.databinding.ActivityMainBinding
import com.example.recyclerview.model.User

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val users = getData()

        binding.rvUser.adapter = UserAdapter(users)
    }

    private fun getData(): MutableList<User> {
        val users = mutableListOf<User>()

        repeat(100) {
            users.add(
                User(
                    id = it.toLong(),
                    name = "Nome",
                    lastName = "Sobrenome"
                )
            )
        }
        return users
    }
}