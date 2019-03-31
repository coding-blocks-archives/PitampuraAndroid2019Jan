package com.codingblocks.newsDb.ui.activity

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v4.app.FragmentManager
import android.support.v4.app.FragmentPagerAdapter
import androidx.work.Data
import androidx.work.PeriodicWorkRequestBuilder
import androidx.work.WorkManager
import com.codingblocks.newsDb.R
import com.codingblocks.newsDb.RvItemClickHandler
import com.codingblocks.newsDb.model.News
import com.codingblocks.newsDb.ui.fragment.NewsFragment
import com.codingblocks.newsDb.worker.NewsFetchWorker
import kotlinx.android.synthetic.main.activity_main.*
import java.util.concurrent.TimeUnit

class MainActivity : AppCompatActivity(), RvItemClickHandler {

    override fun onItemClicked(news: News) {
        //Do whatever you want with the news
        //Either start a new Intent or Start a new Fragment here
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        viewPager.adapter = PagerAdapter(supportFragmentManager)

        val businessNewsFetchWorker = PeriodicWorkRequestBuilder<NewsFetchWorker>(1, TimeUnit.DAYS)
            .setInputData(Data.Builder().putString("ENDPOINT", "business").build())
            .build()


        val scienceNewsFetchWorker = PeriodicWorkRequestBuilder<NewsFetchWorker>(1, TimeUnit.DAYS)
            .setInputData(Data.Builder().putString("ENDPOINT", "science").build())
            .build()


        val techNewsFetchWorker = PeriodicWorkRequestBuilder<NewsFetchWorker>(1, TimeUnit.DAYS)
            .setInputData(Data.Builder().putString("ENDPOINT", "technology").build())
            .build()

        WorkManager.getInstance().enqueue(
            listOf(
                businessNewsFetchWorker,
                scienceNewsFetchWorker,
                techNewsFetchWorker
            )
        )

    }

    class PagerAdapter(fm: FragmentManager?) : FragmentPagerAdapter(fm) {

        override fun getItem(position: Int): Fragment? {

            when (position) {
                0 -> {
                    return NewsFragment.newInstance("business")
                }
                1 -> {
                    return NewsFragment.newInstance("science")
                }
                2 -> {
                    return NewsFragment.newInstance("technology")
                }
            }
            return null
        }

        override fun getCount() = 3
    }
}
