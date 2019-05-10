package com.jingzhun.controller.wx;

import com.jingzhun.utils.jsonutil.JsonUtil;
import org.apache.http.HttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.util.EntityUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.*;

/**
 * Created by Administrator on 2019/5/10 0010.
 */
@RestController
@CrossOrigin(origins = "*",maxAge = 3600)
public class WeiXinSaoYiSao {
    // 微信appid 1
    String appid = "wx778f313eff0f980b";
    // 微信secret
    String secret = "910415b15c96d7268cc1ee899f5fc8cd";
    // 初始化access_token
    String access_token = "jingzhun";
    private static final Logger logger = LoggerFactory.getLogger(WeiXinSaoYiSao.class);
    /**
     * 得到jsApi-ticket
     * @return
     */
    @Autowired
    private HttpServletRequest request;

    @Autowired
    private HttpServletResponse response;

    private String getJsapiTicket(){
//        HttpServletRequest request = ServletActionContext.getRequest();
        String code = request.getParameter("code");
        String requestUrl = "https://api.weixin.qq.com/cgi-bin/token?";
        String params = "grant_type=client_credential&appid=" + appid + "&secret=" + secret + "";
        String result = httpGet(requestUrl+params);
        String accessToken = com.alibaba.fastjson.JSONObject.parseObject(result).getString("access_token");

        requestUrl = "https://api.weixin.qq.com/cgi-bin/ticket/getticket?";
        params = "access_token=" + accessToken + "&type=jsapi";
        result = httpGet(requestUrl+params);
        String jsapi_ticket = com.alibaba.fastjson.JSONObject.parseObject(result).getString("ticket");
        return jsapi_ticket;
    }

    /**
     * 获取sign签名
     * @return
     */
    @RequestMapping("/sign")
    public String sign() {
//        HttpServletRequest request = ServletActionContext.getRequest();
        Map ret = new HashMap();
        String url = request.getParameter("url");
        String jsapi_ticket= getJsapiTicket();
        String nonce_str = create_nonce_str();
        String timestamp = create_timestamp();
        String string1;
        String signature = "";
        int length=url.indexOf("#");
        String uri = url;
        if(length > 0){
            uri=url.substring(0,length);//当前网页的URL，不包含#及其后面部分
        }
        //注意这里参数名必须全部小写，且必须有序
        string1 = "jsapi_ticket=" + jsapi_ticket +
                "&noncestr=" + nonce_str +
                "&timestamp=" + timestamp +
                "&url=" + url;
//        System.out.println(string1);
        try
        {
            MessageDigest crypt = MessageDigest.getInstance("SHA-1");
            crypt.reset();
            crypt.update(string1.getBytes("UTF-8"));
            signature = byteToHex(crypt.digest());
        }
        catch (NoSuchAlgorithmException e)
        {
            e.printStackTrace();
        }
        catch (UnsupportedEncodingException e)
        {
            e.printStackTrace();
        }
        ret.put("appId", appid);
        ret.put("url", uri);
        ret.put("jsapi_ticket", jsapi_ticket);
        ret.put("nonceStr", nonce_str);
        ret.put("timestamp", timestamp);
        ret.put("signature", signature);
//        System.out.println(signature);
        Set set = ret.keySet();
        for(Object s:set){
            System.out.println(s+"+++"+ret.get(s));
        }
        return JsonUtil.toJson(ret);
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
    private static String create_nonce_str() {
        return UUID.randomUUID().toString();
    }
    private static String create_timestamp() {
        return Long.toString(System.currentTimeMillis() / 1000);
    }
    /**
     * 发送get请求
     * @param url    路径
     * @return
     */
    public static String httpGet(String url){
        //get请求返回结果
        String strResult = null;
        try {
            DefaultHttpClient client = new DefaultHttpClient();
            //发送get请求
            HttpGet request = new HttpGet(url);
            HttpResponse response = client.execute(request);

            /**请求发送成功，并得到响应**/
            if (response.getStatusLine().getStatusCode() == org.apache.http.HttpStatus.SC_OK) {
                /**读取服务器返回过来的json字符串数据**/
                strResult = EntityUtils.toString(response.getEntity());
            } else {
                logger.error("get请求提交失败:" + url);
            }
        } catch (IOException e) {
            logger.error("get请求提交失败:" + url, e);
        }
        return strResult;
    }

}
