package com.example.instagram.Presenter

import android.app.Activity
import android.content.Intent
import android.support.v4.app.Fragment
import com.example.instagram.Model.IModel
import com.example.instagram.Model.Model
import com.example.instagram.View.IView
import com.example.instagram.View.PictureActivity

class Presenter(val iView: IView) : IPresenter {

    var currentUser = 0
    val iModel: IModel = Model()

    override fun onClick(activity: Activity, intent: Intent) {
        activity.startActivity(intent)
    }

    override fun toPic(fragment: Fragment, numClick: Int) {
        val intent = Intent(fragment.context, PictureActivity::class.java)
        intent.putExtra("num", numClick)
        fragment.startActivity(intent)
    }

    override fun findCurrentUser(userName: String): Int {
        val userArr = iModel.passObjArr()
        for (i in 0 until userArr.size) {
            if (userName == userArr[i].name) {
                currentUser = i
            }
        }
        return currentUser
    }
}