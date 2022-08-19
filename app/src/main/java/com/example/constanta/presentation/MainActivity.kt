package com.example.constanta.presentation


import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.constanta.R
import com.example.constanta.presentation.fragments.FilmsListFragment

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        supportFragmentManager
            .beginTransaction()
            .add(R.id.fragments_container, FilmsListFragment())
            .commit()
    }
}