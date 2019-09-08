package com.bdc.lib_common.data;

import androidx.lifecycle.MutableLiveData;

import java.util.HashMap;
import java.util.Map;

public class LiveDataBus {
    private final Map<String, MutableLiveData<Object>> mBus;

    private LiveDataBus(){
        mBus=new HashMap<>();
    }

    private static class SingletonHolder{
        private static final LiveDataBus DATA_BUS=new LiveDataBus();
    }

    public static LiveDataBus getInstance(){
        return SingletonHolder.DATA_BUS;
    }

    public <T>MutableLiveData<T> with(String target, Class<T> type){
        if(!mBus.containsKey(target)){
            mBus.put(target,new MutableLiveData<>());
        }
        return (MutableLiveData<T>) mBus.get(target);
    }

    public MutableLiveData<Object> with(String target){
        return with(target,Object.class);
    }
}
