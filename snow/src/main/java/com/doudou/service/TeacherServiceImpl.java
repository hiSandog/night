package com.doudou.service;

import com.alibaba.dubbo.config.annotation.Reference;
import com.doudou.model.Teacher;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * Created by chenjiaming on 2017/7/16.
 */
@Component
public class TeacherServiceImpl implements TeacherService {

    @Reference(version = "1.0.0")
    public TeacherService teacherService;

    @Override
    public void insertTeacher(Teacher teacher) {
        teacherService.insertTeacher(teacher);
    }

    @Override
    public List<Teacher> getAllTeachers() {
        return teacherService.getAllTeachers();
    }

}