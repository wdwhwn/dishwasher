package com.jingzhun.controller;

import com.jingzhun.common.exception.zdy.AesException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * Created by Administrator on 2019/3/9 0009.
 */
@Controller
@Slf4j
public class TestController {
    /**
     * 微信公众号验证
     * @return
     */
    @RequestMapping(value = "/wechatAuth")
    @ResponseBody
    public String wechatAuth(String signature, String timestamp, String nonce, String echostr) {
        //获取微信服务器配置的自定义token
        String token = "jingzhun";
        String sig = null;
        try {
            sig = SHA1.getSHA1(token,timestamp,nonce,"");
        } catch (AesException e) {
            e.printStackTrace();
        }
        System.out.println(sig+","+signature+","+timestamp+","+nonce+","+echostr);
        if(signature.equals(sig)){
            return echostr;
        }else{
            return "error";
        }
    }

}
