package com.company.singleton;

public class Database {
    private static Database instance;
    private Database() {}
    public static Database getInstance() {
        if (instance == null) {
            instance = new Database();
        } else return instance;
        return instance;
    }
}
