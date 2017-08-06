package com.doudou.service;

import com.alibaba.dubbo.config.annotation.Reference;
import com.doudou.model.Teacher;
import com.doudou.util.CommonContast;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * Created by chenjiaming on 2017/7/16.
 */
@Component
public class TeacherServiceImpl implements TeacherService {

    @Reference(version = CommonContast.SERVICE_VERSION)
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