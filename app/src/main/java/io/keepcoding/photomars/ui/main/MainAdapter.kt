package io.keepcoding.photomars.ui.main

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import io.keepcoding.photomars.R
import io.keepcoding.photomars.repository.model.PhotosItem
import kotlinx.android.synthetic.main.item_list.view.*


class MainAdapter(private val context: Context, private val callbackItemClick: CallbackItemClick, private val photosList: List<PhotosItem?>?) : RecyclerView.Adapter<MainAdapter.MainHolder>() {

    class MainHolder(v: View) : RecyclerView.ViewHolder(v) {
        internal var view = v
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MainHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_list, parent, false)
        return MainHolder(view)
    }

    override fun onBindViewHolder(holder: MainHolder, position: Int) {
        photosList?.get(position).let { photo ->
            var camera = photo?.camera?.fullName
            holder.view.textCardView.text = "Camera: $camera"
            Glide.with(context)
                    .load(photo?.imgSrc)
                    .apply(
                            RequestOptions()
                                    .placeholder(R.drawable.placeholder)
                    )
                    .into(holder.view.imageCardView)

            holder.view.cardView.setOnClickListener {
                callbackItemClick.onItemClick(photo!!)
            }

        }
    }

    override fun getItemCount(): Int {
        return  photosList!!.size
    }
}