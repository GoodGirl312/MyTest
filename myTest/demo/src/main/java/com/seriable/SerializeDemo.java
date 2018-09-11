package com.seriable;

import org.junit.Test;

import java.io.*;

public class SerializeDemo {

    /***
     * 序列化
     */
    @Test
    public void test1(){
        Employee employee=new Employee();
        employee.setName("张三");
        employee.setAge(20);
        employee.setAddress("上海市");

        try {
            FileOutputStream fileOut=new FileOutputStream("e://temp//employee.ser");
            ObjectOutputStream out=new ObjectOutputStream(fileOut);
            out.writeObject(employee);
            out.close();
            fileOut.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void deserialize(){
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
        System.out.println(e.toString());
    }
}
