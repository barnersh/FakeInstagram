package com.example.instagram.View

import android.app.ActionBar
import android.content.Context
import android.graphics.Color
import android.os.Build
import com.example.instagram.FragmentAdapter
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v4.view.ViewPager
import android.support.v7.app.AlertDialog
import android.util.Log
import android.view.Menu
import android.view.MenuItem
import android.view.View
import android.widget.ImageView
import android.widget.LinearLayout
import android.widget.ScrollView
import com.bumptech.glide.Glide
import com.example.instagram.Model.IModel
import com.example.instagram.Model.Model
import com.example.instagram.Model.User
import com.example.instagram.Presenter.IPresenter
import com.example.instagram.Presenter.Presenter
import com.example.instagram.R
import kotlinx.android.synthetic.main.activity_profile.*
import kotlinx.android.synthetic.main.info_layout.*

var thisUser = ""

class ProfileActivity : AppCompatActivity(), IView {
    //**********************************************************************
    override fun glideCircle(img: ImageView, position: Int) {
    }

    override fun glide(img: ImageView, res: Int) {
        Glide
            .with(this)
            .load(res)
            .into(img)
    }
    //***********************************************************************

    val iModel: IModel = Model()
    val iPresenter: IPresenter = Presenter(this)

    lateinit var userArr: ArrayList<User>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_profile)

        thisUser = intent.getStringExtra("name")
        val currentUserNum = iPresenter.findCurrentUser(thisUser)
        //toolbar
        setSupportActionBar(toolbar)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        supportActionBar?.title = thisUser

        userArr = iModel.passObjArr()

        //profile setting
        tv_profile.text = userArr[currentUserNum].profile
        glide(img_user, userArr[currentUserNum].shot)
        tv_post.text = userArr[currentUserNum].post.toString()
        tv_follows.text = userArr[currentUserNum].follows.toString()
        tv_following.text = userArr[currentUserNum].following.toString()

        var follow = userArr[currentUserNum].followed
        btn_follow.setOnClickListener {
            if (follow) {
                AlertDialog.Builder(this)
                    .setTitle("不要退追拉 霸脫")
                    .setPositiveButton("退追拉幹") { dialog, which ->
                        follow = !follow
                        userArr[currentUserNum].followed = follow
                        btn_message.visibility = View.INVISIBLE
                        btn_follow.layoutParams = LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT, LinearLayout.LayoutParams.WRAP_CONTENT, 0F)
                        btn_follow.text = "追追追"
                        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.JELLY_BEAN) {
                            btn_follow.background = null
                        }
                    }
                    .setNegativeButton("先不要..." ) {dialog, which ->  }
                    .show()
            } else {
                follow = !follow
                userArr[currentUserNum].followed = follow
                btn_message.visibility = View.VISIBLE
                btn_follow.layoutParams = LinearLayout.LayoutParams(65, 65 ,0F)
                btn_follow.text = ""
                btn_follow.setBackgroundResource(R.drawable.followed)
            }
        }

        val adapter = FragmentAdapter(supportFragmentManager)
        viewpager.adapter = adapter
        tab.setupWithViewPager(viewpager)
        setTabLayoutIcon()
    }

    fun setTabLayoutIcon() {
        tab.getTabAt(0)?.setIcon(R.drawable.grid)
        tab.getTabAt(1)?.setIcon(R.drawable.onebyone)
        tab.getTabAt(2)?.setIcon(R.drawable.nofunction)
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.menu, menu)
        return true
    }

    override fun onBackPressed() {
        super.onBackPressed()
    }

    override fun onOptionsItemSelected(item: MenuItem?): Boolean {
        when (item?.itemId) {
            android.R.id.home -> {
                onBackPressed()
            }
        }
        return super.onOptionsItemSelected(item)
    }
}
