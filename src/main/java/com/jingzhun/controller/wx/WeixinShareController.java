package com.jingzhun.controller.wx;
import com.jingzhun.entity.weixin.WeixinShare;
import com.jingzhun.utils.jsonutil.JsonUtil;
import com.jingzhun.utils.weixinutils.WeixinUtil;
import net.sf.json.JSONObject;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.security.MessageDigest;
import java.util.Formatter;
import java.util.HashMap;
import java.util.UUID;

@RestController
@CrossOrigin(origins = "*",maxAge = 3600)
public class WeixinShareController {
    @RequestMapping("weiXinShare")
    public String index(String url){
        HashMap<String, Object> stringObjectHashMap = new HashMap<>();
        // 微信appid 1
        String appid = "wx778f313eff0f980b";
        // 微信secret
        String secret = "910415b15c96d7268cc1ee899f5fc8cd";
        // 初始化access_token
        String access_token = "jingzhun";
        long expires_in;
        long createDate;
        //  获取URL 这里的URL指的是需要分享的那个页面地址,建议这里不要写成固定地址，而是获取当前地址.
//        url= "xiwanji.91xiaokong.com";
        // 创建通过Api获取Token的链接与参数
        String requestTokenUrl = "https://api.weixin.qq.com/cgi-bin/token?grant_type=client_credential&appid=APPID&secret=SECRET";
        requestTokenUrl = requestTokenUrl.replace("APPID", appid);
        requestTokenUrl = requestTokenUrl.replace("SECRET", secret);

        JSONObject jsonObjectToken = WeixinUtil.httpRequest(requestTokenUrl, "GET", null);
        if(jsonObjectToken !=null){
            // 创建日期赋值为当前日期
            createDate= System.currentTimeMillis() / 1000;
            // 获取Token值
            access_token= jsonObjectToken.getString("access_token");
            // 获取Token有效期值
            expires_in = jsonObjectToken.getLong("expires_in");
        }
        String requestUrl = "https://api.weixin.qq.com/cgi-bin/ticket/getticket?access_token=ACCESS_TOKEN&type=jsapi";
        requestUrl = requestUrl.replace("ACCESS_TOKEN", access_token);
        // 获取凭证
        JSONObject jsonObject = WeixinUtil.httpRequest(requestUrl, "GET", null);
        if(jsonObjectToken !=null){
            try {
                String ticket = jsonObject.getString("ticket");
                String noncestr = UUID.randomUUID().toString();
                long timestamp =System.currentTimeMillis() / 1000;
                String param = "jsapi_ticket="+ticket+"&noncestr="+noncestr+"&timestamp="+timestamp+"&url="+url;
                MessageDigest crypt = MessageDigest.getInstance("SHA-1");
                crypt.reset();
                crypt.update(param.getBytes("UTF-8"));
                String signature = byteToHex(crypt.digest());
//                String signature = DigestUtils.shaHex(param);
                WeixinShare weixinShare = new WeixinShare();
                weixinShare.setNoncestr(noncestr);
                weixinShare.setTimestamp(timestamp);
                weixinShare.setSignature(signature);
                stringObjectHashMap.put("weixinShare",weixinShare);
                stringObjectHashMap.put("appid",appid);
            } catch (Exception e) {
                e.printStackTrace();
                stringObjectHashMap.put("errorMessage","服务器异常！");
            }
        }
       return  JsonUtil.toJson(stringObjectHashMap);
    }
    private static String byteToHex(final byte[] hash) {
        Formatter formatter = new Formatter();
        for (byte b : hash)
        {
            formatter.format("%02x", b);
        }
        String result = formatter.toString();
        formatter.close();
        return result;
    }
}
