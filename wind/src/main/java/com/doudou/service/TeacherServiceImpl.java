package com.doudou.service;

import com.alibaba.dubbo.config.annotation.Service;
import com.doudou.model.teacher.TeacherDto;
import com.doudou.mongo.TeacherDo;
import com.doudou.util.CommonContast;
import com.doudou.util.Convert;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Created by chenjiaming on 2017/7/16.
 */
@Service(version = CommonContast.SERVICE_VERSION)
public class TeacherServiceImpl implements TeacherService {

    @Autowired
    private MongoTemplate mongoTemplate;

    @Override
    public void insertTeacher(TeacherDto teacherDto) {
        Date date = new Date();
        teacherDto.setGmtCreate(date);
        teacherDto.setGmtModified(date);
        mongoTemplate.insert(Convert.convertTeacher(teacherDto));
    }

    @Override
    public List<TeacherDto> getAllTeachers() {
        List<TeacherDo> items = mongoTemplate.find(null, TeacherDo.class);
        List<TeacherDto> result = new ArrayList<>(items.size());
        for (TeacherDo teacherDo : items) {
            result.add(Convert.convertTeacher(teacherDo));
        }
        return result;
    }

}