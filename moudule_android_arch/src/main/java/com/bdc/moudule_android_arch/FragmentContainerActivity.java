package com.bdc.moudule_android_arch;

import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import com.alibaba.android.arouter.facade.annotation.Route;
import com.bdc.lib_common.Constants;
import com.bdc.moudule_android_arch.ui.HomeFragment;

@Route(path = Constants.MODULE_ARCH_FRAGMENT_CONTAINER)
public class FragmentContainerActivity extends AppCompatActivity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.arch_fragment_container);

        FragmentManager manager=getSupportFragmentManager();
        HomeFragment homeFragment=new HomeFragment();
        FragmentTransaction ft = manager.beginTransaction();
        ft.replace(R.id.fagment_container,homeFragment);
        ft.commit();



    }
}
