package com.bdc.module_rss.ui;

import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.alibaba.android.arouter.launcher.ARouter;
import com.bdc.lib_common.Constants;
import com.bdc.lib_common.base.BaseFragment;
import com.bdc.module_rss.R;
import com.bdc.module_rss.adapter.SubScribeAdapter;
import com.bdc.module_rss.bean.RssSourceBean;
import com.bdc.module_rss.contract.SubscribeFragmentContract;
import com.bdc.module_rss.model.SubscribeViewModel;
import com.bdc.module_rss.presenter.SubscribeFragmentPresenter;

import java.util.ArrayList;
import java.util.List;

public class SubscribeFragment extends BaseFragment<SubscribeFragmentContract.View, SubscribeFragmentContract.Presenter> implements SubscribeFragmentContract.View, View.OnClickListener {
    private EditText et_addName;
    private EditText et_addUrl;
    private Button button;
    private Button toArticleList;
    private RecyclerView rv_subscribed;

    List<RssSourceBean> mDataBeans =new ArrayList<>();
    SubScribeAdapter adapter;

    @Override
    protected void init(View rootView) {
        et_addName = rootView.findViewById(R.id.add_source_name);
        et_addUrl = rootView.findViewById(R.id.add_source_url);
        button = rootView.findViewById(R.id.add_to_subscribe);
        toArticleList = rootView.findViewById(R.id.to_article_list);

        rv_subscribed =rootView.findViewById(R.id.subscribed_source_rv);
        rv_subscribed.setLayoutManager(new LinearLayoutManager(getContext()));
        rv_subscribed.setItemAnimator(new DefaultItemAnimator());
         adapter= new SubScribeAdapter(mDataBeans,getContext());
        rv_subscribed.setAdapter(adapter);
        button.setOnClickListener(this);
        toArticleList.setOnClickListener(this);
        getPresenter().initModel();
        getPresenter().getData();


    }

    @Override
    protected SubscribeFragmentContract.View createMvpView() {
        return this;
    }

    @Override
    protected SubscribeFragmentContract.Presenter createPresenter() {
        SubscribeFragmentPresenter presenter = new SubscribeFragmentPresenter(getContext());
        SubscribeViewModel viewModel= ViewModelProviders.of(this).get(SubscribeViewModel.class);
        presenter.setViewModel(viewModel);
        return presenter;
    }

    @Override
    protected int getLayoutId() {
        return R.layout.rss_main_fragment;
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.add_to_subscribe:
                String name = et_addName.getText().toString();
                String url = et_addUrl.getText().toString();
                RssSourceBean bean = new RssSourceBean(name, url);
                getPresenter().addSource(bean);
                break;
            case R.id.to_article_list:
                ARouter.getInstance().build(Constants.MODULE_RSS_MAIN).navigation();
                break;
        }

    }

    @Override
    public void refreshUI(List<RssSourceBean> dataBases) {
        mDataBeans.clear();
        mDataBeans.addAll(dataBases);
        adapter.notifyDataSetChanged();
    }
}
