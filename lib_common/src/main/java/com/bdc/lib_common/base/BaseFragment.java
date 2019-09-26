package com.bdc.lib_common.base;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

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
        init(view);
        return view;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        if (mPresenter != null) {
            mPresenter.dettachView();
        }
    }

    protected abstract void init(View rootView);

    protected abstract V createMvpView();

    protected abstract P createPresenter();

    protected abstract int getLayoutId();

    public P getPresenter() {
        return mPresenter;
    }
}
