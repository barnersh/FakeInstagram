package com.example.instagram.Model

import android.content.Context

interface IModel {
    fun passShotPicArr(): Array<Int>
    fun passObjArr(): ArrayList<User>
    fun passCurrentUserName(currentUser: Int): String
    fun objectInit(context: Context)
}