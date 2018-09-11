package com.javaNewCharacter;

import java.util.*;
import java.util.stream.Collectors;

public class Java8Tester4 {
    public static void main(String args[]) {

       /* List<String> strings = Arrays.asList("abc", "", "bc", "efg", "abcd", "", "jkl");
        strings = strings.stream().filter(string -> !string.isEmpty()).collect(Collectors.toList());
        strings.forEach(System.out::println);*/


     /*   List<Integer> numbers = Arrays.asList(3, 2, 2, 3, 7, 3, 5);
         // 获取对应的平方数
        List<Integer> squaresList =numbers.stream().map(i->i*i).distinct().collect(Collectors.toList());
        squaresList.forEach(System.out::println);*/

        List<Person> persons1 = new ArrayList<Person>();
        persons1.add(new Person("zhangsan", 20, 40));
        persons1.add(new Person("lisi", 18, 40));
        persons1.add(new Person("wanger", 12, 60));
        persons1.add(new Person("mazi", 19, 40));
        persons1.add(new Person("yy",null,19));
        persons1.add(new Person("yys",0,19));

        List<Integer> ages = persons1.stream().map(Person::getAge).filter(age->age!=null && age>0 ).distinct().collect(Collectors.toList());

        ages.forEach(System.out::println);

        //   ages.forEach(System.out::println);

        Random random = new Random();
        //random.ints().limit(10).sorted().forEach(System.out::println);


        List<Integer> numbers = Arrays.asList(3, 2, 2, 3, 7, 3, 5);

        IntSummaryStatistics stats = numbers.stream().mapToInt((x) -> x).summaryStatistics();

        System.out.println("列表中最大的数 : " + stats.getMax());
        System.out.println("列表中最小的数 : " + stats.getMin());
        System.out.println("所有数之和 : " + stats.getSum());
        System.out.println("平均数 : " + stats.getAverage());
    }

}