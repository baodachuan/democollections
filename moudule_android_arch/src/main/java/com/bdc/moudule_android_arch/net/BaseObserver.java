package com.bdc.moudule_android_arch.net;


import androidx.annotation.Nullable;
import androidx.lifecycle.Observer;

import com.bdc.lib_common.utils.ALog;
import com.github.leonardoxh.livedatacalladapter.Resource;


/**
 * Created by arvinljw on 2018/10/31 17:13
 * Function：
 * Desc：
 */
public abstract class BaseObserver<R> implements Observer<Resource<R>> {

    @Override
    public void onChanged(@Nullable Resource<R> resource) {
        if (resource != null) {
            R data = resource.getResource();
            ALog.json("NetRequest", data);
            if (data != null) {
                callback(data);
            } else {
                if (resource.getError() != null) {
                    onError(resource.getError());
                }
            }
        }
    }

    public void onError(Throwable throwable) {
    }

    public abstract void callback(R response);
}
