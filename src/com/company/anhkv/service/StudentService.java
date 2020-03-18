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
    private static Scanner studentScanner = new Scanner(System.in);
    ClazzService clazzService;
    public void setClazzService(ClazzService clazzService) {
        this.clazzService = clazzService;
    }
    List<Student> allStudentList = new ArrayList<>();
    //add
    public void addStudent() {
        int allStudentListSize = allStudentList.size();
        int id = (allStudentListSize > 0) ? (allStudentList.get(allStudentListSize-1).getStudentId() + 1) : 1;
        Student tmp = new Student();
        tmp.setStudentId(id);
        tmp.setName(inputName());
        tmp.setDateOfBirth(inputDateOfBirth());
        tmp.setClazz(selectClazz());
        tmp.getClazz().studentList.add(tmp);
        this.allStudentList.add(tmp);
    }

    //edit
    public void editStudent() {
        System.out.println("Nhập ID học sinh muốn sửa: ");
        int studentID = Integer.parseInt(studentScanner.nextLine());
        Student tmp = this.allStudentList.get(studentID-1);
        tmp.setName(inputName());
        tmp.setDateOfBirth(inputDateOfBirth());
        tmp.setClazz(selectClazz());
    }

    //delete
    public void deleteStudent() {
        System.out.println("Nhập ID học sinh muốn xóa: ");
        int studentID = Integer.parseInt(studentScanner.nextLine());

    }

    private Clazz selectClazz() {
        System.out.print("Input Clazz ID: ");
        int tmp = Integer.parseInt(studentScanner.nextLine());
        return clazzService.clazzList.get(tmp-1);
    }

    private String inputName() {
        System.out.print("Input Student's name: ");
        return studentScanner.nextLine();
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
