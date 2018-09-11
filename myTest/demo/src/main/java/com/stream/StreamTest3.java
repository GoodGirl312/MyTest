package com.stream;

import java.io.*;

public class StreamTest3 {
    public static void main(String[] args) throws Exception {
        BufferedWriter out1 = new BufferedWriter(new FileWriter("d:\\pic\\one.txt"));
        out1.write("我生气了\n");
        out1.close();
        InputStream in = new FileInputStream(new File("d:\\pic\\one.txt"));
        OutputStream out = new FileOutputStream(new File("d:\\pic\\two.txt"));
        byte[] buf = new byte[1024];
        int len;
        while ((len = in.read(buf)) > 0) {
            out.write(buf, 0, len);
        }
        in.close();
        out.close();
        BufferedReader in1 = new BufferedReader(new FileReader("d:\\pic\\two.txt"));
        String str;
        while ((str = in1.readLine()) != null) {
            System.out.println(str);
        }
        in1.close();
    }
}
