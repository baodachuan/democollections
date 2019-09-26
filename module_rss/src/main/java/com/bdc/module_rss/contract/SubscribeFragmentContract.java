package com.bdc.module_rss.contract;

import com.bdc.lib_common.base.BaseMvpView;
import com.bdc.lib_common.base.BasePresenter;
import com.bdc.module_rss.bean.RssSourceBean;

import java.util.List;

public interface SubscribeFragmentContract {
    interface View extends BaseMvpView{
        void refreshUI(List<RssSourceBean> dataBases);

    }
    abstract class Presenter extends BasePresenter<View>{
        public abstract void addSource(RssSourceBean bean);
        public abstract void deleteSource(RssSourceBean bean);

    }
}
