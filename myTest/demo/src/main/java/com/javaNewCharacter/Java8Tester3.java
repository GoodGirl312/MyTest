package com.javaNewCharacter;

import org.springframework.beans.BeanUtils;

import java.util.*;
import java.util.function.BiFunction;
import java.util.function.Function;
import java.util.function.Predicate;

public class Java8Tester3 {

    public static void main(String args[]) {
        List<Person> persons1 = new ArrayList<Person>();

        persons1.add(new Person("zhangsan", 20, 40));
        persons1.add(new Person("lisi", 18, 40));
        persons1.add(new Person("wanger", 12, 60));
        persons1.add(new Person("mazi", 19, 40));

        List<Person> persons2 = new ArrayList<Person>();
        persons2.add(new Person("zhangsan", 60, -1));
        persons2.add(new Person("lisiFather", 40, 60));


        // Predicate<Integer> predicate = n -> true
        // n 是一个参数传递到 Predicate 接口的 test 方法
        // n 如果存在则 test 方法返回 true

        //  System.out.println("输出所有数据:");

        // 传递参数 n
        //eval(persons1, n->n.age==18);
    /*    eval2(persons1,persons2,(m,n)->{
            if (m.getParentAge()==n.getAge()){
                return n;
            }
            return null;
        }
       );*/

        Person p1 = new Person("小二", 40);
        Person p2 = new Person("小红", 18,0);
        eval3(p1, m -> {
            if (m.getAge() == 40) {
               p2.setParentAge(m.getAge());
                return p2;
            }
            return p2;
        });

        // Predicate<Integer> predicate1 = n -> n%2 == 0
        // n 是一个参数传递到 Predicate 接口的 test 方法
        // 如果 n%2 为 0 test 方法返回 true
/*
        System.out.println("输出所有偶数:");
        eval(list, n-> n%2 == 0 );*/

        // Predicate<Integer> predicate2 = n -> n > 3
        // n 是一个参数传递到 Predicate 接口的 test 方法
        // 如果 n 大于 3 test 方法返回 true
/*
        System.out.println("输出大于 3 的所有数字:");
        eval(list, n-> n > 3 );*/
    }

    public static void eval(List<Person> list, Predicate<Person> predicate) {
        for (Person n : list) {
            if (predicate.test(n)) {
                System.out.println(n + " ");
            }
        }
    }

    public static void eval2(List<Person> list, List<Person> list2, BiFunction<Person, Person, Person> function) {
        Set list3 = new HashSet();
        for (Person m : list) {
            for (Person n : list2) {
                list3.add(function.apply(m, n));
            }
        }
        System.out.println(list3);
    }

    public static void eval3(Person p1, Function<Person, Person> function) {
        System.out.println(function.apply(p1));
    }

}
