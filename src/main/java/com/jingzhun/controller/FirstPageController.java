package com.jingzhun.controller;


import com.jingzhun.service.FirstPageService;
import com.jingzhun.utils.jsonutil.JsonUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

/**
 * Created by Administrator on 2019/2/27 0027.
 */
@RestController
@CrossOrigin(origins = "*",maxAge = 3600)
public class FirstPageController {

    @Autowired
    private FirstPageService firstPageService;
    @RequestMapping("/firstPageSelectAll")
    public String firstPageSelectAll(Integer userId,Integer pageNum,Integer pageSize) throws Exception {
        Map<String, Object> fistPageMap = firstPageService.selectByFistPage(userId,pageNum,pageSize);
        fistPageMap.put("message","执行成功");
        return   JsonUtil.toJson(fistPageMap);


    }
}
