package com.company.anhkv.model;

import java.text.SimpleDateFormat;
import java.util.Date;

public class Student {

    public Clazz clazz;
    private int studentId;
    private String name;
    private Date dateOfBirth;
    private int age;

    public Student(int studentId, String name) {
        this.studentId = studentId;
        this.name = name;
    }

    public Student() {
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public int getStudentId() {
        return studentId;
    }

    public void setStudentId(int studentId) {
        this.studentId = studentId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDateOfBirth() {
        SimpleDateFormat format = new SimpleDateFormat("ddMMyyyy");
        return format.format(dateOfBirth);
    }

    public void setDateOfBirth(Date dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public Clazz getClazz() {
        return clazz;
    }

    public void setClazz(Clazz clazz) {
        this.clazz = clazz;
    }

    @Override
    public String toString() {
        return "ID: " + studentId + ", Name: " + name + ", Class: " + clazz.getClassId() + ", Birth: " + this.getDateOfBirth() + ", Age: " + age;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj instanceof Student) {
            Student tmp = (Student) obj;
            if (this.getStudentId() == tmp.getStudentId()) {
                return true;
            }
        }
        return false;
    }
}
