package com.bdc.module_rss.ui;

import com.bdc.lib_common.base.BaseFragment;
import com.bdc.module_rss.R;
import com.bdc.module_rss.contract.MineContract;
import com.bdc.module_rss.presenter.MinePresenter;

public class MineFragment extends BaseFragment<MineContract.View,MineContract.Presenter> implements MineContract.View {
    @Override
    protected MineContract.View createMvpView() {
        return this;
    }

    @Override
    protected MineContract.Presenter createPresenter() {
        return new MinePresenter();
    }

    @Override
    protected int getLayoutId() {
        return R.layout.rss_mine_fragment;
    }
}
