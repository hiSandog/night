package com.doudou.service;

import com.doudou.model.teacher.TeacherDto;

import java.util.List;

/**
 * Created by chenjiaming on 2017/7/16.
 */
public interface TeacherService {

    void insertTeacher(TeacherDto teacherDto);
    List<TeacherDto> getAllTeachers();

}