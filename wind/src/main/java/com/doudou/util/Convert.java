package com.doudou.util;

import com.doudou.model.*;

/**
 * Created by chenjiaming on 2017/7/16.
 */
public class Convert {

    public static StudentRepo convertStudent(Student student) {
        StudentRepo studentRepo = new StudentRepo();
        studentRepo.setName(student.getName());
        studentRepo.setRemark(student.getRemark());
        studentRepo.setSex(student.getSex());
        convertBase(studentRepo, student, false);
        return studentRepo;
    }

    public static Student convertStudent(StudentRepo studentRepo) {
        Student student = new Student();
        student.setName(studentRepo.getName());
        student.setRemark(studentRepo.getRemark());
        student.setSex(studentRepo.getSex());
        convertBase(studentRepo, student, true);
        return student;
    }

    public static TeacherRepo convertTeacher(Teacher teacher) {
        TeacherRepo repo = new TeacherRepo();
        repo.setLine1(teacher.getLine1());
        repo.setLine2(teacher.getLine2());
        repo.setLine3(teacher.getLine3());
        repo.setLine4(teacher.getLine4());
        repo.setName(teacher.getName());
        repo.setId(teacher.getId());
        convertMongoBase(repo, teacher, false);
        return repo;
    }

    public static Teacher convertTeacher(TeacherRepo repo) {
        Teacher teacher = new Teacher();
        teacher.setLine1(repo.getLine1());
        teacher.setLine2(repo.getLine2());
        teacher.setLine3(repo.getLine3());
        teacher.setLine4(repo.getLine4());
        teacher.setName(repo.getName());
        teacher.setId(repo.getId());
        convertMongoBase(repo, teacher, true);
        return teacher;
    }

    private static void convertBase(BaseModel repo, BaseModel ser, boolean repoToSer) {
        if (repoToSer) {
            ser.setId(repo.getId());
            ser.setGmtModified(repo.getGmtModified());
            ser.setGmtCreate(repo.getGmtCreate());
        } else {
            repo.setId(ser.getId());
            repo.setGmtModified(ser.getGmtModified());
            repo.setGmtCreate(ser.getGmtCreate());
        }
    }

    private static void convertMongoBase (BaseMongoRepo repo, BaseMongoModel ser, boolean repoToSer) {
        if (repoToSer) {
            ser.setGmtModified(repo.getGmtModified());
            ser.setGmtCreate(repo.getGmtCreate());
        } else {
            repo.setGmtModified(ser.getGmtModified());
            repo.setGmtCreate(ser.getGmtCreate());
        }
    }

}