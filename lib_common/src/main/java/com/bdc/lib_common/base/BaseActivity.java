package com.bdc.lib_common.base;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.Window;

public abstract class BaseActivity <V extends BaseMvpView, P extends BasePresenter> extends AppCompatActivity {
    private V mView;
    private P mPresenter;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(getLayoutId());
        if(mPresenter==null){
            mPresenter=createPresenter();
        }
        if(mView==null){
            mView=createMvpView();
        }
        if(mPresenter != null && mView != null){
            mPresenter.attachView(mView);
        }
        init();

    }

    protected abstract void init();

    protected abstract V createMvpView();

    protected abstract P createPresenter();

    protected abstract int getLayoutId();

    @Override
    protected void onDestroy() {
        super.onDestroy();
        if (mPresenter != null) {
            mPresenter.dettachView();
        }
    }

    public V getmView() {
        return mView;
    }
    public P getmPresenter() {
        return mPresenter;
    }
}
