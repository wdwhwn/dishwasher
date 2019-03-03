package com.jingzhun.controller;


import com.jingzhun.service.CashPageService;
import com.jingzhun.utils.jsonutil.JsonUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;
import java.util.Map;

/**
 * Created by Administrator on 2019/2/27 0027.
 */
@Controller
@CrossOrigin(origins = "*",maxAge = 3600)
public class CashPageController {
    @Autowired
    private CashPageService cashPageService;

    @RequestMapping("/selectByCashPage")
    @ResponseBody
    public String selectByCashPage(Integer userId){

        Map<String, Object> stringObjectMap = cashPageService.selectByCashPage(userId);
            stringObjectMap.put("message","执行成功");
        return JsonUtil.toJson(stringObjectMap);
    }
}
