package com.doudou.service;

import com.alibaba.dubbo.config.annotation.Service;
import com.doudou.dao.StudentDao;
import com.doudou.model.Student;
import com.doudou.model.StudentRepo;
import com.doudou.util.CommonContast;
import com.doudou.util.Convert;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Created by chenjiaming on 2017/7/16.
 */
@Service(version = CommonContast.SERVICE_VERSION)
public class StudentServiceImpl implements StudentService {

    @Autowired
    private StudentDao studentDao;

    @Override
    public void insertStudent(Student student) {
        Date date = new Date();
        student.setGmtCreate(date);
        student.setGmtModified(date);
        studentDao.insertStudent(Convert.convertStudent(student));
    }

    @Override
    public List<Student> getAllStudents() {
        List<StudentRepo> repoList = studentDao.getAllStudents();
        List<Student> result = new ArrayList<>(repoList.size());
        for (StudentRepo repo : repoList) {
            result.add(Convert.convertStudent(repo));
        }
        return result;
    }

}