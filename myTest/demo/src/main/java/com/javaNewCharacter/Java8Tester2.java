package com.javaNewCharacter;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class Java8Tester2 {
    public static void main(String args[]){


        List<Person> persons1 = new ArrayList<Person>();
        persons1.add(new Person("zhangsan",20));
        persons1.add(new Person("lisi",18));
        persons1.add(new Person("wanger",39));
        persons1.add(new Person("mazi",19));


        Java8Tester2 tester = new Java8Tester2();

        tester.sortUsingJava8(persons1);
        System.out.println(persons1);
    }


    /***使用 java 8 排序*/
    private void sortUsingJava8(List<Person> persons){
        Collections.sort(persons, Comparator.comparing(Person::getName));
    }
}