package com.bdc.moudule_android_arch;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;

import com.alibaba.android.arouter.facade.annotation.Route;
import com.bdc.lib_common.Constants;
import com.bdc.lib_common.data.LiveDataBus;

@Route(path= Constants.MODULE_ARCH_SUB)
public class ArcSubActivity extends AppCompatActivity {
    TextView textView;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.arch_sub);
        textView = findViewById(R.id.sub_text);
        LiveDataBus.getInstance().with("livedata", User.class)
                .observe(this, new Observer<User>() {
                    @Override
                    public void onChanged(User o) {
                        textView.setText(o.name);
                    }
                });

    }

    public void arc_send(View view) {
        User user = new User("wangwu", 2);
        LiveDataBus.getInstance().with("livedata").setValue(user);
    }
}
