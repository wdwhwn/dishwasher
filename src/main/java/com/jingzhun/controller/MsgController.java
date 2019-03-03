package com.jingzhun.controller;

import com.jingzhun.common.msg.Msg;
import com.jingzhun.entity.User;
import com.jingzhun.service.UserService;
import com.jingzhun.utils.idrandom.RandomNumber;
import com.jingzhun.utils.jedisUtil.JedisUtil;
import com.jingzhun.utils.jsonutil.JsonUtil;
import com.jingzhun.utils.token.JwtUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.io.FileNotFoundException;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by Administrator on 2019/3/1 0001.
 */
@Controller
@CrossOrigin(origins="*",maxAge = 3600)
public class MsgController {
    @Autowired
    private UserService userService;
//    发送验证码
    @RequestMapping("/msgAuthentication")
    @ResponseBody
    public String msgAuthentication(String mobile) throws FileNotFoundException {
        String card = RandomNumber.getCard();
        System.out.println(mobile+" "+card);
        JedisUtil.getJedis().set(mobile,card);
        Map<String, Object> stringObjectMap = Msg.mobileQuery(mobile, card);
        return JsonUtil.toJson(stringObjectMap);
    }
//    通过验证码  验证用户合法性
    @RequestMapping("/msgCheck")
    @ResponseBody
    public String msgCheck(String  mobile,String card,String userWxImg,String userWxName){
        HashMap<String, Object> stringObjectHashMap = new HashMap<String, Object>();
        String s = JedisUtil.getJedis().get(mobile);
        Date date = new Date();
        User user=new User();
        user.setUserWxImg(userWxImg);
        user.setUserWxName(userWxName);
        user.setUserDate(date);
        String tokenOrigin=userWxImg+userWxName;
        System.out.println(card+" "+s);
        if(card!=null && card.equals(s)){
            String token= JwtUtil.getToken(tokenOrigin);
            userService.insert(user);
            stringObjectHashMap.put("message","验证成功");
            stringObjectHashMap.put("code","0");
            stringObjectHashMap.put("token",token);
        }else {
            stringObjectHashMap.put("message", "验证失败");
            stringObjectHashMap.put("code", "1");
        }
            return JsonUtil.toJson(stringObjectHashMap);
    }
}
