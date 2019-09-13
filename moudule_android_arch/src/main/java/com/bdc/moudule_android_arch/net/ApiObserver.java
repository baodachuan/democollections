package com.bdc.moudule_android_arch.net;

import android.util.Log;

import com.bdc.moudule_android_arch.bean.Response;


/**
 * Created by arvinljw on 2018/10/31 17:13
 * Function：
 * Desc：
 */
public abstract class ApiObserver<R> extends BaseObserver<Response<R>> {
    private static final String TAG = "Request";

    @Override
    public void callback(Response<R> response) {
        if (response.isSuccess()) {
            onSuccess(response);
        } else {
            onFailure(response.getErrorCode(), response.getErrorMsg());
        }
    }

    public void onFailure(int code, String msg) {
        Log.d(TAG, "code:" + code + "->msg:" + msg);
    }

    public abstract void onSuccess(Response<R> response);
}
