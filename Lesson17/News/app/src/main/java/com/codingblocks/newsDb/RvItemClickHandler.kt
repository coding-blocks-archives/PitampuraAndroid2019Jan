package com.codingblocks.newsDb

import com.codingblocks.newsDb.model.News

interface RvItemClickHandler {

    fun onItemClicked(news: News)

}