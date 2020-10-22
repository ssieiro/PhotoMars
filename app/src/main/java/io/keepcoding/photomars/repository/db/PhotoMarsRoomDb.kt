package io.keepcoding.photomars.repository.db

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import io.keepcoding.photomars.repository.model.PhotosItem

/*
@Database(entities = [PhotosItem::class], version = 1, exportSchema = false)
abstract class PhotoMarsRoomDb : RoomDatabase() {

    abstract fun photoMarsDao(): PhotoMarsDao

    companion object {

        private var instance: PhotoMarsRoomDb? = null

        fun getInstance(context: Context): PhotoMarsRoomDb {

            if (instance == null) {

                synchronized(PhotoMarsRoomDb::class) {
                    instance = Room.databaseBuilder(context.applicationContext, PhotoMarsRoomDb::class.java, "photomars_db")
                            .allowMainThreadQueries()
                            .fallbackToDestructiveMigration()
                            .build()
                }
            }

            return instance!!
        }
    }
}

 */