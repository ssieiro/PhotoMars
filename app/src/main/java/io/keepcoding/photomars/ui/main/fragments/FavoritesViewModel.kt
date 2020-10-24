package io.keepcoding.photomars.ui.main.fragments

import android.app.Application
import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import io.keepcoding.photomars.repository.db.PhotoMarsRoomDb
import io.keepcoding.photomars.repository.model.PhotoMarsResponse
import io.keepcoding.photomars.repository.model.PhotosItem
import io.keepcoding.photomars.repository.network.PhotoMarsService
import io.keepcoding.photomars.utils.ApiKey
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class FavoritesViewModel(private val context: Application) : ViewModel() {
    fun getLocalPhotos(): LiveData<List<PhotosItem?>>{
      return PhotoMarsRoomDb.getInstance(context).photoMarsDao().getAllPhotos()
    }
}