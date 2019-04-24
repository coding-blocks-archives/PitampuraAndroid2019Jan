package com.codingblocks.roomlivedata;

import com.codingblocks.roomlivedata.model.News;

import java.util.ArrayList;
import java.util.List;

public class Utils {

    private static List<News> news = new ArrayList<>();

    public static List<News> getNewsList() {

        if (news.isEmpty()) {
            //Fetch and populate news from the db
        }

        return news;
    }

}
