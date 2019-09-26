package com.bdc.module_rss.net;

import androidx.lifecycle.LiveData;

import com.bdc.module_rss.bean.FeedBean;
import com.github.leonardoxh.livedatacalladapter.Resource;

import retrofit2.http.GET;
import retrofit2.http.Query;

public interface FeedApi {
    String BASE_URL = "http://feedly.com/v3/";

    @GET("search/feeds")
    LiveData<Resource<FeedBean>> searchFeed(@Query("query")String name);
}
