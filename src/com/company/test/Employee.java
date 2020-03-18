package com.company.test;

import com.sun.scenario.effect.impl.sw.java.JSWBlend_SRC_OUTPeer;

public class Employee  {
    private Integer id;
    private String name;

    public Employee() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Employee(Integer id, String name) {
        this.id = id;
        this.name = name;
    }

    public void print() {
        System.out.println("Print at super class: Employee");
    }

    public void onlyInEmp() {
        System.out.println("only in Employee");
    }
}
