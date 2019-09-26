package com.bdc.lib_common.utils;

import android.app.Application;

public class AppUtils {
    public static Application APP;

    public static Application getApplication() {
        return APP;
    }

    public static void initApp(Application app) {
        APP = app;
    }


}
