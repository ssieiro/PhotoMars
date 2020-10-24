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

class MainFragmentViewModel(private val context: Application) : ViewModel() {

    fun getAllPhotos(cb: PhotoMarsService.CallbackResponse<PhotoMarsResponse>) {
        PhotoMarsService().photoMarsApi.getResponse(ApiKey.API_KEY).enqueue(object : Callback<PhotoMarsResponse> {
            override fun onResponse(call: Call<PhotoMarsResponse>, response: Response<PhotoMarsResponse>) {
                if (response.isSuccessful && response.body() != null) {
                    insertInDB(response.body()!!.photos!!)
                    cb.onResponse(response.body()!!)
                } else {
                    cb.onFailure(Throwable(response.message()), response)
                }
            }

            override fun onFailure(call: Call<PhotoMarsResponse>, t: Throwable) {
                cb.onFailure(t)
            }
        })
    }

    fun insertInDB (list: List<PhotosItem?>) {
        for (i in list) {
            PhotoMarsRoomDb.getInstance(context).photoMarsDao().insertPhoto(i)
        }
    }

}