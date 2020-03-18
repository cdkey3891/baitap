package com.company.anhkv;

import java.util.ArrayList;
import java.util.List;

public class Clazz {
    private int classId;
    private String className;
    public List<Student> studentList = new ArrayList<>();

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
        return "Clazz ID: "+ classId + ", Clazz name: "+ className + ", Students: "+studentList.size();
    }

    public void showStudents() {
        studentList.forEach(x -> System.out.println(x.toString()));
    }

    @Override
    public boolean equals(Object obj) {
         if (obj instanceof Clazz) {
             Clazz tmp = (Clazz) obj;
             if (this.getClassId() == tmp.getClassId()) {
                 return true;
             }
         }
         return false;
    }
}
