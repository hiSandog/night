package com.doudou.controller;

import com.doudou.core.SnowException;
import com.doudou.model.CommonResponse;
import com.doudou.model.TeacherVo;
import com.doudou.model.request.TeacherInsertRequest;
import com.doudou.model.teacher.TeacherDto;
import com.doudou.service.TeacherServiceImpl;
import com.doudou.util.Convert;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by chenjiaming on 2017/7/9.
 */
@RestController
@RequestMapping("/teacher")
public class TeacherController {

    @Autowired
    private TeacherServiceImpl teacherService;

    @ApiOperation("获取所有老师数据的接口")
    @RequestMapping(value = "/get_all", method = RequestMethod.GET)
    public ResponseEntity<CommonResponse> getAll() throws SnowException {
        List<TeacherDto> teachers = teacherService.getAllTeachers();
        List<TeacherVo> result = new ArrayList<>(teachers.size());
        for (TeacherDto teacher : teachers) {
            result.add(Convert.convertTeacher(teacher));
        }
        return new ResponseEntity<>(new CommonResponse(result), HttpStatus.OK);
    }

    @ApiOperation("插入一条老师数据")
    @ApiImplicitParams({
            @ApiImplicitParam(name="insertRequest",
                    value="路小佳,仿佛兮如轻云之蔽月,飘摇兮如流风之回雪,执子之手,与子偕老",
                    dataType = "TeacherInsertRequest")
    })
    @RequestMapping(value = "/insert", method = RequestMethod.POST)
    public ResponseEntity<CommonResponse> insert(@RequestBody TeacherInsertRequest insertRequest) throws SnowException {
        teacherService.insertTeacher(Convert.convertTeacher(insertRequest.getTeacher()));
        return new ResponseEntity<>(new CommonResponse(true), HttpStatus.OK);
    }

}