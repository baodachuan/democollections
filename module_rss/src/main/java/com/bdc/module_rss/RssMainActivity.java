package com.bdc.module_rss;

import android.arch.lifecycle.ViewModelProviders;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ProgressBar;

import com.alibaba.android.arouter.facade.annotation.Route;
import com.bdc.lib_common.Constants;
import com.bdc.lib_common.base.BaseActivity;
import com.bdc.module_rss.adapter.ArticleAdapter;
import com.bdc.module_rss.contract.RssMainContract;
import com.bdc.module_rss.presenter.RssMainPresenter;
import com.prof.rssparser.Article;

import java.util.List;

@Route(path = Constants.MODULE_RSS_MAIN)
public class RssMainActivity extends BaseActivity<RssMainContract.View,RssMainContract.Presenter> implements RssMainContract.View {
    private MainViewModel viewModel;
    private ProgressBar progressBar;
    private RecyclerView mRecyclerView;
    private ArticleAdapter mAdapter;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    protected void init() {
        progressBar = findViewById(R.id.progressBar);
        mRecyclerView = findViewById(R.id.recycler_view);
        mRecyclerView.setLayoutManager(new LinearLayoutManager(this));
        mRecyclerView.setItemAnimator(new DefaultItemAnimator());
        mRecyclerView.setHasFixedSize(true);
        getmPresenter().getData();
//        getLifecycle().addObserver(getmPresenter());


    }

    @Override
    protected RssMainContract.View createMvpView() {
        return this;
    }

    @Override
    protected RssMainContract.Presenter createPresenter() {
        RssMainPresenter rssMainPresenter=new RssMainPresenter();
        viewModel = ViewModelProviders.of(this).get(MainViewModel.class);
        rssMainPresenter.setMode(viewModel);
        return rssMainPresenter;
    }

    @Override
    protected int getLayoutId() {
        return R.layout.rss_main;
    }

    @Override
    public void showArticle(List<Article> articles) {
        mAdapter = new ArticleAdapter(articles, RssMainActivity.this);
        mRecyclerView.setAdapter(mAdapter);
        mAdapter.notifyDataSetChanged();
        progressBar.setVisibility(View.GONE);
//                    mSwipeRefreshLayout.setRefreshing(false);
    }
}
