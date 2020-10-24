package io.keepcoding.photomars.repository.model


import androidx.room.Entity
import androidx.room.PrimaryKey
import java.io.Serializable
import com.google.gson.annotations.SerializedName
import java.util.*


data class PhotoMarsResponse(
	@field:SerializedName("photos")
	val photos: List<PhotosItem?>? = null
): Serializable

@Entity(tableName = "photomars_table")
data class PhotosItem(

	@PrimaryKey
	var id: String = UUID.randomUUID().toString(),

	@field:SerializedName("sol")
	val sol: Int? = null,

	@field:SerializedName("earth_date")
	val earthDate: String? = null,

	@field:SerializedName("img_src")
	val imgSrc: String? = null
) : Serializable



