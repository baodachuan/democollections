package com.bdc.module_rss.ui;

import com.bdc.lib_common.base.BaseFragment;
import com.bdc.module_rss.R;
import com.bdc.module_rss.contract.MainFragmentContract;
import com.bdc.module_rss.presenter.MainFragmentPresenter;

public class MainFragment extends BaseFragment<MainFragmentContract.View,MainFragmentContract.Presenter> implements MainFragmentContract.View {
    @Override
    protected MainFragmentContract.View createMvpView() {
        return this;
    }

    @Override
    protected MainFragmentContract.Presenter createPresenter() {
        MainFragmentPresenter presenter=new MainFragmentPresenter();
        return presenter;
    }

    @Override
    protected int getLayoutId() {
        return R.layout.rss_main_fragment;
    }
}
