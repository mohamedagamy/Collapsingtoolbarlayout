package com.example.profiletask.ui.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import com.example.profiletask.R
import com.example.profiletask.model.MediaInfo
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.recycler_list_item.view.*

class ImagesAdapter(val context: Context, val mediaList: List<MediaInfo>) : RecyclerView.Adapter<ImagesHolder>() {

    var itemClickListener: ((link: String) -> Unit)? = null

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ImagesHolder {
        val view =
            LayoutInflater.from(context).inflate(R.layout.recycler_list_item, parent, false)
        return ImagesHolder(view)
    }

    override fun getItemCount(): Int {
        return mediaList.size
    }

    override fun onBindViewHolder(holder: ImagesHolder, position: Int) {
        holder.bind(holder, mediaList.get(position).image, itemClickListener)
    }
}

class ImagesHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
    fun bind(
        holder: ImagesHolder, link: String, itemClickListener: ((link: String) -> Unit)?
    ) {
        holder.itemView.setOnClickListener {
            it.context.showToast(link.split("/").get(link.split("/").size-1))
            itemClickListener?.invoke(link)
        }

        Picasso.get().load(link).into(holder.itemView.userMediaIv)
    }
}

private fun Context.showToast(msg: String) {
    Toast.makeText(this,msg,Toast.LENGTH_LONG).show()
}
