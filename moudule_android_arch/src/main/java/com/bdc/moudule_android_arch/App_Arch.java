package com.bdc.moudule_android_arch;

import android.app.Application;

import com.alibaba.android.arouter.launcher.ARouter;

public class App_Arch extends Application {
    @Override
    public void onCreate() {
        super.onCreate();
        ARouter.openDebug();
        ARouter.openLog();
        ARouter.init(this);
    }
}
