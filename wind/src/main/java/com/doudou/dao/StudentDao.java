package com.doudou.dao;

import com.doudou.model.StudentRepo;

import java.util.List;

/**
 * Created by chenjiaming on 2017/7/16.
 */
public interface StudentDao {

    void insertStudent(StudentRepo repo);
    List<StudentRepo> getAllStudents();

}