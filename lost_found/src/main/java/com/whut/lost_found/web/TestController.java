package com.whut.lost_found.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by Administrator on 2017/7/21 0021.
 */
@Controller
@RequestMapping("/Test")
public class TestController {
    @RequestMapping("/getTest")
    public String getTest(){
        return "test";
    }
}
