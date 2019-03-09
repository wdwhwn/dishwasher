package com.jingzhun.controller;


import com.jingzhun.service.CashPageService;
import com.jingzhun.utils.jsonutil.JsonUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.Map;

/**
 * @author 王丹
 * Created by Administrator on 2019/2/27 0027.
 */
@RestController
@CrossOrigin(origins = "*",maxAge = 3600)
public class CashPageController {
    @Autowired
    private CashPageService cashPageService;

    /**
     * @title  提现记录
     * @param userId  用户id
     * @return  状态信息：执行成功
     */
    @RequestMapping("/selectByCashPage")
    public String selectByCashPage(Integer userId){
        Map<String, Object> stringObjectMap = cashPageService.selectByCashPage(userId);
            stringObjectMap.put("message","执行成功");
        return JsonUtil.toJson(stringObjectMap);
    }
}
