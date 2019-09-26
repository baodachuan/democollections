package com.bdc.module_rss;

import android.app.Application;

import com.alibaba.android.arouter.launcher.ARouter;
import com.bdc.lib_common.utils.AppUtils;

public class App_Rss extends Application {
    @Override
    public void onCreate() {
        super.onCreate();
        ARouter.openDebug();
        ARouter.openLog();
        ARouter.init(this);
        AppUtils.initApp(this);
//        Debugger.initialize(this);
    }
}
