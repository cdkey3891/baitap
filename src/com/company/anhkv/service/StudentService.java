package com.company.anhkv.service;

import com.company.anhkv.Clazz;
import com.company.anhkv.Student;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Scanner;

public class StudentService {
    //them
    //sua
    //xóa
    ClazzService clazzService;
    public void setClazzService(ClazzService clazzService) {
        this.clazzService = clazzService;
    }
    List<Student> allStudentList = new ArrayList<>();
    Scanner scanner = new Scanner(System.in);
    public void addStudent() {
        Student tmp = new Student();
        int id = (allStudentList.size() > 0) ? (allStudentList.size() + 1) : 1;
        tmp.setStudentId(id);
        tmp.setName(inputName());
        tmp.setDateOfBirth(inputDateOfBirth());
        tmp.setClazz(selectClazz());
        tmp.getClazz().studentList.add(tmp);
    }

    private Clazz selectClazz() {
        System.out.print("Input Clazz ID: ");
        int tmp = scanner.nextInt();
        return clazzService.clazzList.get(tmp-1);
    }

    private String inputName() {
        System.out.print("Input Student's name: ");
        return scanner.next();
    }
    private Date inputDateOfBirth() {
        System.out.print("Input Student's birthday");
        Date tmp = new Date();
        return tmp;
    }
    public void showAllStudents() {
        allStudentList.forEach(x -> System.out.println(x.toString()));
    }


}
