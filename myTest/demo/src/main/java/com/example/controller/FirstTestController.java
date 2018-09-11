package com.example.controller;

import com.example.Qrcode.CreateQRCode;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletResponse;
import java.util.Arrays;
import java.util.Collections;

@Controller
@RequestMapping("/index")
public class FirstTestController {

    @RequestMapping("/indexTest")
    public String toIndex(){
        return "index";

    }
    /*@RequestMapping("/getQRcode")
    public void getQRcode(HttpServletResponse response){
        try {
            CreateQRCode.getQRcode(response);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }*/

    public static void main(String[] args) {
        Integer[] numbers = { 8, 2, 7, 1, 4, 9, 5};
        int min = (int) Collections.min(Arrays.asList(numbers));
        int max = (int) Collections.max(Arrays.asList(numbers));
        System.out.println("最小值: " + min);
        System.out.println("最大值: " + max);
    }
}
