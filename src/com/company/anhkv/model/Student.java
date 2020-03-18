package com.company.anhkv.model;

import java.util.Date;

public class Student {
    private int studentId;
    private String name;
    private Date dateOfBirth;
    private int age;
    public Clazz clazz;

    public Student(int studentId, String name) {
        this.studentId = studentId;
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public Student() {
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

    public Date getDateOfBirth() {
        return dateOfBirth;
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
        return "ID: "+studentId+", Name: "+ name+", Class: "+clazz.getClassId();
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
