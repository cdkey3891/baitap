package com.company.anhkv.service;

import com.company.anhkv.model.Clazz;
import com.company.anhkv.model.Student;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

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
        System.out.println("Bạn có muốn thêm học sinh khác 1: yes, 0: no ");
        int choice = Integer.parseInt(studentScanner.nextLine());
        if(choice == 1) {
            addStudent();
        }
    }

    //edit
    public void editStudent() {
        System.out.println("Nhập ID học sinh muốn sửa: ");
        int studentID = Integer.parseInt(studentScanner.nextLine());
        Student tmp = findStudentById(studentID);
        System.out.println(tmp.toString());
        tmp.setName(inputName());
        tmp.setDateOfBirth(inputDateOfBirth());
        tmp.setClazz(selectClazz());
        System.out.println("Bạn có muốn sửa học sinh khác 1: yes, 0: no ");
        int choice = Integer.parseInt(studentScanner.nextLine());
        if(choice == 1) {
            editStudent();
        }
    }

    //delete
    public void deleteStudent() {
        System.out.println("Nhập ID học sinh muốn xóa: ");
        int studentID = Integer.parseInt(studentScanner.nextLine());
        Student tmp = findStudentById(studentID);
        allStudentList.remove(tmp);
        System.out.println("Bạn có muốn xóa học sinh khác 1: yes, 0: no ");
        int choice = Integer.parseInt(studentScanner.nextLine());
        if(choice == 1) {
            deleteStudent();
        }
    }

    private Student findStudentById(int id) {
        Student tmp;
        tmp = allStudentList.stream().filter(x -> x.getStudentId() == id).collect(Collectors.toList()).get(0);
        return tmp;
    }

    private Clazz selectClazz() {
        System.out.print("Input Clazz ID: ");
        int tmp = Integer.parseInt(studentScanner.nextLine());
        return clazzService.findClazzById(tmp);
    }

    private String inputName() {
        System.out.print("Input Student's name: ");
        return studentScanner.nextLine();
    }
    private Date inputDateOfBirth() {
        System.out.println("Input Student's birthday: (later)");
        Date tmp = new Date();
        return tmp;
    }

    public void showAllStudents() {
        allStudentList.forEach(x -> System.out.println(x.toString()));
    }


}
