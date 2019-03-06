package com.jingzhun.controller;

import com.jingzhun.entity.Account;
import com.jingzhun.service.AccountService;
import com.jingzhun.service.UserService;
import com.jingzhun.utils.bigdecimal.Arith;
import com.jingzhun.utils.jsonutil.JsonUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.math.BigDecimal;
import java.util.HashMap;

/**
 * Created by Administrator on 2019/3/4 0004.
 */
@Controller
@CrossOrigin(origins = "*",maxAge = 3600)
public class AccountController {
    @Autowired
    private AccountService accountService;
    @Autowired
    private UserService userService;
    @RequestMapping("/accountInsert")
//    添加账号
    @ResponseBody
    public String accountInsert(Account account){
        HashMap<String,Object> hashMap = new HashMap<>();
        accountService.insert(account);
        hashMap.put("message","添加成功");
        return JsonUtil.toJson(hashMap);
    }
//    提现
    @RequestMapping("/cash")
    @ResponseBody
    public String cash(Integer accountId,Integer userId,Double money){
        HashMap<String,Object> hashMap = new HashMap<>();
            accountService.cash(accountId,userId,money);
            hashMap.put("message","提现成功");
            return JsonUtil.toJson(hashMap);
    }
}
