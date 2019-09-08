package com.bdc.moudule_android_arch;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class UserInfoViewModel extends ViewModel {
    private String userId;
    private MutableLiveData<User> data;

    public void init(String userId){
        this.userId=userId;
    }

    public MutableLiveData<User> getUserData(){
        if(data==null){
            data=new MutableLiveData<>();
        }
        return data;
    }



}
