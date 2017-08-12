package com.doudou.util;

import com.doudou.model.*;
import com.doudou.model.student.StudentDto;
import com.doudou.model.teacher.TeacherDto;
import com.doudou.mongo.BaseMongoDo;
import com.doudou.mongo.TeacherDo;
import com.doudou.mybatis.bean.StudentDo;

/**
 * Created by chenjiaming on 2017/7/16.
 */
public class Convert {

    public static StudentDo convertStudent(StudentDto student) {
        StudentDo studentDo = new StudentDo();
        studentDo.setName(student.getName());
        studentDo.setRemark(student.getRemark());
        studentDo.setSex(student.getSex());
        studentDo.setId(student.getId());
        studentDo.setGmtCreate(student.getGmtCreate());
        studentDo.setGmtModified(student.getGmtModified());
        return studentDo;
    }

    public static StudentDto convertStudent(StudentDo studentDo) {
        StudentDto studentDto = new StudentDto();
        studentDto.setName(studentDo.getName());
        studentDto.setRemark(studentDo.getRemark());
        studentDto.setSex(studentDo.getSex());
        studentDto.setId(studentDo.getId());
        studentDto.setGmtCreate(studentDo.getGmtCreate());
        studentDto.setGmtModified(studentDo.getGmtModified());
        return studentDto;
    }

    public static TeacherDo convertTeacher(TeacherDto teacher) {
        TeacherDo repo = new TeacherDo();
        repo.setLine1(teacher.getLine1());
        repo.setLine2(teacher.getLine2());
        repo.setLine3(teacher.getLine3());
        repo.setLine4(teacher.getLine4());
        repo.setName(teacher.getName());
        repo.setId(teacher.getId());
        convertMongoBase(repo, teacher, false);
        return repo;
    }

    public static TeacherDto convertTeacher(TeacherDo repo) {
        TeacherDto teacher = new TeacherDto();
        teacher.setLine1(repo.getLine1());
        teacher.setLine2(repo.getLine2());
        teacher.setLine3(repo.getLine3());
        teacher.setLine4(repo.getLine4());
        teacher.setName(repo.getName());
        teacher.setId(repo.getId());
        convertMongoBase(repo, teacher, true);
        return teacher;
    }

    private static void convertMongoBase (BaseMongoDo repo, BaseMongoDto ser, boolean repoToSer) {
        if (repoToSer) {
            ser.setGmtModified(repo.getGmtModified());
            ser.setGmtCreate(repo.getGmtCreate());
        } else {
            repo.setGmtModified(ser.getGmtModified());
            repo.setGmtCreate(ser.getGmtCreate());
        }
    }

}