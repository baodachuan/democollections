package com.bdc.module_rss;

import android.arch.lifecycle.Observer;
import android.arch.lifecycle.ViewModelProviders;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ProgressBar;

import com.alibaba.android.arouter.facade.annotation.Route;
import com.bdc.lib_common.Constants;
import com.bdc.module_rss.adapter.ArticleAdapter;
import com.prof.rssparser.Article;

import java.util.List;

@Route(path = Constants.MODULE_RSS_MAIN)
public class RssMainActivity extends AppCompatActivity {
    private MainViewModel viewModel;
    private ProgressBar progressBar;
    private RecyclerView mRecyclerView;
    private ArticleAdapter mAdapter;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.rss_main);

        viewModel = ViewModelProviders.of(this).get(MainViewModel.class);
        progressBar = findViewById(R.id.progressBar);

        mRecyclerView = findViewById(R.id.recycler_view);
        mRecyclerView.setLayoutManager(new LinearLayoutManager(this));
        mRecyclerView.setItemAnimator(new DefaultItemAnimator());
        mRecyclerView.setHasFixedSize(true);



        viewModel.getArticleList().observe(this, new Observer<List<Article>>() {
            @Override
            public void onChanged(List<Article> articles) {
                if (articles != null) {
                    mAdapter = new ArticleAdapter(articles, RssMainActivity.this);
                    mRecyclerView.setAdapter(mAdapter);
                    mAdapter.notifyDataSetChanged();
                    progressBar.setVisibility(View.GONE);
//                    mSwipeRefreshLayout.setRefreshing(false);
                }
            }
        });
        viewModel.fetchFeed();
    }
}
