package com.doudou.service;

import com.doudou.model.student.StudentDto;

import java.util.List;

/**
 * Created by chenjiaming on 2017/7/16.
 */
public interface StudentService {

    void insertStudent(StudentDto studentDto);
    List<StudentDto> getAllStudents();

}