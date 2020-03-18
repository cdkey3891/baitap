package com.company.lambda;


import java.util.*;

public class Lambda {
    public static void main(String[] args) {
        Person a = new Person(1, "thang");
        Person b = new Person(3,"van");
        Person c = new Person(2, "ung");
        List<Person> list = new ArrayList<Person>();
        list.add(a);
        list.add(b);
        list.add(c);
        Collections.sort(list, new Comparator<Person>() {
            @Override
            public int compare(Person o1, Person o2) {
                return -o1.getName().compareTo(o2.getName());
            }
        });


        Iterator<Person> it = list.iterator();
        while (it.hasNext()) {
            Person tmp = it.next();
            System.out.println(tmp);
        }
    }
}
