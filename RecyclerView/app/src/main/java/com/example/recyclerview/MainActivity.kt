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
        val adapter = UserAdapter(users)

        binding.rvUser.adapter = adapter
        binding.fabSelectUsers.setOnClickListener{
            adapter.addNewUser(
                User(
                    -1,
                    "New",
                    "User"
                )
            )
        }
    }

    private fun getData(): MutableList<User> {
        val users = mutableListOf<User>()

        repeat(5) {
            users.add(
                User(
                    id = it.toLong(),
                    name = "Name",
                    lastName = "Lastname"
                )
            )
        }
        return users
    }
}