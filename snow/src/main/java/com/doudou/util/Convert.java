package com.doudou.util;

import com.doudou.model.*;
import com.doudou.model.student.StudentDto;
import com.doudou.model.student.UserDto;
import com.doudou.model.teacher.TeacherDto;
import org.springframework.beans.BeanUtils;

/**
 * Created by chenjiaming on 2017/7/16.
 */
public class Convert {

    public static StudentVo convertStudent(StudentDto student) {
        StudentVo studentVo = new StudentVo();
        studentVo.setName(student.getName());
        studentVo.setRemark(student.getRemark());
        studentVo.setSex(student.getSex());
        convertBase(studentVo, student, false);
        return studentVo;
    }

    public static StudentDto convertStudent(StudentVo studentVo) {
        StudentDto student = new StudentDto();
        student.setName(studentVo.getName());
        student.setRemark(studentVo.getRemark());
        student.setSex(studentVo.getSex());
        convertBase(studentVo, student, true);
        return student;
    }

    public static TeacherVo convertTeacher(TeacherDto teacher) {
        TeacherVo Vo = new TeacherVo();
        Vo.setLine1(teacher.getLine1());
        Vo.setLine2(teacher.getLine2());
        Vo.setLine3(teacher.getLine3());
        Vo.setLine4(teacher.getLine4());
        Vo.setName(teacher.getName());
        convertMongoBase(Vo, teacher, false);
        return Vo;
    }

    public static TeacherDto convertTeacher(TeacherVo Vo) {
        TeacherDto teacher = new TeacherDto();
        teacher.setLine1(Vo.getLine1());
        teacher.setLine2(Vo.getLine2());
        teacher.setLine3(Vo.getLine3());
        teacher.setLine4(Vo.getLine4());
        teacher.setName(Vo.getName());
        convertMongoBase(Vo, teacher, true);
        return teacher;
    }

    private static void convertBase(BaseDto Vo, BaseDto ser, boolean VoToSer) {
        if (VoToSer) {
            ser.setId(Vo.getId());
            ser.setGmtModified(Vo.getGmtModified());
            ser.setGmtCreate(Vo.getGmtCreate());
        } else {
            Vo.setId(ser.getId());
            Vo.setGmtModified(ser.getGmtModified());
            Vo.setGmtCreate(ser.getGmtCreate());
        }
    }

    private static void convertMongoBase(BaseMongoDto Vo, BaseMongoDto ser, boolean VoToSer) {
        if (VoToSer) {
            ser.setId(Vo.getId());
            ser.setGmtModified(Vo.getGmtModified());
            ser.setGmtCreate(Vo.getGmtCreate());
        } else {
            Vo.setId(ser.getId());
            Vo.setGmtModified(ser.getGmtModified());
            Vo.setGmtCreate(ser.getGmtCreate());
        }
    }

    public static UserDto convertUser(UserVo userVo) {
        UserDto userDto = new UserDto();
        try {
            BeanUtils.copyProperties(userVo, userDto);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return userDto;
    }

    public static UserVo convertUser(UserDto userDto) {
        UserVo userVo = new UserVo();
        try {
            BeanUtils.copyProperties(userDto, userVo);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return userVo;
    }

}