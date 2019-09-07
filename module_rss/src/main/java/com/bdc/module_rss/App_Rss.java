package com.bdc.module_rss;

import android.app.Application;

import com.alibaba.android.arouter.launcher.ARouter;

public class App_Rss extends Application {
    @Override
    public void onCreate() {
        super.onCreate();
        ARouter.openDebug();
        ARouter.openLog();
        ARouter.init(this);
    }
}
