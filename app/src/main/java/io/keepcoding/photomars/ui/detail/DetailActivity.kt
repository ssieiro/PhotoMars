package io.keepcoding.photomars.ui.detail

import android.os.Bundle
import android.util.Log
import android.view.WindowManager
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import io.keepcoding.photomars.R
import io.keepcoding.photomars.repository.model.PhotosItem
import io.keepcoding.photomars.utils.CustomViewModelFactory
import io.reactivex.Completable
import io.reactivex.CompletableObserver
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.Disposable
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
        val actionbar = supportActionBar
        actionbar?.title = "Detalle"
        actionbar?.setDisplayHomeAsUpEnabled(true)
        actionbar?.setDisplayHomeAsUpEnabled(true)

        window.setFlags(
                WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN
        )

        intent?.let {

            mPhoto = intent.extras!!.getSerializable(OBJECT_PHOTO) as PhotosItem?
            var date = mPhoto?.earthDate
            txtDescription.text = "Fecha: $date"
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
                mViewModel.deletePhoto(mPhoto)

            } else {
                Completable.fromAction {
                    mViewModel.insertPhoto(mPhoto)
                }.observeOn(AndroidSchedulers.mainThread())
                        .subscribe(object : CompletableObserver {
                            override fun onComplete() {
                                Log.w(TAG, "Insert OK")
                            }
                            override fun onSubscribe(d: Disposable) {
                                Log.w(TAG, "Subscribe OK")
                            }

                            override fun onError(e: Throwable) {
                                Log.w(TAG, e.printStackTrace().toString())
                            }
                        })
            }

            finish()
        }

    }

    override fun onSupportNavigateUp(): Boolean {
        onBackPressed()
        return true
    }

    override fun onResume() {
        super.onResume()
        Log.w(TAG, "")
    }
}