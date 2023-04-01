package com.ergea.wordsapp.adapter

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.RecyclerView
import com.ergea.wordsapp.R
import com.ergea.wordsapp.databinding.ItemListWordBinding
import com.ergea.wordsapp.ui.WordDetailFragment


class DetailAdapter(private val list: List<String>) :
    RecyclerView.Adapter<DetailAdapter.ViewHolder>() {

    inner class ViewHolder(private val binding: ItemListWordBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(list: String) {
            binding.btnWord.text = list
            binding.btnWord.setOnClickListener {
                val uri = Uri.parse("https://www.google.com/search?q=${list}")
                val intent = Intent(Intent.ACTION_VIEW, uri)
                itemView.context.startActivity(intent)
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder =
        ViewHolder(
            ItemListWordBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )

    override fun onBindViewHolder(holder: ViewHolder, position: Int) =
        holder.bind(list[position])

    override fun getItemCount(): Int = list.size
}