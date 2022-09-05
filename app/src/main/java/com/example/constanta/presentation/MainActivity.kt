package com.example.constanta.presentation


import android.graphics.drawable.AnimationDrawable
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.constraintlayout.widget.ConstraintLayout
import com.example.constanta.R
import com.example.constanta.presentation.fragments.FilmsListFragment
import timber.log.Timber

class MainActivity : AppCompatActivity() {
    private lateinit var gradientAnimation: AnimationDrawable

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        gradientAnimation = findViewById<ConstraintLayout>(R.id.root).background as AnimationDrawable

        supportFragmentManager
            .beginTransaction()
            .add(R.id.fragments_container, FilmsListFragment())
            .commit()
    }

    override fun onStart() {
        super.onStart()

        gradientAnimation.apply {
            setExitFadeDuration(resources.getInteger(R.integer.anim_gradient_duration))
            start()
        }



        Timber.d("a added Fragment")
    }

    override fun onStop() {
        super.onStop()
        gradientAnimation.stop()
    }
}