package io.keepcoding.photomars.repository.network

import io.keepcoding.photomars.repository.model.PhotoMarsResponse
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Headers
import retrofit2.http.Query

interface PhotoMarsApi {

    @GET("mars-photos/api/v1/rovers/curiosity/photos?sol=1000&page=1")
    @Headers("Content-Type: application/json")
    fun getResponse(@Query("api_key") apiKey: String): Call<PhotoMarsResponse>


}