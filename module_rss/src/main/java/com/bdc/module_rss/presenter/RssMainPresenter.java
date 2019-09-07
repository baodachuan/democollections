package com.bdc.module_rss.presenter;


import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.Observer;

import com.bdc.module_rss.MainViewModel;
import com.bdc.module_rss.contract.RssMainContract;
import com.prof.rssparser.Article;

import java.util.List;

public class RssMainPresenter extends RssMainContract.Presenter {
    private MainViewModel mainViewModel;

    public RssMainPresenter(){

    }

    public void setMode(MainViewModel viewModel){
        this.mainViewModel=viewModel;

    }

    @Override
    public void getData() {
//        mainViewModel= (MainViewModel) viewModel;
        mainViewModel.getArticleList().observe((LifecycleOwner) getView(), new Observer<List<Article>>() {
            @Override
            public void onChanged(List<Article> articles) {
                if (articles != null) {
                    getView().showArticle(articles);

                }
            }
        });
        mainViewModel.fetchFeed();
    }



}
