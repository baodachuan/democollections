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
import com.bdc.moudule_android_arch.bean.ArticleEntity;
import com.bdc.moudule_android_arch.bean.PageList;
import com.bdc.moudule_android_arch.bean.Response;
import com.bdc.moudule_android_arch.net.ApiObserver;
import com.bdc.moudule_android_arch.repos.ArticlesRepo;

import java.util.List;


/**
 * Created by arvinljw on 2018/11/16 14:41
 * Function：
 * Desc：
 */
public class HomeFragment extends Fragment {
    private static final String ARG_PAGE="arg_page";
    private View headerView;

    protected View root;

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

        loadData();

    }



    public void loadData() {

        ArticlesRepo.getIndexArticles(1).observe(this, new ApiObserver<PageList<ArticleEntity>>() {
            @Override
            public void onSuccess(Response<PageList<ArticleEntity>> response) {
                PageList<ArticleEntity> data = response.getData();
                List<ArticleEntity> data1 = data.getData();
                Log.i(Constants.TAG,"data1 is "+data1);

            }
        });





    }




}
