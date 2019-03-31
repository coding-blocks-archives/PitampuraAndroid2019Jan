package com.codingblocks.newsDb.ui.adapter

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.codingblocks.newsDb.R
import com.codingblocks.newsDb.RvItemClickHandler
import com.codingblocks.newsDb.model.News
import kotlinx.android.synthetic.main.item_news.view.*

class NewsAdapter(private val newsItems: List<News>, val clickHandler: RvItemClickHandler) :
    RecyclerView.Adapter<NewsAdapter.NewsHolder>() {

    override fun onCreateViewHolder(viewGroup: ViewGroup, p1: Int): NewsHolder {
        val inflatedView = LayoutInflater.from(viewGroup.context)
            .inflate(R.layout.item_news, viewGroup, false)

        return NewsHolder(inflatedView)
    }

    override fun getItemCount() = newsItems.size

    override fun onBindViewHolder(holder: NewsHolder, position: Int) {

        val currentNews = newsItems[position]

        clickHandler.onItemClicked(currentNews)

        with(holder.itemView) {
            tvNewsTitle.text = currentNews.title
            tvNewsSource.text = currentNews.source?.name
            tvNewsUrl.text = currentNews.url
        }

    }

    class NewsHolder(itemView: View) : RecyclerView.ViewHolder(itemView)

}