package io.keepcoding.photomars.ui.main

import io.keepcoding.photomars.repository.model.PhotosItem


interface CallbackItemClick {
    fun onItemClick(photo: PhotosItem)
}