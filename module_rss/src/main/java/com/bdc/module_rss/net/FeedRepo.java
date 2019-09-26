package com.bdc.module_rss.net;

import androidx.lifecycle.LiveData;

import com.bdc.module_rss.bean.FeedBean;
import com.github.leonardoxh.livedatacalladapter.Resource;

public class FeedRepo {

    public static LiveData<Resource<FeedBean>> searchFeeds(String name){
        return FeedNet.api().searchFeed(name);
    }



}
