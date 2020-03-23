package com.company.anhkv.service;

import com.company.anhkv.model.Clazz;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class ClazzService {

    private static Scanner clazzScanner = new Scanner(System.in);
    public List<Clazz> clazzList = new ArrayList<>();

    public void addClazz() {
        int clazzListSize = clazzList.size();
        int id = (clazzListSize > 0) ? (clazzList.get(clazzListSize - 1).getClassId() + 1) : 1;
        Clazz tmpClazz = new Clazz();
        tmpClazz.setClassId(id);
        tmpClazz.setClassName(inputClazzName());
        tmpClazz.studentList = new ArrayList<>();
        clazzList.add(tmpClazz);
        System.out.print("Bạn có muốn thêm lớp khác 1: yes, 0: no ");
        String choice = clazzScanner.nextLine();
        if (choice.equals("1")) {
            addClazz();
        }
    }

    public void editClazz() {
        Clazz tmpClazz = findClazzById();
        if (tmpClazz != null) {
            System.out.println(tmpClazz.toString());
            tmpClazz.setClassName(inputClazzName());
            System.out.print("Bạn có muốn sửa lớp khác 1: yes, 0: no ");
            String choice = clazzScanner.nextLine();
            if (choice.equals("1")) {
                editClazz();
            }
        } else {
            System.out.println("Clazz not exist");
        }
    }

    public void deleteClazz() {
        Clazz tmpClazz = findClazzById();
        if (tmpClazz != null) {
            clazzList.remove(tmpClazz);
            System.out.println("Clazz deleted: " + tmpClazz.toString());
            System.out.print("Bạn có muốn xóa lớp khác 1: yes, 0: no ");
            String choice = clazzScanner.nextLine();
            if (choice.equals("1")) {
                deleteClazz();
            }
        } else {
            System.out.println("Clazz not exist");
        }
    }

    public Clazz findClazzById() {
        //return clazzList.stream().filter(x -> x.getClassId() == id).collect(Collectors.toList()).get(0); //tìm cách để collect thành 1 object luôn.
        System.out.print("Input Clazz ID: ");
        int clazzId = Integer.parseInt(clazzScanner.nextLine());
        Clazz tmpClazz = null;
        List<Clazz> list = clazzList.stream().filter(x -> x.getClassId() == clazzId).collect(Collectors.toList());
        if (!list.isEmpty()) {
            tmpClazz = list.get(0);
        }
        return tmpClazz;
    }

    private String inputClazzName() {
        System.out.print("Input Clazz name: ");
        return clazzScanner.nextLine();
    }

    public void showStudentOfClazz(int index) {
        clazzList.get(index).showStudents();
    }

    public void showAllClass() {
        clazzList.forEach(x -> System.out.println(x.toString()));
    }
}
