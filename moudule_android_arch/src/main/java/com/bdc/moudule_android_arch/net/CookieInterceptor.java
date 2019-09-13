package com.bdc.moudule_android_arch.net;

import androidx.annotation.NonNull;

import java.io.IOException;

import okhttp3.Interceptor;
import okhttp3.Request;
import okhttp3.Response;

/**
 * Created by arvinljw on 2018/11/30 14:26
 * Function：
 * Desc：
 */
class CookieInterceptor implements Interceptor {
    @Override
    public Response intercept(@NonNull Chain chain) throws IOException {
        Request.Builder builder = chain.request().newBuilder();
//        LoginResultEntity user = SharePreferenceUtil.getUser();
//        if (user != null) {
//            builder.addHeader("Cookie", "loginUserName=" + user.getUsername());
//            builder.addHeader("Cookie", "loginUserPassword=" + user.getPassword());
//        }
        return chain.proceed(builder.build());
//        return null;
    }
}
