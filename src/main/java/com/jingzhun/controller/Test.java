package com.jingzhun.controller;

import com.jingzhun.utils.jsonutil.JsonUtil;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by Administrator on 2019/3/4 0004.
 */
@RestController
public class Test {
    @RequestMapping("/test")
    public String  test(){
        System.out.println("123456798748653218465");
        System.out.println("test");
        return JsonUtil.toJson("ceui+++++++++++");
    }
}
