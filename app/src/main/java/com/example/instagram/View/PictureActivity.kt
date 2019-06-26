package com.example.instagram.View

import android.os.Build
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.LayoutInflater
import android.view.MenuItem
import android.view.View
import android.widget.ImageView
import com.bumptech.glide.Glide
import com.example.instagram.Model.IModel
import com.example.instagram.Model.Model
import com.example.instagram.Presenter.IPresenter
import com.example.instagram.Presenter.Presenter
import com.example.instagram.R
import kotlinx.android.synthetic.main.activity_picture.*
import kotlinx.android.synthetic.main.homepage.*

class PictureActivity : AppCompatActivity(), IView {
    //-------------------------------------------------------------
    override fun glideCircle(img: ImageView, position: Int) {
    }

    override fun glide(img: ImageView, res: Int) {
    }
    //--------------------------------------------------------------
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_picture)

        val iModel: IModel = Model()
        val iPresenter: IPresenter = Presenter(this)

        //toolbar
        setSupportActionBar(toolbar_picture)
        supportActionBar?.title = "相片"
        supportActionBar?.setDisplayHomeAsUpEnabled(true)

        val numClick = intent.getIntExtra("num", 0)

        val userArr = iModel.passObjArr()
        val thisUserNum = iPresenter.findCurrentUser(thisUser)
        Glide
            .with(this)
            .load(userArr[thisUserNum].shot)
            .into(img_shot)
        tv_userName.text = userArr[thisUserNum].name
        Glide
            .with(this)
            .load(userArr[thisUserNum].contentPic.get(numClick))
            .into(img_content)
        tv_content.text = resources.getString(userArr[thisUserNum].content.get(numClick))
        tv_like.text = userArr[thisUserNum].like.get(numClick).toString() + "個讚"

        tv_content.setOnClickListener {
            iPresenter.changeMaxLine(tv_content)
        }
    }

    override fun onBackPressed() {
        super.onBackPressed()
    }

    override fun onOptionsItemSelected(item: MenuItem?): Boolean {
//        return super.onOptionsItemSelected(item)
        when (item?.itemId) {
            android.R.id.home -> {
                onBackPressed()
            }
        }
        return true
    }
}
