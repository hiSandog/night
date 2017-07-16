package com.doudou.controller;

import com.doudou.core.SnowException;
import com.doudou.model.CommonResponse;
import com.doudou.model.Teacher;
import com.doudou.model.TeacherVo;
import com.doudou.service.HelloWorldServiceImpl;
import com.doudou.service.TeacherServiceImpl;
import com.doudou.util.Convert;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Created by chenjiaming on 2017/7/9.
 */
@RestController
@RequestMapping("/teacher")
public class TeacherController {

    @Autowired
    private TeacherServiceImpl teacherService;

    @RequestMapping("/get_all")
    public ResponseEntity<CommonResponse> getAll() throws SnowException {
        List<Teacher> teachers = teacherService.getAllTeachers();
        List<TeacherVo> result = new ArrayList<>(teachers.size());
        for (Teacher teacher : teachers) {
            result.add(Convert.convertTeacher(teacher));
        }
        return new ResponseEntity<>(new CommonResponse(result), HttpStatus.OK);
    }

    @RequestMapping("/insert")
    public ResponseEntity<CommonResponse> insert(TeacherVo teacherVo) throws SnowException {
        teacherService.insertTeacher(Convert.convertTeacher(teacherVo));
        return new ResponseEntity<>(new CommonResponse(true), HttpStatus.OK);
    }

}