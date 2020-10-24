package io.keepcoding.photomars.ui.main.fragments

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import io.keepcoding.photomars.R
import io.keepcoding.photomars.repository.model.PhotoMarsResponse
import io.keepcoding.photomars.repository.model.PhotosItem
import io.keepcoding.photomars.repository.network.PhotoMarsService
import io.keepcoding.photomars.ui.detail.DetailActivity
import io.keepcoding.photomars.ui.detail.DetailActivity.Companion.OBJECT_PHOTO
import io.keepcoding.photomars.utils.CustomViewModelFactory
import kotlinx.android.synthetic.main.fragment_main.*
import kotlinx.android.synthetic.main.item_list.*
import retrofit2.Response


class MainFragment() : Fragment(), CallbackItemClick {

    private var mPhotos: List<PhotosItem?>? = null
    private var mAdapter: MainAdapter? = null

    private val mViewModel: MainFragmentViewModel by lazy {
        val factory = CustomViewModelFactory(requireActivity().application)
        ViewModelProvider(this, factory).get(MainFragmentViewModel::class.java)
    }

    companion object {
        const val TAGSERVER = "SERVER PHOTO"
        fun newInstance() = MainFragment()
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.fragment_main, container, false)

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        init()
        getPhotos()
    }

    private fun init() {
        recyclerViewList.layoutManager = LinearLayoutManager(activity)
        recyclerViewList.isNestedScrollingEnabled = false
        recyclerViewList.setHasFixedSize(false)
    }

    override fun onResume() {
        super.onResume()
    }

    private fun getPhotos() {
        mViewModel.getAllPhotos(object : PhotoMarsService.CallbackResponse<PhotoMarsResponse> {
            override fun onResponse(response: PhotoMarsResponse) {
                mPhotos = response.photos
                mAdapter = MainAdapter(requireActivity().applicationContext, this@MainFragment, mPhotos)
                recyclerViewList.adapter = mAdapter
            }
            override fun onFailure(t: Throwable, res: Response<*>?) {
            }
        })
    }

    override fun onItemClick(photo: PhotosItem) {
        context?.let { fragment ->
            val intent = Intent(fragment, DetailActivity::class.java).apply {
                arguments = Bundle().apply {
                    putSerializable(OBJECT_PHOTO, photo)
                }
                arguments?.let { args ->
                    putExtras(args)
                }
                putExtra("EXTRA_PHOTO", TAGSERVER)
            }
            startActivity(intent)
        }

    }
}