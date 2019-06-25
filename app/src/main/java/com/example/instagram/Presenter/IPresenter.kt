package com.example.instagram.Presenter

import android.app.Activity
import android.content.Context
import android.content.Intent
import android.support.v4.app.Fragment
import android.widget.TextView

interface IPresenter {
    //use by view
    fun onClick(activity: Activity, intent: Intent)

    fun findCurrentUser(userName: String): Int

    fun toPic(fragment: Fragment, numClick: Int)
    fun changeMaxLine(tv: TextView)
    //use by model
}