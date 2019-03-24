package com.codingblocks.fragmentsnewinstance

import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import kotlinx.android.synthetic.main.fragment_my.view.*

class MyFragment : Fragment() {

    companion object {

//        var myFragment: MyFragment? = null
//
//        //For getting the same unique instance of the fragment on every call;
//        //i.e. Singleton pattern
//        fun getInstance(position: Int): Fragment? {
//
//            if (myFragment == null) {
//                myFragment = MyFragment()
//            }
//
//            myFragment.apply {
//                val bundle = Bundle()
//                bundle.putInt("POSITION", position)
//                this!!.arguments = bundle
//            }
//
//            return myFragment
//
//        }

        //For getting a new instance of the fragment
        fun newInstance(position: Int): MyFragment {
            return MyFragment().apply {
                val bundle = Bundle()
                bundle.putInt("POSITION", position)
                arguments = bundle
            }
        }
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View {
        return inflater.inflate(R.layout.fragment_my, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        view.tvFragment.text = arguments?.getInt("POSITION").toString()
    }


}