package com.dicoding.asclepius.ui.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView.ViewHolder
import com.bumptech.glide.Glide
import com.dicoding.asclepius.utils.Util
import com.dicoding.asclepius.data.remote.response.ArticlesItem
import com.dicoding.asclepius.databinding.ItemRowBinding

class NewsAdapter : ListAdapter<ArticlesItem, NewsAdapter.MyViewHolder>(Util.DIFF_CALLBACK) {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val view = ItemRowBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return MyViewHolder(view)
    }


    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        val news = getItem(position)
        holder.bind(news)
    }

    class MyViewHolder(private val binding: ItemRowBinding) :
        ViewHolder(binding.root) {
        fun bind(news: ArticlesItem) {
            binding.tvItemTitle.text = news.title
            binding.tvDescription.text = news.description
            Glide.with(itemView.context)
                .load(news.urlToImage)
                .centerCrop()
                .into(binding.imgPoster)
        }
    }
}