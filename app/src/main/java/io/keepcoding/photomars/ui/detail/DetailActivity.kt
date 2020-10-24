package io.keepcoding.photomars.ui.detail

import android.util.Log
import android.view.WindowManager
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import io.keepcoding.photomars.R
import io.keepcoding.photomars.base.BasePhotoMars
import io.keepcoding.photomars.repository.model.PhotosItem
import io.keepcoding.photomars.utils.CustomViewModelFactory
import io.reactivex.Completable
import io.reactivex.CompletableObserver
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.Disposable
import kotlinx.android.synthetic.main.activity_detail.*
import retrofit2.Response

class DetailActivity : BasePhotoMars.BaseActivity() {

    companion object {
        const val TAG = "DetailActivity"
        const val LOCAL_PHOTO = "LOCAL PHOTO"
        const val SERVER_PHOTO = "SERVER PHOTO"
        const val OBJECT_PHOTO = "OBJECT_PHOTO"
        const val REQUEST_CODE = 100
    }

    private var mPhoto: PhotosItem? = null
    private var localPhoto = false

    private val mViewModel: DetailViewModel by lazy {
        val factory = CustomViewModelFactory(application)
        ViewModelProvider(this, factory).get(DetailViewModel::class.java)
    }

    override fun getXmlLayout(): Int {
        return R.layout.activity_detail
    }

    override fun initValues() {
        setSupportActionBar(findViewById(R.id.toolbar))
        window.setFlags(
                WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN
        )

        intent?.let {

            mPhoto = intent.extras!!.getSerializable(OBJECT_PHOTO) as PhotosItem?
            mViewModel.showPhoto(this@DetailActivity, txtDescription, imageDetail, mPhoto!!)

            if (it.getStringExtra("EXTRA_PHOTO") == LOCAL_PHOTO) {
                localPhoto = true
                btnPhotoDetail.setImageResource(android.R.drawable.ic_menu_delete)
            } else {
                localPhoto = false
                btnPhotoDetail.setImageResource(android.R.drawable.ic_menu_save)
            }
        }
    }

    override fun initListeners() {
        btnPhotoDetail.setOnClickListener {

            if (localPhoto) {
                //delete photo
            } else {
                //include photo in favorites
            }

            finish()
        }
    }


    override fun onResume() {
        super.onResume()
        Log.w(TAG, "")
    }
}