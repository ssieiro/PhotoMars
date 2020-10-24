package io.keepcoding.photomars.ui.detail

import android.os.Bundle
import android.os.PersistableBundle
import android.util.Log
import android.view.WindowManager
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import io.keepcoding.photomars.R
import io.keepcoding.photomars.repository.model.PhotosItem
import io.keepcoding.photomars.utils.CustomViewModelFactory
import kotlinx.android.synthetic.main.activity_detail.*

class DetailActivity : AppCompatActivity() {

    companion object {
        const val TAG = "DetailActivity"
        const val LOCAL_PHOTO = "LOCAL PHOTO"
        const val SERVER_PHOTO = "SERVER PHOTO"
        const val OBJECT_PHOTO = "OBJECT_PHOTO"
        const val REQUEST_CODE = 100
    }

    private val mViewModel: DetailViewModel by lazy {
        val factory = CustomViewModelFactory(application)
        ViewModelProvider(this, factory).get(DetailViewModel::class.java)
    }

    private var mPhoto: PhotosItem? = null
    private var localPhoto = false

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail)
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