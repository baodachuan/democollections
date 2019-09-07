package com.bdc.module_rss;

import android.arch.lifecycle.LiveData;
import android.arch.lifecycle.MutableLiveData;
import android.arch.lifecycle.ViewModel;

import com.prof.rssparser.Article;
import com.prof.rssparser.OnTaskCompleted;
import com.prof.rssparser.Parser;

import java.util.ArrayList;
import java.util.List;

public class MainViewModel extends ViewModel {
    private MutableLiveData<List<Article>> articleListLive = null;
    private String urlString = "https://xueqiu.com/hots/topic/rss";

    private MutableLiveData<String> snackbar = new MutableLiveData<>();

    public MutableLiveData<List<Article>> getArticleList() {
        if (articleListLive == null) {
            articleListLive = new MutableLiveData<>();
        }
        return articleListLive;
    }

    private void setArticleList(List<Article> articleList) {
        this.articleListLive.postValue(articleList);
    }

    public LiveData<String> getSnackbar() {
        return snackbar;
    }

    public void onSnackbarShowed() {
        snackbar.setValue(null);
    }

    public void fetchFeed() {

        Parser parser = new Parser();
        parser.onFinish(new OnTaskCompleted() {

            //what to do when the parsing is done
            @Override
            public void onTaskCompleted(List<Article> list) {
                setArticleList(list);
            }

            //what to do in case of error
            @Override
            public void onError(Exception e) {
                setArticleList(new ArrayList<Article>());
                e.printStackTrace();
                snackbar.postValue("An error has occurred. Please try again");
            }
        });
        parser.execute(urlString);
    }
}
