package io.keepcoding.photomars.ui.detail

import android.app.Activity
import android.app.Application
import android.content.Context
import android.widget.ImageView
import android.widget.TextView
import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import io.keepcoding.photomars.R
import io.keepcoding.photomars.repository.model.PhotosItem
import io.reactivex.Completable
import kotlinx.android.synthetic.main.activity_detail.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class DetailViewModel(private val context: Application) : ViewModel() {


    fun showPhoto(context: Activity, txtDescription: TextView, imageDetail: ImageView, photo: PhotosItem) {

        Glide.with(context)
                .load(photo.imgSrc)
                .apply(
                        RequestOptions()
                                .placeholder(R.drawable.placeholder)
                )
                .into(imageDetail)
    }
}