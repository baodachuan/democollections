package com.bdc.moudule_android_arch.net;


import androidx.lifecycle.LiveData;

import com.bdc.moudule_android_arch.bean.ArticleEntity;
import com.bdc.moudule_android_arch.bean.PageList;
import com.bdc.moudule_android_arch.bean.Response;
import com.github.leonardoxh.livedatacalladapter.Resource;

import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Path;

/**
 * Created by arvinljw on 2018/10/31 14:43
 * Function：
 * Desc：
 */
public interface Api {
    String BASE_URL = "http://wanandroid.com/";

    /*=======首页======*/
    @GET("article/list/{page}/json")
    LiveData<Resource<Response<PageList<ArticleEntity>>>> getIndexArticles(@Path("page") int page);


    @POST("article/query/{page}/json")
    @FormUrlEncoded
    LiveData<Resource<Response<PageList<ArticleEntity>>>> getSearchArticles(@Path("page") int page, @Field("k") String k);







}
