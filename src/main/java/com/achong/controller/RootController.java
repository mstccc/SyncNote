package com.achong.controller;

import com.achong.bean.Url;
import com.achong.service.impl.RootServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * 1. 如果是访问根路径首页，则转发到一个任意的地址，数据为空（前端实现）
 * 2. 如果访问的url地址不合规范，则重定向到新的随机的合规地址
 * 3.
 */

@Controller
public class RootController {
    @Autowired
    RootServiceImpl rootService;

    @RequestMapping("/*")
    public void  allRequest(HttpServletRequest request, HttpServletResponse response){
        String requestPath = request.getRequestURI().substring(1,request.getRequestURI().length());
        request.setAttribute("path", requestPath);
        try {
            request.getRequestDispatcher("/WEB-INF/main.jsp").forward(request, response);
        } catch (ServletException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    /**
     * 处理首次请求，即浏览器第一次访问该后缀
     * 如果第一次查收数据，则将其返回，否则将当前访问的网址添加进数据库
     */
    @RequestMapping(value = "/firstRequest", produces = "json/html;charset=UTF-8")
    @ResponseBody
    public String firstRequest(String url){
        System.out.println("firstRequest ================================================== ");
        System.out.println(url);
        // 查询数据库有无此尾巴
        Url urlBean = rootService.queryUrl(url);
        boolean flag = urlBean == null ? false : true;
        System.out.println("firstRequest ==> flag: "+flag);
        if (flag){
            // 如果有数据，则返回
            return urlBean.getStrData();
        }else {
            // 否则将当前访问的url插入到数据库，并返回一个空内容
            rootService.insertUrl(new Url(url, ""));
            return "" ;
        }
    }

    /**
     * 处理后续的文本修改动作
     * @param strData 需要更新的文本
     * @param url   需要更新文本的主键，是当前访问的uri
     */
    @RequestMapping("/normalRequest")
    @ResponseBody
    public void normalRequest(String strData, String url){
        System.out.println("normalRequest===================================");

        Url urlBean = new Url(url, strData);
        System.out.println(urlBean);
        int flag = rootService.updateUrl(urlBean);

        System.out.println("requestPath: " + url + ", strData update: " + flag);
    }

}
