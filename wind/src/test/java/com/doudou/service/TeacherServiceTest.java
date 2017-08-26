package com.doudou.service;

import com.doudou.model.teacher.TeacherDto;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;

/**
 * Created by chenjiaming on 2017/8/26.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
public class TeacherServiceTest {

    @Autowired
    private TeacherService teacherService;

    @Test
    public void insertTeacher(){
        TeacherDto teacherDto = new TeacherDto();
        teacherDto.setName("聂风");
        teacherDto.setLine1("老子吃火锅");
        teacherDto.setLine2("你吃火锅底料");
        teacherDto.setLine3("仿佛兮如轻云之蔽月");
        teacherDto.setLine4("飘摇兮如流风之回雪");
        teacherService.insertTeacher(teacherDto);
    }

    @Test
    public void getAllTeachers(){
        List<TeacherDto> teacherDtos = teacherService.getAllTeachers();
        for (TeacherDto teacherDto : teacherDtos) {
            System.out.println(teacherDto.getId());
            System.out.println(teacherDto.getName());
            System.out.println(teacherDto.getLine1());
            System.out.println(teacherDto.getLine2());
            System.out.println(teacherDto.getLine3());
            System.out.println(teacherDto.getLine4());
        }
    }

}