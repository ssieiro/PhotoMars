package io.keepcoding.photomars.ui.main

import android.os.Bundle
import io.keepcoding.photomars.R
import io.keepcoding.photomars.base.BasePhotoMars
import io.keepcoding.photomars.ui.main.fragments.FavoritesFragment
import io.keepcoding.photomars.ui.main.fragments.MainFragment
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : BasePhotoMars.BaseActivity() {

    companion object {
        const val TAGEXPORE = "Explore"
        const val TAGFAVORITES = "Favorites"
    }

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