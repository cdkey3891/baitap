package com.company.test;

public class Manager extends Employee {
    @Override
    public void print() {
        System.out.println("Print at sub class: Manager");
    }

    public void onlyInManager() {
        System.out.println("only in Manager");
    }
}
