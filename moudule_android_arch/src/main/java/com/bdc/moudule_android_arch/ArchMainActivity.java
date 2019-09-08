package com.bdc.moudule_android_arch;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;

import com.alibaba.android.arouter.launcher.ARouter;
import com.bdc.lib_common.Constants;
import com.bdc.lib_common.data.LiveDataBus;

public class ArchMainActivity extends AppCompatActivity {
    private  UserInfoViewModel userInfoViewModel;
    private TextView mTextView;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.arch_main);


        mTextView=findViewById(R.id.arch_text);
//         userInfoViewModel =
//                ViewModelProviders.of(this).get(UserInfoViewModel.class);
//        userInfoViewModel.init("001");
//
//        userInfoViewModel.getUserData().observe(this, new Observer<User>() {
//            @Override
//            public void onChanged(User user) {
//                Log.e(Constants.TAG,"observe user onchange");
//                mTextView.setText(user.name);
//            }
//        });

        LiveDataBus.getInstance().with("livedata",User.class)
                .observe(this, new Observer<User>() {
                    @Override
                    public void onChanged(User o) {
                        mTextView.setText(o.name);
                    }
                });
    }

    public void change(View view) {
//        User user=new User("zhanghan ",1);
//        userInfoViewModel.getUserData().setValue(user);
        ARouter.getInstance().build(Constants.MODULE_ARCH_SUB).navigation();
    }
}
