package com.bdc.module_rss;

import android.os.Bundle;
import android.util.SparseArray;
import android.view.MenuItem;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import com.bdc.lib_common.base.BaseFragment;
import com.bdc.module_rss.ui.DiscoverFragment;
import com.bdc.module_rss.ui.MainFragment;
import com.bdc.module_rss.ui.MineFragment;
import com.google.android.material.bottomnavigation.BottomNavigationView;

import java.util.Arrays;
import java.util.List;

public class RssSubscribeActivity extends AppCompatActivity implements BottomNavigationView.OnNavigationItemSelectedListener {
    private BottomNavigationView navigationView;
    private SparseArray<BaseFragment> fragments = new SparseArray<>();
    private List<Integer> tabIds = Arrays.asList(R.id.tab_subscribe, R.id.tab_discovery, R.id.tab_mine);
    private SparseArray<Class<? extends BaseFragment>> fragmentClasses = new SparseArray<>();
    private FragmentManager fm;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.rss_subscribe);

        initFragments();
        fm = getSupportFragmentManager();
        initBottom();
        switchFragments(R.id.tab_subscribe);
    }


    private void initFragments() {
        fragmentClasses.put(R.id.tab_subscribe, MainFragment.class);
        fragmentClasses.put(R.id.tab_discovery, DiscoverFragment.class);
        fragmentClasses.put(R.id.tab_mine, MineFragment.class);

    }

    private void initBottom() {
        navigationView = findViewById(R.id.bottom_navi);
        navigationView.setOnNavigationItemSelectedListener(this);
        navigationView.setSelectedItemId(tabIds.get(0));
    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
        int itemId = item.getItemId();
        switchFragments(itemId);
        return true;
    }

    private void switchFragments(int itemId) {
        BaseFragment baseFragment = fragments.get(itemId);
        if (baseFragment == null) {
            try {
                baseFragment = fragmentClasses.get(itemId).newInstance();
                fragments.put(itemId, baseFragment);
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            } catch (InstantiationException e) {
                e.printStackTrace();
            }
        }
        FragmentTransaction ft = fm.beginTransaction();
        ft.replace(R.id.frgment_container, baseFragment);
        ft.commit();
    }
}
