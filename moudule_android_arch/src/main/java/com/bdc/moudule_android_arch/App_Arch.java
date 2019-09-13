package com.bdc.moudule_android_arch;

import android.app.Application;

import androidx.room.Room;

import com.alibaba.android.arouter.launcher.ARouter;
import com.bdc.moudule_android_arch.dataBase.ArticleDatabase;

public class App_Arch extends Application {
    private static App_Arch app;
    private ArticleDatabase db;
    @Override
    public void onCreate() {
        super.onCreate();
        ARouter.openDebug();
        ARouter.openLog();
        ARouter.init(this);
        app = this;
//        Stetho.initializeWithDefaults(this);
        db = Room.databaseBuilder(this, ArticleDatabase.class, "wanandroid").build();
    }

    public static App_Arch getApp() {
        return app;
    }

    public ArticleDatabase getDB() {
        return db;
    }


}
