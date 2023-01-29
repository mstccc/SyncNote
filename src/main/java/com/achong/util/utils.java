package com.achong.util;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Random;

public class utils {
    //获取一个四位的字符串
    public static String getString4(){
        return String.format("%04d", new Random().nextInt(999999));
    }

    //重定向到新地址，传入一个新地址
    public static void sendNewUrl(HttpServletResponse response, String newUrl){
        try {
            response.sendRedirect("http://localhost:8087/"+newUrl);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
