package com.company.anhkv.service;

import com.company.anhkv.Clazz;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class ClazzService {
    private static Scanner clazzScanner = new Scanner(System.in);
    public List<Clazz> clazzList = new ArrayList<>();
    //add
    public void addClazz() {
        int clazzListSize = clazzList.size();
        int id = (clazzListSize > 0) ? (clazzList.get(clazzListSize-1).getClassId() + 1) : 1;
        Clazz tmp = new Clazz();
        tmp.setClassId(id);
        tmp.setClassName(inputClazzName());
        tmp.studentList = new ArrayList<>();
        clazzList.add(tmp);
    }

    //edit
    public void editClazz() {
        System.out.println("Nhập mã lớp học muốn sửa: ");
        int clazzId = Integer.parseInt(clazzScanner.nextLine());
        Clazz tmp = findClazzById(clazzId);
        tmp.setClassName(inputClazzName());

    }

    //delete
    public void deleteClazz() {
        System.out.println("Nhập mã lớp học muốn xóa: ");
        int clazzId = Integer.parseInt(clazzScanner.nextLine());
        Clazz tmp = findClazzById(clazzId);
        clazzList.remove(tmp);
        System.out.println("Clazz deleted: " + tmp.toString());
    }

    private Clazz findClazzById(int id) {
        return clazzList.stream().filter(x -> x.getClassId() == id).collect(Collectors.toList()).get(0);

    }


    private String inputClazzName() {
        System.out.print("Input Clazz name: ");
        return clazzScanner.nextLine();
    }


    //show
    public void showStudentOfClazz(int index) {
        clazzList.get(index).showStudents();
    }

    public void showAllClass() {
        clazzList.forEach(x -> System.out.println(x.toString()));
    }


}
