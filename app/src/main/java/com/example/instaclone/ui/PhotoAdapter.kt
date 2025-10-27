package com.example.instaclone.ui

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.instaclone.R
import com.example.instaclone.models.InstagramPhoto

class PhotoAdapter : RecyclerView.Adapter<PhotoAdapter.PhotoViewHolder>() {

    private val items = mutableListOf<InstagramPhoto>()

    fun submitList(list: List<InstagramPhoto>) {
        items.clear()
        items.addAll(list)
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PhotoViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_photo, parent, false)
        return PhotoViewHolder(view)
    }

    override fun onBindViewHolder(holder: PhotoViewHolder, position: Int) {
        holder.bind(items[position])
    }

    override fun getItemCount(): Int = items.size

    class PhotoViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        private val imageView: ImageView = itemView.findViewById(R.id.photoImageView)
        private val usernameView: TextView? = itemView.findViewById(R.id.usernameText)

        fun bind(photo: InstagramPhoto) {
            usernameView?.text = photo.user?.username ?: ""
            val url = photo.images?.standard_resolution?.url
            Glide.with(itemView).load(url).into(imageView)
        }
    }
}
