package com.stream;

import org.junit.Test;

import java.io.*;

/**
 * 字符流字节流
 */
public class StreamTest1 {
    @Test   //字节流操作
    public void test1() {

        try {
            String str1 = "D:\\pic\\a.txt";
            String str2 = "D:\\pic\\b.txt";
            FileInputStream fis = new FileInputStream(str1);
            FileOutputStream fos = new FileOutputStream(str2);

            byte[] b = new byte[1024];
            while (fis.read(b) != -1) {
                fos.write(b);
            }
            // 关闭流  先开后关  后开先关
            fos.close(); // 后开先关
            fis.close(); // 先开后关
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test  //使用字符流操作
    public void test2() {
        String str1 = "D:\\pic\\a.txt";
        String str2 = "D:\\pic\\b.txt";
        try {
            BufferedReader reader = new BufferedReader(new FileReader(str1));
            BufferedWriter writer = new BufferedWriter(new FileWriter(str2));

            String str;
            while ((str = reader.readLine()) != null) {
                writer.write(str);
            }
            writer.close();
            reader.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
