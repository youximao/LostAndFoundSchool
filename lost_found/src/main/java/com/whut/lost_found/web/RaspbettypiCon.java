package com.whut.lost_found.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by Administrator on 2017/11/18 0018.
 */
@Controller
@RequestMapping("/raspbettypi")
public class RaspbettypiCon {


    //主页
    @RequestMapping("/home")
    public String getHome(){
        return "/raspbettypi/home";
    }

}
