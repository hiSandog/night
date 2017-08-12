package com.doudou.service;

import com.alibaba.dubbo.config.annotation.Reference;
import com.doudou.model.student.StudentDto;
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
    public void insertStudent(StudentDto student) {
        studentService.insertStudent(student);
    }

    @Override
    public List<StudentDto> getAllStudents() {
        return studentService.getAllStudents();
    }

}