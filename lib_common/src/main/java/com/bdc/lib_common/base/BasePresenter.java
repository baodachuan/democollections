package com.bdc.lib_common.base;

public abstract class BasePresenter<V extends BaseMvpView> {
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
