package com.bdc.appcollections;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import com.alibaba.android.arouter.facade.annotation.Route;
import com.alibaba.android.arouter.launcher.ARouter;
import com.bdc.lib_common.Constants;

@Route(path = Constants.MODULE_APP_MAIN)
public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void toRss(View view) {
        ARouter.getInstance().build(Constants.MODULE_RSS_MAIN).navigation();
    }
}
