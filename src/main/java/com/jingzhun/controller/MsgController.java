package com.jingzhun.controller;

import com.jingzhun.common.msg.Msg;
import com.jingzhun.entity.User;
import com.jingzhun.service.UserService;
import com.jingzhun.utils.idrandom.RandomNumber;
import com.jingzhun.utils.jedisUtil.JedisUtil;
import com.jingzhun.utils.jsonutil.JsonUtil;
import com.jingzhun.utils.token.JwtUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.io.FileNotFoundException;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * @author  王丹
 * Created by Administrator on 2019/3/1 0001.
 */
@RestController
@CrossOrigin(origins="*",maxAge = 3600)
@Slf4j
public class MsgController {
    @Autowired
    private UserService userService;
    /**
     *@title 发送验证码
     * @Description 生成验证码---存储到redis---发送给用户短信
     * @param mobile   手机号
     * @return  状态信息：成功  OR  失败
     * @throws FileNotFoundException 文件为找到异常
     */
    @RequestMapping("/msgAuthentication")
    public String msgAuthentication(String mobile) throws FileNotFoundException {
        String card = RandomNumber.getCard();
        JedisUtil.getJedis().set(mobile,card);
        Map<String, Object> stringObjectMap = Msg.mobileQuery(mobile, card);
        return JsonUtil.toJson(stringObjectMap);
    }
    /**
     *@Description  通过验证码  验证用户合法性
     * @param user 用户对象
     * @param mobile  手机号
     * @param card  验证码
     * @return
     */
    @RequestMapping("/msgCheck")
    public String msgCheck(User user, String  mobile, String card){
        System.out.println(user);
        HashMap<String, Object> stringObjectHashMap = new HashMap<String, Object>(5);
        String s = JedisUtil.getJedis().get(mobile);
        Date date = new Date();
        user.setUserDate(date);
        user.setUserMobile(mobile);
        String tokenOrigin=user.getUserName();
        if(card!=null && card.equals(s)){
//            String token= JwtUtil.getToken(tokenOrigin);
            boolean judge = userService.insert(user);
            if(judge) {
                stringObjectHashMap.put("message", "注册成功");
            }else{
                stringObjectHashMap.put("message", "验证成功");
            }
                stringObjectHashMap.put("code", "0");
//                stringObjectHashMap.put("token", token);
        }else {
            stringObjectHashMap.put("message", "验证失败");
            stringObjectHashMap.put("code", "1");
        }
            return JsonUtil.toJson(stringObjectHashMap);
    }
}
