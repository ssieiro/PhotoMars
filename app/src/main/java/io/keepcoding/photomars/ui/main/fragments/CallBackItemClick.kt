package io.keepcoding.photomars.ui.main.fragments

import android.content.Context
import io.keepcoding.photomars.repository.model.PhotosItem


interface CallbackItemClick {
    fun onItemClick(photo: PhotosItem)
}