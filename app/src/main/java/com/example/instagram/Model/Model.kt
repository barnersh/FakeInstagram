package com.example.instagram.Model

import android.content.Context
import android.util.Log
import com.example.instagram.R
import kotlin.random.Random

data class User(
    val shot: Int,
    val name: String,
    val profile: String,
    val contentPic: Array<Int>,
    val content: Array<Int>,
    val like: Array<Int>,
    val post: Int,
    val follows: Int,
    val following: Int,
    var followed: Boolean
)

val objArr = ArrayList<User>()

class Model : IModel {


    val shotPicArr = arrayOf(
        R.drawable.one,
        R.drawable.two,
        R.drawable.three,
        R.drawable.four,
        R.drawable.five,
        R.drawable.six,
        R.drawable.seven,
        R.drawable.eight
    )

    val userArr = arrayOf("one", "two", "three", "four", "five", "six", "seven", "eight")

    val contentPicArr = arrayOf(
        R.drawable.content1,
        R.drawable.content2,
        R.drawable.content3,
        R.drawable.content4,
        R.drawable.content5,
        R.drawable.content6,
        R.drawable.content7,
        R.drawable.content8,
        R.drawable.content9,
        R.drawable.content10,
        R.drawable.content11,
        R.drawable.content12,
        R.drawable.content13,
        R.drawable.content14,
        R.drawable.content15,
        R.drawable.content16,
        R.drawable.content17,
        R.drawable.content18,
        R.drawable.content19
    )

    val contentArr = arrayOf(
        R.string.content1,
        R.string.content2,
        R.string.content3,
        R.string.content4,
        R.string.content5,
        R.string.content6,
        R.string.content7,
        R.string.content8,
        R.string.content9,
        R.string.content10,
        R.string.content11,
        R.string.content12,
        R.string.content13,
        R.string.content14,
        R.string.content15,
        R.string.content16,
        R.string.content17,
        R.string.content18,
        R.string.content19
    )

    val profileArr = arrayOf(
        R.string.profile1,
        R.string.profile2,
        R.string.profile3,
        R.string.profile4,
        R.string.profile5,
        R.string.profile6,
        R.string.profile7,
        R.string.profile8,
        R.string.profile9,
        R.string.profile10,
        R.string.profile11,
        R.string.profile12,
        R.string.profile13,
        R.string.profile14,
        R.string.profile15,
        R.string.profile16,
        R.string.profile17,
        R.string.profile18,
        R.string.profile19
    )

    override fun passShotPicArr(): Array<Int> {
        return shotPicArr
    }

    override fun objectInit(context: Context) {
        //objArr
        objArr.clear()
        for (i in 0 until shotPicArr.size) {

            val picNum = Random.nextInt(19) + 1
            var objPicContent = Array<Int>(picNum, { i: Int -> 0 })
            for (i in 0 until picNum) {
                val random = Random.nextInt(19)
                objPicContent.set(i, contentPicArr[random])
            }

            val contentNum = Random.nextInt(19)
            var objContent = Array<Int>(picNum, { i: Int -> 0 })
            for (i in 0 until picNum) {
                val random = Random.nextInt(19)
                objContent.set(i, contentArr[random])
            }

            var like = Array<Int>(picNum, { i: Int -> 0 })
            for (i in 0 until picNum) {
                val random = Random.nextInt(50000)
                like.set(i, random)
            }

            val post = Random.nextInt(2000)
            val follows = Random.nextInt(20000)
            val following = Random.nextInt(200)

            Log.d("random", "picNum: $picNum , contentNum: $contentNum")
            val user = User(shotPicArr[i], userArr[i], context.getString(profileArr[i]), objPicContent, objContent, like, post, follows, following, true)
            objArr.add(user)
        }
    }

    override fun passObjArr(): ArrayList<User> {
        return objArr
    }

    override fun passCurrentUserName(currentUser: Int): String {
        return objArr[currentUser].name
    }
}