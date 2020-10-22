package io.keepcoding.photomars.ui.main


import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import io.keepcoding.photomars.R
import io.keepcoding.photomars.base.BasePhotoMars


class FavoritesFragment : BasePhotoMars.BaseFragment() {

    companion object {
        const val TAG = "Favorites fragment"
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(getXmlLayout(), container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initValues()
        initListeners()

    }

    override fun getXmlLayout(): Int {
        return R.layout.fragment_favorites
    }

    override fun initValues() {

    }

    override fun initListeners() {

    }
}