package com.dev.creditScoreApplication.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.dev.creditScoreApplication.R
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }
}