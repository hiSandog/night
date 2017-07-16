package com.doudou.service;

import com.doudou.model.Student;

import java.util.List;

/**
 * Created by chenjiaming on 2017/7/16.
 */
public interface StudentService {

    void insertStudent(Student student);
    List<Student> getAllStudents();

}