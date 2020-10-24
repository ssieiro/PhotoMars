package io.keepcoding.photomars.ui.main

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import io.keepcoding.photomars.R
import io.keepcoding.photomars.ui.main.fragments.FavoritesFragment
import io.keepcoding.photomars.ui.main.fragments.MainFragment
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setSupportActionBar(findViewById(R.id.toolbar))

        supportFragmentManager.beginTransaction()
                .replace(R.id.content, MainFragment.newInstance())
                .commitNow()

        BtnExplore.setOnClickListener {
            supportFragmentManager.beginTransaction()
                    .replace(R.id.content, MainFragment.newInstance())
                    .commit()
        }

        BtnFavorites.setOnClickListener{
            supportFragmentManager.beginTransaction()
                    .replace(R.id.content, FavoritesFragment.newInstance())
                    .commit()
        }
    }


}