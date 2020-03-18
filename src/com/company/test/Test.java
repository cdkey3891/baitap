package com.company.test;

public class Test {
    public static void main(String[] args) {
        Employee manager1 = new Manager();
        Manager manager2 = new Manager();
        manager1.print();
        manager1.onlyInEmp();
        Manager manager = new Manager();
        Employee[] employees = new Employee[3];
        employees[0] = manager;
        manager.onlyInManager();
        employees[0].onlyInEmp();
    }
}
