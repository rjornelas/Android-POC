package com.example.recyclerview

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.recyclerview.databinding.ActivityMainBinding
import com.example.recyclerview.model.User

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val users = getData()
        val newUsers = getData()
        val adapter = UserAdapter(users)

        binding.rvUser.adapter = adapter
        binding.fabSelectUsers.setOnClickListener{
            newUsers.add(
                User(id = -1,
                    name = "New",
                    lastName = "User"
                )
            )
            adapter.setData(newUsers)
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