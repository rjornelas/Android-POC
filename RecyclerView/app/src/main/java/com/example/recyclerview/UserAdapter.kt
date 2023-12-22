package com.example.recyclerview

import android.util.SparseBooleanArray
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.CheckBox
import android.widget.RadioButton
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.recyclerview.databinding.ResItemUserBinding
import com.example.recyclerview.model.User

class UserAdapter(
    private val users: List<User>
) : RecyclerView.Adapter<UserAdapter.UserViewHolder>() {

    private var selectedPosition : Int = -1

    inner class UserViewHolder(itemView: ResItemUserBinding) : RecyclerView.ViewHolder(itemView.root){

    private val tvNameUser: TextView
    private val rbUser: RadioButton

    init{
        tvNameUser = itemView.tvNameUser
        rbUser = itemView.rbUser
    }

        fun bind(userName: String, position: Int){
            tvNameUser.text = userName
            rbUser.isChecked = (position == selectedPosition)
            rbUser.setOnClickListener() {
                val oldSelectedPosition = selectedPosition
                selectedPosition = position
                notifyItemChanged(oldSelectedPosition)
            }
        }

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