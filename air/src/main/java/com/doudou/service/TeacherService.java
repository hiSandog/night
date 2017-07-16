package com.doudou.service;

import com.doudou.model.Teacher;

import java.util.List;

/**
 * Created by chenjiaming on 2017/7/16.
 */
public interface TeacherService {

    void insertTeacher(Teacher teacher);
    List<Teacher> getAllTeachers();

}