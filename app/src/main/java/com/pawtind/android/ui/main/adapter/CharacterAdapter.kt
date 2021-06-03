package com.pawtind.android.ui.main.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.pawtind.android.R
import com.pawtind.android.data.model.User
import kotlinx.android.synthetic.main.item_layout.view.*

class CharacterAdapter(
    private val users: ArrayList<String>
) : RecyclerView.Adapter<CharacterAdapter.DataViewHolder>() {

    class DataViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        fun bind(user: String) {
            itemView.character_title_tv.text = user

        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) =
        DataViewHolder(
            LayoutInflater.from(parent.context).inflate(
                R.layout.item_layout, parent,
                false
            )
        )

    override fun getItemCount(): Int = users.size

    override fun onBindViewHolder(holder: DataViewHolder, position: Int) =
        holder.bind(users[position])

    fun addData(list: List<String>) {
        users.addAll(list)
    }

}