package io.keepcoding.photomars.ui.main.fragments

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import io.keepcoding.photomars.R
import io.keepcoding.photomars.base.BasePhotoMars
import io.keepcoding.photomars.repository.model.PhotoMarsResponse
import io.keepcoding.photomars.repository.model.PhotosItem
import io.keepcoding.photomars.repository.network.PhotoMarsService
import io.keepcoding.photomars.ui.detail.DetailActivity
import io.keepcoding.photomars.ui.detail.DetailActivity.Companion.OBJECT_PHOTO
import io.keepcoding.photomars.utils.CustomViewModelFactory
import kotlinx.android.synthetic.main.fragment_main.*
import kotlinx.android.synthetic.main.item_list.*
import retrofit2.Response


class FavoritesFragment() : BasePhotoMars.BaseFragment(), CallbackItemClick {

    private var mPhotos: List<PhotosItem?>? = null
    private var mAdapter: FavoritesAdapter? = null

    private val mViewModel: FavoritesViewModel by lazy {
        val factory = CustomViewModelFactory(requireActivity().application)
        ViewModelProvider(this, factory).get(FavoritesViewModel::class.java)
    }

    companion object {
        const val TAGLOCAL = "LOCAL PHOTO"
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(getXmlLayout(), container, false)

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initValues()
        initListeners()
        getPhotos()
    }

    override fun getXmlLayout(): Int {
        return R.layout.fragment_main
    }

    override fun initValues() {
        recyclerViewList.layoutManager = LinearLayoutManager(activity)
        recyclerViewList.isNestedScrollingEnabled = false
        recyclerViewList.setHasFixedSize(false)
    }

    override fun initListeners() {
    }


    private fun getPhotos() {
        mViewModel.getAllPhotos(object : PhotoMarsService.CallbackResponse<PhotoMarsResponse> {
            override fun onResponse(response: PhotoMarsResponse) {
                mPhotos = response.photos
                mAdapter = FavoritesAdapter(requireContext(), FavoritesFragment(), mPhotos)
                recyclerViewList.adapter = mAdapter
            }
            override fun onFailure(t: Throwable, res: Response<*>?) {
                textCardView.text = res.toString()
            }
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