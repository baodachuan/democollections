package com.bdc.lib_common.base;

import android.arch.lifecycle.LifecycleObserver;

public abstract class BasePresenter<V extends BaseMvpView> implements LifecycleObserver {
    public V mView;

    public V getView() {
        return mView;
    }

    public void attachView(V v) {
        this.mView = v;
    }

    public void dettachView() {
        mView = null;
    }

    public void getData(){

    }
}
