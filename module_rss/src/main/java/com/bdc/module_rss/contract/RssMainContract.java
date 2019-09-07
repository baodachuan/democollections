package com.bdc.module_rss.contract;

import com.bdc.lib_common.base.BaseMvpView;
import com.bdc.lib_common.base.BasePresenter;
import com.prof.rssparser.Article;

import java.util.List;

public interface RssMainContract {
     interface View extends BaseMvpView{
         void showArticle(List<Article> articles);
     }

    abstract class Presenter extends BasePresenter<View>{

    }
}
