package com.dicoding.asclepius.utils

import androidx.recyclerview.widget.DiffUtil
import com.dicoding.asclepius.data.remote.response.ArticlesItem

object Util {
    val DIFF_CALLBACK = object : DiffUtil.ItemCallback<ArticlesItem>() {
        override fun areItemsTheSame(oldItem: ArticlesItem, newItem: ArticlesItem): Boolean {
            return oldItem == newItem
        }

        override fun areContentsTheSame(oldItem: ArticlesItem, newItem: ArticlesItem): Boolean {
            return oldItem == newItem
        }
    }
}