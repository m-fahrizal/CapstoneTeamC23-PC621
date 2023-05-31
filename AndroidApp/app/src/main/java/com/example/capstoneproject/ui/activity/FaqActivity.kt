package com.example.capstoneproject.ui.activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.MenuItem
import com.example.capstoneproject.R
import com.example.capstoneproject.databinding.ActivityFaqBinding
import com.example.capstoneproject.databinding.FragmentHomeBinding

class FaqActivity : AppCompatActivity() {
    private lateinit var binding: ActivityFaqBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityFaqBinding.inflate(layoutInflater)
        setContentView(binding.root)
        supportActionBar?.title = getString(R.string.faq)

        supportActionBar?.setDisplayHomeAsUpEnabled(true)

        var g = 0
        val exFaq1 = binding.exFaq1
        exFaq1.parentLayout.setOnClickListener {
            if (g == 0) {
                g = 1
                exFaq1.expand()
            } else {
                g = 0
                exFaq1.collapse()
            }
        }
        val exFaq2 = binding.exFaq2
        exFaq2.parentLayout.setOnClickListener {
            if (g == 0) {
                g = 1
                exFaq2.expand()
            } else {
                g = 0
                exFaq2.collapse()
            }
        }
        val exFaq3 = binding.exFaq3
        exFaq3.parentLayout.setOnClickListener {
            if (g == 0) {
                g = 1
                exFaq3.expand()
            } else {
                g = 0
                exFaq3.collapse()
            }
        }
        val exFaq4 = binding.exFaq4
        exFaq4.parentLayout.setOnClickListener {
            if (g == 0) {
                g = 1
                exFaq4.expand()
            } else {
                g = 0
                exFaq4.collapse()
            }
        }
        val exFaq5 = binding.exFaq5
        exFaq5.parentLayout.setOnClickListener {
            if (g == 0) {
                g = 1
                exFaq5.expand()
            } else {
                g = 0
                exFaq5.collapse()
            }
        }
    }

    override fun onOptionsItemSelected(back: MenuItem): Boolean {
        when (back.itemId) {
            android.R.id.home -> {
                finish()
            }
        }
        return super.onOptionsItemSelected(back)
    }
}