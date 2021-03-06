package com.example.myapplication

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.myapplication.dao.User
import kotlinx.android.synthetic.main.fragment_detail.view.*
import kotlinx.android.synthetic.main.item_view.view.*

class MyAdapter : RecyclerView.Adapter<MyAdapter.ViewHolder>() {

    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        fun populateModel(user: User) {
            itemView.tvName.text = user.name
            itemView.setOnClickListener {
                onClick.invoke(user.id)
                favoriteClick.invoke(user)
            }
        }
    }

    private var onClick: (id: Int) -> Unit = {  }
    fun setOnItemClickListener(onClick: (id: Int) -> Unit) {
        this.onClick = onClick
    }

    private var favoriteClick : (user: User) -> Unit = {}
    fun setOnFavoriteClickListener(onClick: (user: User) -> Unit) {
        this.favoriteClick = onClick
    }

    var models: List<User> = listOf()
        @SuppressLint("NotifyDataSetChanged")
        set(value) {
            field = value
            notifyDataSetChanged()
        }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_view, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.populateModel(models[position])
    }

    override fun getItemCount() = models.size
}