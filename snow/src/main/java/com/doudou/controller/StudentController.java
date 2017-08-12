package com.doudou.controller;

import com.doudou.core.SnowException;
import com.doudou.model.CommonResponse;
import com.doudou.model.StudentVo;
import com.doudou.model.student.StudentDto;
import com.doudou.service.StudentServiceImpl;
import com.doudou.util.Convert;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by chenjiaming on 2017/7/9.
 */
@RestController
@RequestMapping("/student")
public class StudentController {

    @Autowired
    private StudentServiceImpl studentService;

    @RequestMapping("/get_all")
    public ResponseEntity<CommonResponse> getAll() throws SnowException {
        List<StudentDto> list = studentService.getAllStudents();
        List<StudentVo> result = new ArrayList<>(list.size());
        for (StudentDto student : list) {
            result.add(Convert.convertStudent(student));
        }
        return new ResponseEntity<>(new CommonResponse(list), HttpStatus.OK);
    }

    @RequestMapping("/insert")
    public ResponseEntity<CommonResponse> insert (StudentVo studentVo) throws SnowException {
        studentService.insertStudent(Convert.convertStudent(studentVo));
        return new ResponseEntity<>(new CommonResponse(true), HttpStatus.OK);
    }

}