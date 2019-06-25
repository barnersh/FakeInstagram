package com.example.instagram.Presenter

import android.app.Activity
import android.content.Context
import android.content.Intent
import android.support.v4.app.Fragment

interface IPresenter {
    //use by view
    fun onClick(activity: Activity, intent: Intent)

    fun findCurrentUser(userName: String): Int

    fun toPic(fragment: Fragment, numClick: Int)
    //use by model
}