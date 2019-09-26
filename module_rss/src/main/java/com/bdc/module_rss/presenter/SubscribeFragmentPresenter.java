package com.bdc.module_rss.presenter;

import android.content.Context;

import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.Observer;
import androidx.room.Room;

import com.bdc.module_rss.bean.RssSourceBean;
import com.bdc.module_rss.contract.SubscribeFragmentContract;
import com.bdc.module_rss.database.RssSourceDao;
import com.bdc.module_rss.database.RssSourceDataBase;
import com.bdc.module_rss.model.SubscribeViewModel;
import com.bdc.module_rss.util.ThreadUtil;

import java.util.List;

public class SubscribeFragmentPresenter extends SubscribeFragmentContract.Presenter {
    RssSourceDao dao;
    SubscribeViewModel viewModel;
    public SubscribeFragmentPresenter(Context context) {
        RssSourceDataBase dataBase = Room.databaseBuilder(context, RssSourceDataBase.class, "rssSource").build();
        dao = dataBase.getRssDao();

    }

    @Override
    public void addSource(final RssSourceBean bean) {
        ThreadUtil.runOnSubThread(new Runnable() {
            @Override
            public void run() {
                dao.insertAll(bean);
                List<RssSourceBean> all = dao.getAll();
                viewModel.getSourceListData().postValue(all);
            }
        });



    }

    @Override
    public void deleteSource(RssSourceBean bean) {
        dao.delete(bean);
        List<RssSourceBean> all = dao.getAll();
        viewModel.getSourceListData().postValue(all);
    }

    public SubscribeViewModel getViewModel() {
        return viewModel;
    }

    public void setViewModel(SubscribeViewModel viewModel) {
        this.viewModel = viewModel;

    }

    @Override
    public void initModel() {
        this.viewModel.getSourceListData().observe((LifecycleOwner) getView(), new Observer<List<RssSourceBean>>() {
            @Override
            public void onChanged(List<RssSourceBean> rssSourceDataBases) {
                getView().refreshUI(rssSourceDataBases);
            }
        });
    }

    @Override
    public void getData() {
        ThreadUtil.runOnSubThread(new Runnable() {
            @Override
            public void run() {
                List<RssSourceBean> all = dao.getAll();
                viewModel.getSourceListData().postValue(all);
            }
        });
    }
}
