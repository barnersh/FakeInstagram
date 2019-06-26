package com.example.instagram.View

import android.content.Context
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import android.widget.ImageView
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import com.example.instagram.Adapter
import com.example.instagram.HomePageAdapter
import com.example.instagram.Model.IModel
import com.example.instagram.Model.Model
import com.example.instagram.Presenter.IPresenter
import com.example.instagram.Presenter.Presenter
import com.example.instagram.R
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity(), IView {

    val iPresenter: IPresenter = Presenter(this)
    val iModel: IModel = Model()
    lateinit var arrShotPic: Array<Int>
    companion object {
        val GRID = 0
        val ONE = 1
    }

    override fun onBackPressed() {
        super.onBackPressed()

    }
    override fun glideCircle(img: ImageView, position: Int) {
        Glide
            .with(this)
            .load(arrShotPic[position])
            .apply(RequestOptions.circleCropTransform())
            .into(img)
    }

    override fun glide(img: ImageView, res: Int) {
        Glide
            .with(this)
            .load(res)
            .into(img)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        iModel.objectInit(this)
        arrShotPic = iModel.passShotPicArr()

        //限時動態adapter
        val adapter = Adapter(arrShotPic, this)
        val layoutManager = LinearLayoutManager(this)
        layoutManager.orientation = LinearLayoutManager.HORIZONTAL
        r_view.adapter = adapter
        r_view.layoutManager = layoutManager

        //主畫面adapter
        val homeAdapter = HomePageAdapter(iModel.passObjArr(), this, iPresenter, this)
        val homeLayoutManager = LinearLayoutManager(this)
        homeLayoutManager.orientation = LinearLayoutManager.VERTICAL
        home_view.adapter = homeAdapter
        home_view.layoutManager = homeLayoutManager
    }
}
