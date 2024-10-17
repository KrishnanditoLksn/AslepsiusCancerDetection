package com.dicoding.asclepius.ui.view

import android.net.Uri
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import com.dicoding.asclepius.data.remote.response.ArticlesItem
import com.dicoding.asclepius.databinding.ActivityResultBinding
import com.dicoding.asclepius.ui.adapter.NewsAdapter
import com.dicoding.asclepius.viewmodel.NewsViewModel

class ResultActivity : AppCompatActivity() {
    private lateinit var binding: ActivityResultBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityResultBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // TODO: Menampilkan hasil gambar, prediksi, dan confidence score.
        val imageUri = Uri.parse(intent.getStringExtra(EXTRA_IMAGE_URI))
        val detectedClassif = intent.getStringExtra(EXTRA_RESULT)
        val detectedScore = intent.getStringExtra(EXTRA_SCORE)


        imageUri?.let {
            binding.resultImage.setImageURI(imageUri)
        }

        binding.resultClassification.text = (detectedClassif ?: "No Result found").toString()
        binding.resultText.text = detectedScore ?: "No result found"

        val layoutManager = LinearLayoutManager(this)
        binding.rvHealth.layoutManager = layoutManager
        val itemDecoration = DividerItemDecoration(this, layoutManager.orientation)
        binding.rvHealth.addItemDecoration(itemDecoration)
        val newsVm = ViewModelProvider(this)[NewsViewModel::class.java]

        newsVm.news.observe(this) {
            setNewsList(it)
        }
    }

    private fun setNewsList(list: List<ArticlesItem?>) {
        val newsAdapter = NewsAdapter()
        newsAdapter.submitList(list)
        binding.rvHealth.adapter = newsAdapter
    }

    companion object {
        const val EXTRA_IMAGE_URI = "extra_image_uri"
        const val EXTRA_RESULT = "extra_result"
        const val EXTRA_SCORE = "extra_score"
    }

}