package com.jingzhun.controller;

import com.jingzhun.entity.User;
import com.jingzhun.service.CashSummaryService;
import com.jingzhun.utils.jsonutil.JsonUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author 王丹
 * Created by Administrator on 2019/2/27 0027.
 */
@RestController
@CrossOrigin(origins = "*",maxAge = 3600)
public class CashSummaryController {
    @Autowired
    private CashSummaryService cashSummaryService;

    /**
     * @return
     */
    @RequestMapping("/selectByCashSummary")
    public String selectByCashSummaryService(Integer userId){
        User user = cashSummaryService.selectByCashSummary(userId);
        return JsonUtil.toJson(user);
    }
}
