package com.company.generic;

public class Dog extends Animal {
    private String type;

    public Dog(String name, int age, String type) {
        super(name, age);
        this.type = type;
    }

    public Dog(String name, int age) {
        super(name, age);
    }


}
