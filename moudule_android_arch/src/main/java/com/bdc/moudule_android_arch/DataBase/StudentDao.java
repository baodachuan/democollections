package com.bdc.moudule_android_arch.DataBase;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;
import androidx.room.Update;

import com.bdc.moudule_android_arch.bean.Student;

import java.util.List;

@Dao
public interface StudentDao {
    @Query("select * from Student")
    List<Student> getAll();

    @Query("select * from Student where id in (:studentIds)")
    List<Student> loadAllByIds(int[] studentIds);

    @Query("select * from Student where first_name like :first and last_name like :last limit 1")
    Student findByName(String first,String last);

    @Query("select id,first_name,last_name from Student where id = :id")
    Student getStudentInfoById(int id);

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    long[] insertAll(Student ...students);

    @Update
    void update(Student... students);

    @Delete
    void delete(Student student);
}
