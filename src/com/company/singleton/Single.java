package com.company.singleton;

public class Single {
    public static void main(String[] args) {
        Database db = Database.getInstance();
        Database db1 = Database.getInstance();
        Database db2 = Database.getInstance();
        System.out.println();
    }
}
