package com.bdc.moudule_android_arch.DataBase;

import androidx.room.Database;
import androidx.room.RoomDatabase;

import com.bdc.moudule_android_arch.bean.Student;

@Database(entities = {Student.class},version = 1)
public abstract class StudentDataBase extends RoomDatabase {
    public static final String DATABASE_NAME="rooTest_db";

    public abstract StudentDao getStudentDao();
}
