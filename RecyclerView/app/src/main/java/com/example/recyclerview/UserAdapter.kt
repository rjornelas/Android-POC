package com.example.recyclerview

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.recyclerview.databinding.ResItemUserBinding

class UserAdapter(
    private val users: List<String>
) : RecyclerView.Adapter<UserAdapter.UserViewHolder>() {

    inner class UserViewHolder(itemView: ResItemUserBinding) : RecyclerView.ViewHolder(itemView.root){

    private val tvNameUser: TextView

    init{
        tvNameUser = itemView.tvNameUser
    }

        fun bind(userName: String){
            tvNameUser.text = userName
        }

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): UserViewHolder {
        val resItemUserBinding = ResItemUserBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return UserViewHolder(resItemUserBinding)
    }

    override fun onBindViewHolder(holder: UserViewHolder, position: Int) {
        holder.bind(users[position])
    }

    override fun getItemCount(): Int {
        return users.size
    }

}