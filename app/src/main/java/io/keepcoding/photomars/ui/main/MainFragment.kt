package io.keepcoding.photomars.ui.main

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
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
import io.keepcoding.photomars.utils.CustomViewModelFactory
import kotlinx.android.synthetic.main.fragment_main.*
import kotlinx.android.synthetic.main.item_list.*
import retrofit2.Response


class MainFragment : BasePhotoMars.BaseFragment(), CallbackItemClick {

    private var mPhotos: List<PhotosItem?>? = null
    private var mAdapter: MainAdapter? = null


    private val mViewModel: MainFragmentViewModel by lazy {
        val factory = CustomViewModelFactory(requireActivity().application)
        ViewModelProvider(this, factory).get(MainFragmentViewModel::class.java)
    }

    companion object {
        const val TAG = "Main fragment"
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
        return R.layout.fragment_main
    }

    override fun initValues() {
        recyclerViewMainList.layoutManager = LinearLayoutManager(activity)
        recyclerViewMainList.isNestedScrollingEnabled = false
        recyclerViewMainList.setHasFixedSize(false)
        getPhotos()
    }

    override fun initListeners() {
    }


    private fun getPhotos() {
        mViewModel.getAllPhotos(object : PhotoMarsService.CallbackResponse<PhotoMarsResponse> {
            override fun onResponse(response: PhotoMarsResponse) {

                mPhotos = response.photos
                mAdapter = MainAdapter(requireContext(), MainFragment(), mPhotos)
                recyclerViewMainList.adapter = mAdapter

            }

            override fun onFailure(t: Throwable, res: Response<*>?) {
                textCardView.text = res.toString()
            }
        })
    }

    override fun onItemClick(photo: PhotosItem) {

    }
}