package com.doudou.service;

import com.alibaba.dubbo.config.annotation.Service;
import com.doudou.model.Teacher;
import com.doudou.model.TeacherRepo;
import com.doudou.util.Convert;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by chenjiaming on 2017/7/16.
 */
@Service(version = "1.0.0")
public class TeacherServiceImpl implements TeacherService {

    @Autowired
    private MongoTemplate mongoTemplate;

    @Override
    public void insertTeacher(Teacher teacher) {
        mongoTemplate.insert(Convert.convertTeacher(teacher));
    }

    @Override
    public List<Teacher> getAllTeachers() {
        List<TeacherRepo> items = mongoTemplate.find(null, TeacherRepo.class);
        List<Teacher> result = new ArrayList<>(items.size());
        for (TeacherRepo repo : items) {
            result.add(Convert.convertTeacher(repo));
        }
        return result;
    }

}