package com.example.instagram

import com.example.instagram.View.ProfileActivity
import android.content.Intent
import android.support.v7.widget.RecyclerView
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import com.example.instagram.Model.User
import com.example.instagram.Presenter.IPresenter
import com.example.instagram.View.IView
import com.example.instagram.View.MainActivity

class HomePageAdapter(
    val objArr: ArrayList<User>,
    val iView: IView,
    val iPresenter: IPresenter,
    val activity: MainActivity
) :
    RecyclerView.Adapter<HomePageAdapter.ViewHolder>() {
    override fun onCreateViewHolder(p0: ViewGroup, p1: Int): ViewHolder {
        val v = View.inflate(p0.context, R.layout.homepage, null)
        return ViewHolder(v)
    }

    override fun getItemCount(): Int {
        return objArr.size
    }

    override fun onBindViewHolder(p0: ViewHolder, p1: Int) {
        iView.glide(p0.img_shot, objArr[p1].shot)
        p0.tv_userName.setText(objArr[p1].name)
        p0.img_shot.setOnClickListener {
            val intent = Intent(activity, ProfileActivity::class.java)
            intent.putExtra("name", objArr[p1].name)
            iPresenter.onClick(activity, intent)
        }
        p0.tv_userName.setOnClickListener {
            val intent = Intent(activity, ProfileActivity::class.java)
//            val bundle = Bundle()
//            bundle.putSerializable("user", objArr)
//            intent.putExtras(bundle)
            intent.putExtra("name", objArr[p1].name)
            iPresenter.onClick(activity, intent)
        }
        //get last item in array
        iView.glide(p0.img_content, objArr[p1].contentPic[0])
        p0.tv_content.setText(objArr[p1].content[0])
    }

    class ViewHolder(v: View) : RecyclerView.ViewHolder(v) {
        val img_shot = v.findViewById<ImageView>(R.id.img_shot)
        val tv_userName = v.findViewById<TextView>(R.id.tv_userName)
        val img_content = v.findViewById<ImageView>(R.id.img_content)
        val tv_content = v.findViewById<TextView>(R.id.tv_content)
    }
}