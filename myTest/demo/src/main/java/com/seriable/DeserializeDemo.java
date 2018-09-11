package com.seriable;

import java.io.FileInputStream;
import java.io.ObjectInputStream;

public class DeserializeDemo {
    public static void main(String[] args) {
        Employee e=null;
        try{
            FileInputStream fileIn=new FileInputStream("e://temp//employee.ser");
            ObjectInputStream in=new ObjectInputStream(fileIn);

            e=(Employee) in.readObject();
            in.close();
            fileIn.close();
        }catch(Exception e1){
            e1.printStackTrace();
        }

        System.out.println(e.getName());
        System.out.println(e.getAge());
        System.out.println(e.getAddress());
    }


}
