package com.example.instagram

import android.app.Activity
import android.support.v4.app.Fragment
import android.support.v7.widget.RecyclerView
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import com.bumptech.glide.Glide
import com.example.instagram.Model.User
import com.example.instagram.Presenter.IPresenter
import com.example.instagram.View.MainActivity.Companion.GRID

class PersonalAdapter(val userArr: ArrayList<User>, val userNum: Int, val fragment: Fragment, val type: Int, val iPresenter: IPresenter) :
    RecyclerView.Adapter<PersonalAdapter.ViewHolder>() {
    override fun onCreateViewHolder(p0: ViewGroup, p1: Int): ViewHolder {
        if (p1 == GRID) {
            val v = View.inflate(p0.context, R.layout.gridlayout, null)
            return ViewHolder(v)
        } else {
            val v = View.inflate(p0.context, R.layout.homepage, null)
            return ViewHolder(v)
        }
    }

    override fun getItemViewType(position: Int): Int {
        return type
    }

    override fun getItemCount(): Int {
        return userArr[userNum].contentPic.size
    }

    override fun onBindViewHolder(p0: ViewHolder, p1: Int) {
        if (type == GRID) {
            Glide
                .with(fragment)
                .load(userArr[userNum].contentPic.get(p1))
                .into(p0.img_grid)
            p0.img_grid.setOnClickListener {
                iPresenter.toPic(fragment, p1)
            }
        } else {
            Glide
                .with(fragment)
                .load(userArr[userNum].shot)
                .into(p0.img_shot)
            p0.tv_userName.text = userArr[userNum].name
            Glide
                .with(fragment)
                .load(userArr[userNum].contentPic.get(p1))
                .into(p0.img_content)
            p0.tv_content.setText(userArr[userNum].content.get(p1))
        }
    }

    class ViewHolder(v: View) : RecyclerView.ViewHolder(v) {
        val img_grid = v.findViewById<ImageView>(R.id.img_grid)
        //---------------------------------------------------------------------
        val img_shot = v.findViewById<ImageView>(R.id.img_shot)
        val tv_userName = v.findViewById<TextView>(R.id.tv_userName)
        val img_content = v.findViewById<ImageView>(R.id.img_content)
        val tv_content = v.findViewById<TextView>(R.id.tv_content)
    }
}