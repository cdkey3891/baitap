package com.company.anhkv;

import com.company.anhkv.service.ClazzService;
import com.company.anhkv.service.StudentService;

public class MainApp {
    public static void main(String[] args) {
        ClazzService clazzService = new ClazzService();
        clazzService.addClazz();
        clazzService.addClazz();
        clazzService.showAllClass();
        StudentService studentService = new StudentService();
        studentService.setClazzService(clazzService);
        studentService.addStudent();
        studentService.addStudent();
        clazzService.showStudentOfClazz(1);
        clazzService.showAllClass();
        studentService.showAllStudents();
    }
}
