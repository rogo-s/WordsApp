package com.ergea.wordsapp.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.ergea.wordsapp.R

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val mFragmentManager = supportFragmentManager
        val mHomeFragment = WordHomeFragment()
        val fragment = mFragmentManager.findFragmentByTag(WordHomeFragment::class.java.simpleName)

        if (fragment !is WordHomeFragment) {
            mFragmentManager
                .beginTransaction()
                .add(R.id.frameContainer, mHomeFragment, WordHomeFragment::class.java.simpleName)
                .commit()
        }
    }
}