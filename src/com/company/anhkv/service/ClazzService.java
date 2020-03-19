package com.company.anhkv.service;

import com.company.anhkv.model.Clazz;

import java.util.ArrayList;
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
        System.out.println("Bạn có muốn thêm lớp khác 1: yes, 0: no ");
        int choice = Integer.parseInt(clazzScanner.nextLine());
        if(choice == 1) {
            addClazz();
        }
    }

    //edit
    public void editClazz() {
        System.out.println("Nhập mã lớp học muốn sửa: ");
        int clazzId = Integer.parseInt(clazzScanner.nextLine());
        Clazz tmp = findClazzById(clazzId);
        System.out.println(tmp.toString());
        tmp.setClassName(inputClazzName());
        System.out.println("Bạn có muốn sửa lớp khác 1: yes, 0: no ");
        int choice = Integer.parseInt(clazzScanner.nextLine());
        if(choice == 1) {
            editClazz();
        }
    }

    //delete
    public void deleteClazz() {
        System.out.println("Nhập mã lớp học muốn xóa: ");
        int clazzId = Integer.parseInt(clazzScanner.nextLine());
        Clazz tmp = findClazzById(clazzId);
        clazzList.remove(tmp);
        System.out.println("Clazz deleted: " + tmp.toString());
        System.out.println("Bạn có muốn xóa lớp khác 1: yes, 0: no ");
        int choice = Integer.parseInt(clazzScanner.nextLine());
        if(choice == 1) {
            deleteClazz();
        }
    }

    public Clazz findClazzById(int id) {
        return clazzList.stream().filter(x -> x.getClassId() == id).collect(Collectors.toList()).get(0); //tìm cách để collect thành 1 object luôn.
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
