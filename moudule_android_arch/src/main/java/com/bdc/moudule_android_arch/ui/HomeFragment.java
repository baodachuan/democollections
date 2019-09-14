package com.bdc.moudule_android_arch.ui;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.RecyclerView;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;

import com.bdc.lib_common.Constants;
import com.bdc.moudule_android_arch.R;
import com.bdc.moudule_android_arch.adapter.ArticleAdapter;
import com.bdc.moudule_android_arch.adapter.RefreshLoadMoreHelper;
import com.bdc.moudule_android_arch.bean.ArticleEntity;
import com.bdc.moudule_android_arch.bean.PageList;
import com.bdc.moudule_android_arch.bean.Response;
import com.bdc.moudule_android_arch.net.ApiObserver;
import com.bdc.moudule_android_arch.repos.ArticlesRepo;
import com.chad.library.adapter.base.BaseQuickAdapter;


/**
 * Created by arvinljw on 2018/11/16 14:41
 * Function：
 * Desc：
 */
public class HomeFragment extends Fragment implements BaseQuickAdapter.OnItemClickListener, IRefreshPage {
    private static final String ARG_PAGE = "arg_page";
    private View headerView;

    protected View root;
    private RefreshLoadMoreHelper<ArticleEntity> refreshLoadMoreHelper;

    protected int getContentView() {
        return R.layout.arch_fragment_home;
    }

    public static HomeFragment newInstance(int page) {
        Bundle args = new Bundle();
        args.putInt(ARG_PAGE, page);
        HomeFragment zFragment = new HomeFragment();
        zFragment.setArguments(args);
        return zFragment;
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        root = inflater.inflate(getContentView(), container, false);
        init(savedInstanceState);
        return root;
    }

    protected void init(Bundle savedInstanceState) {
        SwipeRefreshLayout refreshLayout = root.findViewById(R.id.refresh_layout);
        RecyclerView recyclerView = root.findViewById(R.id.recycler_home);

        refreshLoadMoreHelper = new RefreshLoadMoreHelper<>(this, refreshLayout, recyclerView, ArticleAdapter.class);
        refreshLoadMoreHelper.setOnItemClickListener(this);
        refreshLoadMoreHelper.autoRefresh();
//        loadData();

    }


    @Override
    public void loadData() {
        ArticlesRepo.getIndexArticles(refreshLoadMoreHelper.getCurrPage()).observe(this, new ApiObserver<PageList<ArticleEntity>>() {
            @Override
            public void onSuccess(Response<PageList<ArticleEntity>> response) {
                refreshLoadMoreHelper.loadSuccess(response);
            }

            @Override
            public void onFailure(int code, String msg) {
                super.onFailure(code, msg);
                refreshLoadMoreHelper.loadError();
            }

            @Override
            public void onError(Throwable throwable) {
                super.onError(throwable);
                refreshLoadMoreHelper.loadError();
            }
        });


    }


    @Override
    public void onItemClick(BaseQuickAdapter adapter, View view, int position) {
        ArticleEntity item = refreshLoadMoreHelper.getItem(position);
        Log.i(Constants.TAG, "item is " + item);
    }
}
