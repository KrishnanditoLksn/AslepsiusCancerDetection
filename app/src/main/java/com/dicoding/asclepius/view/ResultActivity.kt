package com.dicoding.asclepius.view

import android.net.Uri
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.dicoding.asclepius.databinding.ActivityResultBinding

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

    }

    companion object {
        const val EXTRA_IMAGE_URI = "extra_image_uri"
        const val EXTRA_RESULT = "extra_result"
        const val EXTRA_SCORE = "extra_score"
    }

}