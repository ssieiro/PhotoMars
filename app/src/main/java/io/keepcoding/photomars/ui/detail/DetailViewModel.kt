package io.keepcoding.photomars.ui.detail

import android.app.Activity
import android.app.Application

import android.widget.ImageView
import android.widget.TextView
import androidx.lifecycle.ViewModel
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import io.keepcoding.photomars.R
import io.keepcoding.photomars.repository.db.PhotoMarsRoomDb
import io.keepcoding.photomars.repository.model.PhotosItem


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

    fun deletePhoto(photo: PhotosItem?) {
        PhotoMarsRoomDb.getInstance(context).photoMarsDao().deletePhoto(photo)
    }

    fun insertPhoto(photo: PhotosItem?) {
        PhotoMarsRoomDb.getInstance(context).photoMarsDao().insertPhoto(photo)
    }

}