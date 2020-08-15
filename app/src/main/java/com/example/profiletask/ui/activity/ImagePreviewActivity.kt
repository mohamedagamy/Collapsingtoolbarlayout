package com.example.profiletask.ui.activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.profiletask.Constants.Companion.IMAGE_LINK
import com.example.profiletask.R
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.activity_image_preview.*
import kotlinx.android.synthetic.main.recycler_list_item.view.*

class ImagePreviewActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_image_preview)

        val link = intent.getStringExtra(IMAGE_LINK)
        Picasso.get().load(link).into(ivPreview)
    }
}