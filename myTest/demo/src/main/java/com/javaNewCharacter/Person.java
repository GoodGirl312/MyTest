package com.javaNewCharacter;

public class Person {
    String name;
    Integer age;

    private Integer parentAge;
    public Person() {
    }

    public Person(String name, Integer age) {
        this.name = name;
        this.age = age;
    }

    public Person(String name, Integer age, int parentAge) {
        this.name = name;
        this.age = age;
        this.parentAge = parentAge;
    }

    public Integer getParentAge() {
        return parentAge;
    }

    public void setParentAge(int parentId) {
        this.parentAge = parentId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", parentAge=" + parentAge +
                '}';
    }
}
