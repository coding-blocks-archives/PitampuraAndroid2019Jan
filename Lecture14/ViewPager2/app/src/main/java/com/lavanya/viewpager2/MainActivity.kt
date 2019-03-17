package com.lavanya.viewpager2

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v4.app.Fragment
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val fragmentslist = arrayListOf<Fragment>()

        fragmentslist.add(FragmentA())
        fragmentslist.add(FragmentB())
        fragmentslist.add(FragmentC())

        val pagerAdapeter = PagerAdapeter(fragmentslist, supportFragmentManager)

        viewPager.adapter = pagerAdapeter

        tablayout.setupWithViewPager(viewPager)
    }
}
