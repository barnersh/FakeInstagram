package com.example.instagram.View

import android.content.Context
import android.widget.ImageView

interface IView {
    //use by view
    fun showShotPic(img: ImageView, position: Int)
    fun glide(img: ImageView, res: Int)
}