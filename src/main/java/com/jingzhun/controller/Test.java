package com.jingzhun.controller;

import com.jingzhun.utils.jsonutil.JsonUtil;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * Created by Administrator on 2019/3/4 0004.
 */
@Controller
public class Test {
    @RequestMapping("/test")
    @ResponseBody
    public String  test(){
        System.out.println("123456798748653218465");
        System.out.println("test");
        return JsonUtil.toJson("ceui+++++++++++");
    }
}
