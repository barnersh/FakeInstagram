package com.example.instagram.View

import android.content.Context
import com.example.instagram.FragmentAdapter
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.Menu
import android.view.MenuItem
import android.widget.ImageView
import com.bumptech.glide.Glide
import com.example.instagram.Model.IModel
import com.example.instagram.Model.Model
import com.example.instagram.Model.User
import com.example.instagram.Presenter.IPresenter
import com.example.instagram.Presenter.Presenter
import com.example.instagram.R
import kotlinx.android.synthetic.main.activity_profile.*

var thisUser = ""

class ProfileActivity : AppCompatActivity(), IView {
    //**********************************************************************
    override fun showShotPic(img: ImageView, position: Int) {
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
        setSupportActionBar(toolbar)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        supportActionBar?.title = thisUser

        userArr = iModel.passObjArr()

        Log.d("size", userArr.size.toString())


        tv_profile.text = userArr[iPresenter.findCurrentUser(thisUser)].profile
        glide(img_user, userArr[iPresenter.findCurrentUser(thisUser)].shot)

        val adapter = FragmentAdapter(supportFragmentManager)
        viewpager.adapter = adapter
        tab.setupWithViewPager(viewpager)
        setTabLayoutIcon()

//        val gridAdapter = PersonalAdapter(userArr[currentUser].contentPic, this)
//        val gridLayoutManager = GridLayoutManager(this, 3)
//        gridLayoutManager.orientation = GridLayoutManager.HORIZONTAL
//        r_viewGrid.adapter = gridAdapter
//        r_viewGrid.layoutManager = gridLayoutManager
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
