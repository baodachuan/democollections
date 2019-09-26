package com.bdc.module_rss.ui;

import android.view.View;

import com.bdc.lib_common.base.BaseFragment;
import com.bdc.module_rss.R;
import com.bdc.module_rss.contract.DiscoverContract;
import com.bdc.module_rss.presenter.DiscoveryPresenter;

public class DiscoverFragment extends BaseFragment<DiscoverContract.View,DiscoverContract.Presenter> implements DiscoverContract.View {
    @Override
    protected void init(View rootView) {

    }

    @Override
    protected DiscoverContract.View createMvpView() {
        return this;
    }

    @Override
    protected DiscoverContract.Presenter createPresenter() {
        return new DiscoveryPresenter();
    }

    @Override
    protected int getLayoutId() {
        return R.layout.rss_discovery_fragment;
    }
}
