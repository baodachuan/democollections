package com.bdc.lib_common.base;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

public abstract class BaseFragment  <V extends BaseMvpView, P extends BasePresenter> extends Fragment {

    private V mView;
    private P mPresenter;
    private Context mContext;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view =inflater.inflate(getLayoutId(),container,false);
        mContext=getActivity();
        if(mPresenter==null){
            mPresenter=createPresenter();
        }
        if(mView==null){
            mView=createMvpView();
        }

        if(mPresenter != null && mView != null) {
            mPresenter.attachView(mView);
        }
        return view;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        if (mPresenter != null) {
            mPresenter.dettachView();
        }
    }

    protected abstract V createMvpView();

    protected abstract P createPresenter();

    protected abstract int getLayoutId();
}