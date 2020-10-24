package io.keepcoding.photomars.ui.main.fragments

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import io.keepcoding.photomars.R
import io.keepcoding.photomars.repository.model.PhotosItem
import io.keepcoding.photomars.ui.detail.DetailActivity
import io.keepcoding.photomars.ui.detail.DetailActivity.Companion.OBJECT_PHOTO
import io.keepcoding.photomars.utils.CustomViewModelFactory
import kotlinx.android.synthetic.main.fragment_main.*

class FavoritesFragment() : Fragment(), CallbackItemClick {

    private var mPhotos: List<PhotosItem?>? = null
    private var mAdapter: FavoritesAdapter? = null

    private val mViewModel: FavoritesViewModel by lazy {
        val factory = CustomViewModelFactory(requireActivity().application)
        ViewModelProvider(this, factory).get(FavoritesViewModel::class.java)
    }

    companion object {
        const val TAGLOCAL = "LOCAL PHOTO"
        fun newInstance() = FavoritesFragment()
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.fragment_favorites, container, false)

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        recyclerViewList.layoutManager = LinearLayoutManager(activity)
        recyclerViewList.isNestedScrollingEnabled = false
        recyclerViewList.setHasFixedSize(false)
        getLocalPhotos()
    }


    private fun getLocalPhotos() {
        mViewModel.getLocalPhotos().observe(viewLifecycleOwner, { photosList ->

            mAdapter = FavoritesAdapter(requireActivity().applicationContext, this, photosList)
            recyclerViewList.adapter = mAdapter
        })
    }

    override fun onItemClick(photo: PhotosItem) {
        activity?.let { fragment ->
            val intent = Intent(fragment, DetailActivity::class.java).apply {
                arguments = Bundle().apply {
                    putSerializable(OBJECT_PHOTO, photo)
                }
                arguments?.let { args ->
                    putExtras(args)
                }
                putExtra("EXTRA_PHOTO", TAGLOCAL)
            }
            startActivity(intent)
        }

    }
}