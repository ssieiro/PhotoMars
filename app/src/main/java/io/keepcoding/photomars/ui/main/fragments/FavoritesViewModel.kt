package io.keepcoding.photomars.ui.main.fragments

import android.app.Application
import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import io.keepcoding.photomars.repository.db.PhotoMarsRoomDb
import io.keepcoding.photomars.repository.model.PhotosItem

class FavoritesViewModel(private val context: Application) : ViewModel() {
    fun getLocalPhotos(): LiveData<List<PhotosItem?>>{
      return PhotoMarsRoomDb.getInstance(context).photoMarsDao().getAllPhotos()
    }
}