package com.javaNewCharacter;

import java.util.Arrays;
import java.util.List;
import java.util.function.Supplier;

class Car {
    /**
     * Supplier是jdk1.8的接口，这里和lamda一起使用了
     */
    public static Car create( Supplier<Car> supplier) {
        return supplier.get();
    }

    public static void collide( Car car) {
        System.out.println("Collided " + car.toString());
    }

    public void follow( Car another) {
        System.out.println("Following the " + another.toString());
    }

    public void repair() {
        System.out.println("Repaired " + this.toString());
    }

    public static void main(String[] args) {
        //构造器引用
         Car car = Car.create(Car::new);
         List<Car> cars = Arrays.asList(car);

        //静态方法引用
        cars.forEach(Car::collide);

        //特定类的任意对象的方法引用
        cars.forEach(Car::repair);

        //特定对象的方法引用
         Car police = Car.create(Car::new);
        cars.forEach(police::follow);
    }
}