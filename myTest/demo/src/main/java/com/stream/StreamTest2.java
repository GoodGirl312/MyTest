package com.stream;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class StreamTest2 {
    public static void main(String[] args){

        String str = "白日依山尽\n";
        char[] ch = str.toCharArray();
        FileWriter fw = null;
        FileReader fr = null;
        try {
            fw = new FileWriter("d:\\pic\\登鹤雀楼.txt");  //注意：这是相对路径，在所创建的java项目里
            fw.write(ch);
            fw.write("黄河入海流\n");
            fw.write("欲穷千里目\n");
            fw.write("更上一层楼\n");
            fw.close();
        } catch (IOException e) {
            System.err.println("流的创建、写和关闭都可能产生IOException异常。");
            System.exit(-1);
        }
        try {
            fr = new FileReader("d:\\pic\\登鹤雀楼.txt");
            int i;
            while ((i = fr.read()) != -1) {
                System.out.print((char) i);
            }
            System.out.println();
            fr.close();
        } catch (FileNotFoundException e) {
            System.err.println("文件未找到！");
            System.exit(-2);
        } catch (IOException e) {
            System.err.println("读和关闭都可能产生IOException异常。");
            System.exit(-3);
        }
    }
}
