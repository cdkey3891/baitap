package com.company.foreach;

import com.company.Person;
import com.sun.javafx.collections.MappingChange;

import java.security.KeyStore;
import java.util.*;


public class foreach {
    public static void main(String[] args) {
        List<com.company.Person> list = new ArrayList<>();
        list.add(new Person(1, "hang", 20));
        list.add(new Person(4, "thua", 23));
        list.add(new Person(2, "ran", 18));
        list.add(new Person(3, "athem", 22));
        System.out.println("printed by foreach: ");
        printByForEach(list);
        System.out.println("sorted by Comparator");
        Collections.sort(list, new Comparator<Person>() {
            @Override
            public int compare(Person o1, Person o2) {
                return -o1.getName().compareTo(o2.getName());
            }
        });
        printByForEach(list);

        System.out.println("by java 8");
        list.sort(new Comparator<Person>() {
            @Override
            public int compare(Person o1, Person o2) {
                return -o1.getId() + o2.getId();
            }
        });
        printByForEach(list);

        System.out.println("by java 8 and lambda");
        list.sort((Person o1, Person o2) -> {
            return o1.getName().compareTo(o2.getName());
        });
        printByForEach(list);

        System.out.println("by java 8 and Comparator");
        list.sort(Comparator.comparing(Person::getName));
        printByForEach(list);






    }
    public static void printByForEach(List<Person> list) {
        list.forEach((a) -> {
            System.out.println("id: "+a.getId()+ ", name: "+a.getName()+", age: "+a.getAge());
        });
    }
}
