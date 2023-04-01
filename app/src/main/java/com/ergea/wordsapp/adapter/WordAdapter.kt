package com.ergea.wordsapp.adapter

import android.os.Bundle
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.RecyclerView
import com.ergea.wordsapp.R
import com.ergea.wordsapp.databinding.ItemListWordBinding
import com.ergea.wordsapp.databinding.ItemListWordBinding.inflate
import com.ergea.wordsapp.ui.WordDetailFragment



class WordAdapter(private val list: List<Char>) :
    RecyclerView.Adapter<WordAdapter.ViewHolder>() {

    inner class ViewHolder(private val binding: ItemListWordBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(list: Char) {
            binding.btnWord.text = list.toString()

            binding.btnWord.setOnClickListener {
                val appCompatActivity = it.context as AppCompatActivity
                val mFragmentManager = appCompatActivity.supportFragmentManager
                val mDetailLetterFragment = WordDetailFragment()
                val fragment =
                    mFragmentManager.findFragmentByTag(WordDetailFragment::class.java.simpleName)

                if (fragment !is WordDetailFragment) {
                    val bundle = Bundle()
                    bundle.putString("EXTRA_WORD", list.toString())
                    mDetailLetterFragment.arguments = bundle

                    mFragmentManager
                        .beginTransaction()
                        .replace(
                            R.id.frameContainer,
                            mDetailLetterFragment,
                            WordDetailFragment::class.java.simpleName
                        )
                        .addToBackStack(null)
                        .commit()
                }
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder =
        ViewHolder(inflate(LayoutInflater.from(parent.context), parent, false))

    override fun onBindViewHolder(holder: ViewHolder, position: Int) =
        holder.bind(list[position])

    override fun getItemCount(): Int = list.size
}
