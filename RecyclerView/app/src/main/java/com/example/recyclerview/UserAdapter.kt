package com.example.recyclerview

import android.util.SparseBooleanArray
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.CheckBox
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.recyclerview.databinding.ResItemUserBinding
import com.example.recyclerview.model.User

class UserAdapter(
    private val users: MutableList<User>
) : RecyclerView.Adapter<UserAdapter.UserViewHolder>() {

    private val userStateArray = SparseBooleanArray()

    inner class UserViewHolder(itemView: ResItemUserBinding) : RecyclerView.ViewHolder(itemView.root){

    private val tvNameUser: TextView
    private val cbUser: CheckBox

    init{
        tvNameUser = itemView.tvNameUser
        cbUser = itemView.cbUser
    }

        fun bind(userName: String, position: Int){
            tvNameUser.text = userName
            cbUser.isChecked = userStateArray[position, false]
            cbUser.setOnClickListener() {
                userStateArray.put(position, cbUser.isChecked)
            }
        }

    }

    fun addNewUser(user: User){
        users.add(user)
        notifyItemInserted(users.size - 1)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): UserViewHolder {
        val resItemUserBinding = ResItemUserBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return UserViewHolder(resItemUserBinding)
    }

    override fun onBindViewHolder(holder: UserViewHolder, position: Int) {
        holder.bind(users[position].fullName, position)
    }

    override fun getItemCount(): Int {
        return users.size
    }

}