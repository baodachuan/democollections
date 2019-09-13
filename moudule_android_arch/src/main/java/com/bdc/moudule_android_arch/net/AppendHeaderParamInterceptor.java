package com.bdc.moudule_android_arch.net;


import android.util.Log;

import androidx.annotation.NonNull;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import okhttp3.Headers;
import okhttp3.Interceptor;
import okhttp3.Request;
import okhttp3.Response;

/**
 * Created by arvinljw on 2018/10/31 14:21
 * Function：
 * Desc：
 */
public class AppendHeaderParamInterceptor implements Interceptor {

    private Map<String, String> headers;

    public AppendHeaderParamInterceptor() {
        headers = new HashMap<>();
    }

    public void addHeader(String key, String value) {
        headers.put(key, value);
    }

    public void addHeaders(Map<String, String> headers) {
        this.headers.putAll(headers);
    }

    @Override
    public Response intercept(@NonNull Chain chain) throws IOException {
        Request request = chain.request();
        Headers.Builder headerBuilder = request
                .headers()
                .newBuilder();
        for (String key : headers.keySet()) {
            String value = headers.get(key);
            if (value == null) {
                value = "";
            }
            headerBuilder.add(key, value);
        }

        Request newRequest = request.newBuilder()
                .headers(headerBuilder.build())
                .build();

        Log.d("NetRequest", newRequest.method() + " " + newRequest.url().toString());

        return chain.proceed(newRequest);
    }
}
