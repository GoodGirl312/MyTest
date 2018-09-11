package com.networkProgramming;

import java.text.SimpleDateFormat;
import java.util.Date;

public class WebPing {
    public static void main(String[] args) {
        Long timeStamp = System.currentTimeMillis();  //获取当前时间戳
        SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        //String sd = sdf.format(new Date(Long.parseLong(String.valueOf(timeStamp))));      // 时间戳转换成时间
        String sd = sdf.format(new Date(timeStamp));
        System.out.println("格式化结果：" + sd);
    }


}
