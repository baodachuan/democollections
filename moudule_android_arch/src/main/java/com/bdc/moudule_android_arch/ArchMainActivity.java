package com.bdc.moudule_android_arch;

import android.os.AsyncTask;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.room.Room;

import com.alibaba.android.arouter.launcher.ARouter;
import com.bdc.lib_common.Constants;
import com.bdc.lib_common.data.LiveDataBus;
import com.bdc.moudule_android_arch.DataBase.StudentDao;
import com.bdc.moudule_android_arch.DataBase.StudentDataBase;
import com.bdc.moudule_android_arch.bean.Student;

import java.util.List;

public class ArchMainActivity extends AppCompatActivity {
    private UserInfoViewModel userInfoViewModel;
    private TextView mTextView;
    StudentDataBase dataBase;
    StudentDao dao;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.arch_main);
         dataBase =
                Room.databaseBuilder(ArchMainActivity.this, StudentDataBase.class, "roomTest.db").build();

         dao=dataBase.getStudentDao();
        mTextView = findViewById(R.id.arch_text);
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

        LiveDataBus.getInstance().with("livedata", User.class)
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

    public void rootest(View view) {
        new AsyncTask<Void,Void,Void>(){
            @Override
            protected void onPostExecute(Void aVoid) {
                super.onPostExecute(aVoid);
                Toast.makeText(ArchMainActivity.this, "set ok", Toast.LENGTH_SHORT).show();
            }

            @Override
            protected Void doInBackground(Void... voids) {
                StudentDataBase dataBase =
                        Room.databaseBuilder(ArchMainActivity.this, StudentDataBase.class, "roomTest.db").build();

                StudentDao dao=dataBase.getStudentDao();
                Student student1=new Student(1,"zhang","san",1);
                Student student2=new Student(2,"li","si",1);
                dao.insertAll(student1,student2);
                return null;

            }
        }.execute();


    }

    public void roomcheck(View view) {
        new Thread(new Runnable() {
            @Override
            public void run() {
                List<Student> students = dao.getAll();
                Log.e(Constants.TAG,"student is " +students.toString());
            }
        }).start();
    }
}
