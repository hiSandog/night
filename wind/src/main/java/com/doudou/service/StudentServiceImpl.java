package com.doudou.service;

import com.alibaba.dubbo.config.annotation.Service;
import com.doudou.model.student.StudentDto;
import com.doudou.mybatis.bean.StudentDo;
import com.doudou.mybatis.bean.StudentDoExample;
import com.doudou.mybatis.persistence.StudentDoMapper;
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
    private StudentDoMapper studentDoMapper;

    @Override
    public void insertStudent(StudentDto studentDto) {
        Date date = new Date();
        studentDto.setGmtCreate(date);
        studentDto.setGmtModified(date);
        studentDoMapper.insert(Convert.convertStudent(studentDto));
    }

    @Override
    public List<StudentDto> getAllStudents() {
        StudentDoExample doExample = new StudentDoExample();
        StudentDoExample.Criteria criteria = doExample.createCriteria();
        criteria.andIdIsNotNull();
        List<StudentDo> repoList = studentDoMapper.selectByExample(doExample);
        List<StudentDto> result = new ArrayList<>(repoList.size());
        for (StudentDo studentDo : repoList) {
            result.add(Convert.convertStudent(studentDo));
        }
        return result;
    }

}