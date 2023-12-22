package com.example.recyclerview

import androidx.recyclerview.widget.DiffUtil
import com.example.recyclerview.model.User

class UserDiffUtil(
    private val oldList: List<User>,
    private val newList: List<User>

) : DiffUtil.Callback(){

    override fun getOldListSize(): Int = oldList.size

    override fun getNewListSize(): Int = newList.size

    override fun areItemsTheSame(oldItemPosition: Int, newItemPosition: Int): Boolean {
        return oldList[oldItemPosition].id == newList[newItemPosition].id
    }

    override fun areContentsTheSame(oldItemPosition: Int, newItemPosition: Int): Boolean {
        return when{
            oldList[oldItemPosition].name != newList[newItemPosition].name -> false
            oldList[oldItemPosition].lastName != newList[newItemPosition].lastName -> false
            else -> true
        }
    }
}