package com.jingzhun.controller;


import com.jingzhun.service.FirstPageService;
import com.jingzhun.utils.jsonutil.JsonUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

/**
 * @author  王丹
 * Created by Administrator on 2019/2/27 0027.
 */
@RestController
@CrossOrigin(origins = "*",maxAge = 3600)
@Slf4j
public class FirstPageController {

    @Autowired
    private FirstPageService firstPageService;
    @RequestMapping("/firstPageSelectAll")
    public String firstPageSelectAll(Integer userId,Integer pageNum,Integer pageSize) throws Exception {
        Map<String, Object> fistPageMap = firstPageService.selectByFistPage(userId,pageNum,pageSize);
            log.error("测试是否乱码");
        fistPageMap.put("message","执行成功");
        return   JsonUtil.toJson(fistPageMap);


    }
}
