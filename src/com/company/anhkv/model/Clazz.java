package com.company.anhkv.model;

import java.util.ArrayList;
import java.util.List;

public class Clazz {
    private int classId;
    private String className;
    public List<Student> studentList = new ArrayList<>();
    private int siso;

    public int getSiso() {
        return studentList.size();
    }

    public Clazz() {
    }

    public int getClassId() {
        return classId;
    }

    public void setClassId(int classId) {
        this.classId = classId;
    }

    public String getClassName() {
        return className;
    }

    public void setClassName(String className) {
        this.className = className;
    }

    @Override
    public String toString() {
        return "Clazz ID: "+ classId + ", Clazz name: "+ className + ", Students: "+ this.getSiso();
    }

    public void showStudents() {
        studentList.forEach(x -> System.out.println(x.toString()));
    }

    @Override
    public boolean equals(Object obj) {
         if (obj instanceof Clazz) {
             Clazz tmp = (Clazz) obj;
             return this.getClassId() == tmp.getClassId();
         }
         return false;
    }
}
