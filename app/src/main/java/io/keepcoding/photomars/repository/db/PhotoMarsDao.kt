package io.keepcoding.photomars.repository.db

import androidx.lifecycle.LiveData
import androidx.room.*
import io.keepcoding.photomars.repository.model.PhotosItem

/*
@Dao
abstract class PhotoMarsDao {

    @Query("SELECT * FROM photomars_table")
    abstract fun getAllPhotos(): LiveData<List<PhotosItem>>

    @Query("SELECT * FROM photomars_table WHERE id = :photoId")
    abstract fun getPhotoId(photoId: String) : LiveData<PhotosItem>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    abstract fun insertPhoto(photoItem: PhotosItem)

    @Delete
    abstract fun deletePhoto(photoItem: PhotosItem)
} */