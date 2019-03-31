package com.codingblocks.newsDb.ui.fragment

import android.arch.persistence.room.Room
import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v7.widget.LinearLayoutManager
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.work.*
import com.codingblocks.newsDb.R
import com.codingblocks.newsDb.RvItemClickHandler
import com.codingblocks.newsDb.db.NewsDatabase
import com.codingblocks.newsDb.model.News
import com.codingblocks.newsDb.ui.adapter.NewsAdapter
import com.codingblocks.newsDb.worker.NewsFetchWorker
import com.google.gson.Gson
import kotlinx.android.synthetic.main.fragment_news.*
import okhttp3.*

class NewsFragment : Fragment() {

    private val newsItems = arrayListOf<News>()

    private val newsDatabase by lazy {
        Room.databaseBuilder(requireContext(), NewsDatabase::class.java, "news.db")
            .fallbackToDestructiveMigration()
            .allowMainThreadQueries()
            .build()
    }

    private val newsDao by lazy {
        newsDatabase.getNewsDao()
    }

    companion object {

        fun newInstance(endpoint: String): NewsFragment {

            val newsFragment = NewsFragment()

            val arguments = Bundle()

            arguments.putString("ENDPOINT", endpoint)

            newsFragment.arguments = arguments

            return newsFragment

//            return NewsFragment().apply {
//
//                arguments = Bundle().apply {
//                    putString("ENDPOINT", endpoint)
//                }
//
//            }
        }
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.fragment_news, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        rvNews.layoutManager = LinearLayoutManager(requireContext())
        val newsAdapter =
            NewsAdapter(newsItems, activity as RvItemClickHandler)
        rvNews.adapter = newsAdapter

        val endpoint = arguments?.getString("ENDPOINT") ?: ""

        if (newsDao.getAllNews(endpoint).isNullOrEmpty()) {
            //Do the network call if the db is empty
            val newsWork = OneTimeWorkRequestBuilder<NewsFetchWorker>()
                .setInputData(Data.Builder().putString("ENDPOINT", endpoint).build())
                .build()

            WorkManager.getInstance().enqueue(newsWork)

            //Since we can't update the UI from a Worker, we instead attach a listener inside our Fragment/Activity
            //and then update the UI from the Fragment/Activity if the result of the Worker succeeds

            WorkManager.getInstance().getWorkInfoByIdLiveData(newsWork.id)
                .observeForever {
                    //This is happening on the UI thread
                    if (it?.state == WorkInfo.State.SUCCEEDED) {
                        newsItems.clear()
                        newsItems.addAll(newsDao.getAllNews(endpoint))
                        newsAdapter.notifyDataSetChanged()
                    }
                }
        } else {
            newsItems.clear()
            newsItems.addAll(newsDao.getAllNews(endpoint))
            newsAdapter.notifyDataSetChanged()
        }


    }

}