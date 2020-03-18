package com.company.anhkv.service;

import com.company.anhkv.Clazz;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ClazzService {
    public Scanner scanner = new Scanner(System.in);
    //add
    List<Clazz> clazzList = new ArrayList<>();
    public void addClazz() {
        Clazz tmp = new Clazz();
        int id = (clazzList.size() > 0) ? (clazzList.size() + 1) : 1;
        tmp.setClassId(id);
        tmp.setClassName(inputClazzName());
        tmp.studentList = new ArrayList<>();
        clazzList.add(tmp);
    }
    private String inputClazzName() {
        System.out.print("Input Clazz name: ");
        return scanner.nextLine();
    }

    private int inputClazzId() {
        return 0;
    }

    //show
    public void showStudentOfClazz(int index) {
        clazzList.get(index).showStudents();
    }

    public void showAllClass() {
        clazzList.forEach(x -> System.out.println(x.toString()));
    }
    //edit

    public void editClazz(int clazzId) {
        clazzList.get(clazzId-1).setClassName(inputClazzName());

    }
    //delete
    public void deleteClazz(int clazzId) {

    }
}
