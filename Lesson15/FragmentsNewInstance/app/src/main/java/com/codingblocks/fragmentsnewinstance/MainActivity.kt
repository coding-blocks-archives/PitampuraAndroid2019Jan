package com.codingblocks.fragmentsnewinstance

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v4.app.FragmentManager
import android.support.v4.app.FragmentPagerAdapter
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

//    private val fragments = arrayListOf(
//            MyFragment().apply {
//                val bundle = Bundle().apply {
//                    putInt("POSITION",0)
//                }
//                arguments = bundle
//            },
//            MyFragment().apply {
//                val bundle = Bundle().apply {
//                    putInt("POSITION",1)
//                }
//                arguments = bundle
//            },
//            MyFragment().apply {
//                val bundle = Bundle().apply {
//                    putInt("POSITION",2)
//                }
//                arguments = bundle
//            },
//            MyFragment().apply {
//                val bundle = Bundle().apply {
//                    putInt("POSITION",3)
//                }
//                arguments = bundle
//            },
//            MyFragment().apply {
//                val bundle = Bundle().apply {
//                    putInt("POSITION",4)
//                }
//                arguments = bundle
//            }
//    )


    val fragments = listOf(
            MyFragment.newInstance(0),
            MyFragment.newInstance(1),
            MyFragment.newInstance(2),
            MyFragment.newInstance(3),
            MyFragment.newInstance(4)
    )

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

//        val fragment = MyFragment()
//
//        val bundle = Bundle()
//        bundle.putInt("POSITION", 0)
//
//        fragment.arguments = bundle
//
//        MyFragment().apply {
//            val bundle = Bundle()
//            bundle.putInt("POSITION", 0)
//            arguments = bundle
//        }
//

        val viewPagerAdapter = ViewPagerAdapter(supportFragmentManager, fragments)

        viewPager.adapter = viewPagerAdapter

        //Call this to make any updates in the viewpager
//        viewPagerAdapter.notifyDataSetChanged()
    }

}

class ViewPagerAdapter(fm: FragmentManager?, private val fragments: List<MyFragment>) : FragmentPagerAdapter(fm) {

    override fun getItem(position: Int) = fragments[position]
    override fun getCount() = fragments.size

}
