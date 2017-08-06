package com.doudou.service;

import com.alibaba.dubbo.config.annotation.Reference;
import com.doudou.model.Student;
import com.doudou.util.CommonContast;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * Created by chenjiaming on 2017/7/16.
 */
@Component
public class StudentServiceImpl implements StudentService {

    @Reference(version = CommonContast.SERVICE_VERSION)
    private StudentService studentService;


    @Override
    public void insertStudent(Student student) {
        studentService.insertStudent(student);
    }

    @Override
    public List<Student> getAllStudents() {
        return studentService.getAllStudents();
    }

}