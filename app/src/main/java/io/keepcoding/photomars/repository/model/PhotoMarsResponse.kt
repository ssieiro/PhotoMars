package io.keepcoding.photomars.repository.model


import androidx.room.Entity
import androidx.room.PrimaryKey
import java.io.Serializable
import com.google.gson.annotations.SerializedName


//@Entity(tableName = "photomars_table")

data class PhotoMarsResponse(
	@field:SerializedName("photos")
	val photos: List<PhotosItem?>? = null
): Serializable

data class Rover(

	@field:SerializedName("name")
	val name: String? = null,

	@field:SerializedName("id")
	val id: Int? = null,

	@field:SerializedName("launch_date")
	val launchDate: String? = null,

	@field:SerializedName("landing_date")
	val landingDate: String? = null,

	@field:SerializedName("status")
	val status: String? = null
) : Serializable


data class PhotosItem(

	@field:SerializedName("sol")
	val sol: Int? = null,

	@field:SerializedName("earth_date")
	val earthDate: String? = null,

	@PrimaryKey
	@field:SerializedName("id")
	val id: Int? = null,

	@field:SerializedName("camera")
	val camera: Camera? = null,

	@field:SerializedName("rover")
	val rover: Rover? = null,

	@field:SerializedName("img_src")
	val imgSrc: String? = null
) : Serializable


data class Camera(

	@field:SerializedName("full_name")
	val fullName: String? = null,

	@field:SerializedName("name")
	val name: String? = null,

	@field:SerializedName("id")
	val id: Int? = null,

	@field:SerializedName("rover_id")
	val roverId: Int? = null
) : Serializable
