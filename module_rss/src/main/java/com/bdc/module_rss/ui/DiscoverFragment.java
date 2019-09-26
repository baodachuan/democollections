package com.bdc.module_rss.ui;

import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.lifecycle.Observer;

import com.bdc.lib_common.Constants;
import com.bdc.lib_common.base.BaseFragment;
import com.bdc.module_rss.R;
import com.bdc.module_rss.bean.FeedBean;
import com.bdc.module_rss.contract.DiscoverContract;
import com.bdc.module_rss.net.FeedRepo;
import com.bdc.module_rss.presenter.DiscoveryPresenter;
import com.github.leonardoxh.livedatacalladapter.Resource;

import java.util.List;

public class DiscoverFragment extends BaseFragment<DiscoverContract.View,DiscoverContract.Presenter> implements DiscoverContract.View {
    private EditText editText;
    private Button button;
    @Override
    protected void init(View rootView) {
        editText=rootView.findViewById(R.id.search_input);
        button=rootView.findViewById(R.id.search_button);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
               beginSearch();

            }
        });

    }

    private void beginSearch() {
        FeedRepo.searchFeeds(editText.getText().toString()).observe(this, new Observer<Resource<FeedBean>>() {
            @Override
            public void onChanged(Resource<FeedBean> feedBeanResource) {
                FeedBean resource = feedBeanResource.getResource();
                List<FeedBean.ResultsBean> results = resource.getResults();
                Log.e(Constants.TAG,"resources is "+ results);
            }
        });

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
