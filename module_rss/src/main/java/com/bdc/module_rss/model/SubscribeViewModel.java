package com.bdc.module_rss.model;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.bdc.module_rss.bean.RssSourceBean;

import java.util.List;

public class SubscribeViewModel extends ViewModel {
    private MutableLiveData<List<RssSourceBean>> sourceListData = new MutableLiveData<>();

    public void setSourceData(List<RssSourceBean> datas){
        sourceListData.postValue(datas);
    }

    public MutableLiveData<List<RssSourceBean>> getSourceListData() {
        return sourceListData;
    }
}
