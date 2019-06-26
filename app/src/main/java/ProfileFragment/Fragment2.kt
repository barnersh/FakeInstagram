package ProfileFragment


import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.LinearLayout
import com.example.instagram.Model.IModel
import com.example.instagram.Model.Model
import com.example.instagram.PersonalAdapter
import com.example.instagram.Presenter.IPresenter
import com.example.instagram.Presenter.Presenter

import com.example.instagram.R
import com.example.instagram.View.IView
import com.example.instagram.View.MainActivity.Companion.ONE
import com.example.instagram.View.thisUser
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.fragment_fragment2.*

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [ProfileFragment] subclass.
 *
 */
class Fragment2 : Fragment(), IView {
    //--------------------------------------------------------------
    override fun glideCircle(img: ImageView, position: Int) {
    }

    override fun glide(img: ImageView, res: Int) {
    }
    //---------------------------------------------------------------
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val rootView = inflater.inflate(R.layout.fragment_fragment2, container, false)
        val iModel: IModel = Model()
        val iPresenter: IPresenter = Presenter(this)
        val userArr = iModel.passObjArr()

        val r_viewOnebyOne = rootView.findViewById<RecyclerView>(R.id.r_viewOnebyOne)
        val adapter = PersonalAdapter(userArr, iPresenter.findCurrentUser(thisUser), this, ONE, iPresenter)
        val layoutManager = LinearLayoutManager(context)
        layoutManager.orientation = LinearLayoutManager.VERTICAL
        r_viewOnebyOne.adapter = adapter
        r_viewOnebyOne.layoutManager = layoutManager

        return rootView
    }


}
