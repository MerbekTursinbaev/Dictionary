package com.example.myapplication

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.myapplication.dao.User
import kotlinx.android.synthetic.main.item_view.view.*

class IsSelectedAdapter : RecyclerView.Adapter<IsSelectedAdapter.ViewHolder>() {

    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        fun populateModel(user: User) {
            itemView.tvName.text = user.name
            itemView.setOnClickListener {
                onClick.invoke(user)
                //favoriteClick.invoke(user)
            }
        }
    }

    private var onClick: (user: User) -> Unit = {}
    fun setOnItemClickListener( onClick: ( user: User ) -> Unit) {
        this.onClick = onClick
    }

    private var favoriteClick : (user: User) -> Unit = {}
    fun setOnFavoriteClickListener(onClick: (user: User) -> Unit) {
        this.favoriteClick = onClick
    }

    var modelsSelected: List<User> = listOf()
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
        holder.populateModel(modelsSelected[position])
    }

    override fun getItemCount() = modelsSelected.size
}