package com.example.instagram

import android.support.v7.widget.RecyclerView
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import com.example.instagram.View.IView

class Adapter(val arr: Array<Int>, val iView: IView) : RecyclerView.Adapter<Adapter.ViewHolder>() {
    override fun onCreateViewHolder(p0: ViewGroup, p1: Int): ViewHolder {
        val v = View.inflate(p0.context, R.layout.shot, null)
        return ViewHolder(v)
    }

    override fun getItemCount(): Int {
        return arr.size
    }

    override fun onBindViewHolder(p0: ViewHolder, p1: Int) {
//        p0.shot.setImageResource(arr[p1])
        iView.showShotPic(p0.img, p1)
    }

    class ViewHolder(v: View) : RecyclerView.ViewHolder(v) {
        val img = v.findViewById<ImageView>(R.id.img)
    }
}