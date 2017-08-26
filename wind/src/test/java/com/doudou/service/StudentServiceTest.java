package com.doudou.service;

import com.doudou.model.student.StudentDto;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by chenjiaming on 2017/8/26.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
public class StudentServiceTest {

    @Autowired
    private StudentService studentService;

    @Test
    public void getAllStudents() {
        List<StudentDto> studentDtos = studentService.getAllStudents();
        for (StudentDto studentDto : studentDtos) {
            System.out.println(studentDto.getName());
            System.out.println(studentDto.getRemark());
            System.out.println(studentDto.getSex());
        }
    }

    @Test
    public void insertStudent() {
        StudentDto studentDto = new StudentDto();
        studentDto.setName("天龙八部");
        studentDto.setRemark("金庸写的最好的");
        studentDto.setSex(1);
        studentService.insertStudent(studentDto);
    }

}