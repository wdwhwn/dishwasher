package com.jingzhun.controller;

import com.jingzhun.entity.Account;
import com.jingzhun.service.AccountService;
import com.jingzhun.service.UserService;
import com.jingzhun.utils.jsonutil.JsonUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.HashMap;

/**
 * @author 王丹
 * Created by Administrator on 2019/3/4 0004.
 */
@RestController
@CrossOrigin(origins = "*",maxAge = 3600)
public class AccountController {
    @Autowired
    private AccountService accountService;
    @Autowired
    private UserService userService;

    /**
     *    添加账户
     * @param account  账户对象
     * @return 添加成功
     */
    @RequestMapping("/accountInsert")
    public String accountInsert(Account account){
        HashMap<String,Object> hashMap = new HashMap<>(3);
        accountService.insert(account);
        hashMap.put("message","添加成功");
        return JsonUtil.toJson(hashMap);
    }
    /**
     *    删除账户
     * @param account  账户对象
     * @return 添加成功
     */
    @RequestMapping("/accountDelete")
    public String accountDelete(Account account){
        HashMap<String,Object> hashMap = new HashMap<>(3);
        accountService.delete(account);
        hashMap.put("message","添加成功");
        return JsonUtil.toJson(hashMap);
    }
    /**
     *    修改账户
     * @param account  账户对象
     * @return 添加成功
     */
    @RequestMapping("/accountUpdate")
    public String accountUpdate(Account account){
        HashMap<String,Object> hashMap = new HashMap<>(3);
        accountService.update(account);
        hashMap.put("message","添加成功");
        return JsonUtil.toJson(hashMap);
    }
    /**
     *    提现
     * @param accountId   账户id
     * @param userId      用户id
     * @param money       提现金额
     * @return              提现成功
     */
    @RequestMapping("/cash")
    public String cash(Integer accountId,Integer userId,Double money){
        HashMap<String,Object> hashMap = new HashMap<>(3);
            accountService.cash(accountId,userId,money);
            hashMap.put("message","提现成功");
            hashMap.put("message","提现成功");
            return JsonUtil.toJson(hashMap);
    }
}
