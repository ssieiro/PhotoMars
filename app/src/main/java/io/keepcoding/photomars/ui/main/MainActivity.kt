package io.keepcoding.photomars.ui.main

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import android.view.Menu
import android.view.MenuItem
import io.keepcoding.photomars.R
import io.keepcoding.photomars.base.BasePhotoMars
import io.keepcoding.photomars.repository.model.PhotoMarsResponse
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : BasePhotoMars.BaseActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(getXmlLayout())
        setSupportActionBar(findViewById(R.id.toolbar))

        initValues()
        initListeners()

        val adapter = ViewPagerAdapter(supportFragmentManager)
        adapter.addFragment(MainFragment(), "Explore")
        adapter.addFragment(FavoritesFragment(), "Favorites")
        viewPager.adapter = adapter
        tabs.setupWithViewPager(viewPager)

    }

    override fun getXmlLayout(): Int {
        return R.layout.activity_main
    }

    override fun initValues() {
    }

    override fun initListeners() {
    }

}