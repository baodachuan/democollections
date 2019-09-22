package com.bdc.moudule_android_arch.repos;


import androidx.lifecycle.LiveData;

import com.bdc.moudule_android_arch.bean.ArticleEntity;
import com.bdc.moudule_android_arch.bean.PageList;
import com.bdc.lib_common.data.Response;
import com.bdc.moudule_android_arch.net.Net;
import com.github.leonardoxh.livedatacalladapter.Resource;


/**
 * Created by arvinljw on 2018/11/16 16:25
 * Function：
 * Desc：
 */
public class ArticlesRepo {

    public static LiveData<Resource<Response<PageList<ArticleEntity>>>> getSearchArticles(int currPage, String searchKey) {
        return Net.api().getSearchArticles(currPage, searchKey);
    }

    public static LiveData<Resource<Response<PageList<ArticleEntity>>>> getIndexArticles(int page) {
        return Net.api().getIndexArticles(page);
    }
}
