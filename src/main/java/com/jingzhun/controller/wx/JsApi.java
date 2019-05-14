package com.jingzhun.controller.wx;


import com.jingzhun.utils.jsonutil.JsonUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.*;

import static com.jingzhun.controller.wx.WxSignature.SHA1;

/**
 * 不能用，没有提供jsapi_ticket
 * Created by Administrator on 2019/5/13 0013.
 */

public class JsApi {
    // 微信appid 1
    String appid = "wx778f313eff0f980b";
    /**
     *获取JSSDK签名
     *url:当前页面的完整URL，包括参数
     **/

    public String getJsApiConfig(String url){
        String jsapi_ticket = "获取jsapi_ticket";
        String noncestr = UUID.randomUUID().toString().replace("-", "");
        String timestamp = "" + System.currentTimeMillis() / 1000;
        Map<String, String> params = new HashMap<String, String>();
        params.put("jsapi_ticket", jsapi_ticket);
        params.put("noncestr", noncestr);
        params.put("timestamp", timestamp);
        params.put("url", url);
        //1.1 对所有待签名参数按照字段名的ASCII 码从小到大排序（字典序）
        Map<String, String> sortParams = sortAsc(params);
        //1.2 使用URL键值对的格式拼接成字符串
        String str = mapJoin(sortParams, false);
//        String signature = new SHA().enc(str);
        String signature=SHA1(str);
        Map<String, String> result = new HashMap<String,String>();
        result.put("debug", "true");
        result.put("appId", appid);
        result.put("nonceStr", noncestr);
        result.put("timestamp", timestamp);
        result.put("signature", signature);
        return JsonUtil.toJson(result);
    }


    private HashMap<String, String> sortAsc(Map<String, String> map) {
        HashMap<String, String> tempMap = new LinkedHashMap<String, String>();
        List<Map.Entry<String, String>> infoIds = new ArrayList<Map.Entry<String, String>>(map.entrySet());
        //排序
        Collections.sort(infoIds, new Comparator<Map.Entry<String, String>>() {
            @Override
            public int compare(Map.Entry<String, String> o1, Map.Entry<String, String> o2) {
                return o1.getKey().compareTo(o2.getKey());
            }
        });

        for (int i = 0; i < infoIds.size(); i++) {
            Map.Entry<String, String> item = infoIds.get(i);
            tempMap.put(item.getKey(), item.getValue());
        }
        return tempMap;
    }


    public static String mapJoin(Map<String, String> map, boolean valueUrlEncode) {
        StringBuilder sb = new StringBuilder();
        for (String key : map.keySet()) {
            if (map.get(key) != null && !"".equals(map.get(key))) {
                try {
                    String temp = (key.endsWith("_") && key.length() > 1) ? key.substring(0, key.length() - 1) : key;
                    sb.append(temp);
                    sb.append("=");
                    //获取到map的值
                    String value = map.get(key);
                    //判断是否需要url编码
                    if (valueUrlEncode) {
                        value = URLEncoder.encode(map.get(key), "utf-8").replace("+", "%20");
                    }
                    sb.append(value);
                    sb.append("&");
                } catch (UnsupportedEncodingException e) {
                    e.printStackTrace();
                }
            }
        }
        if (sb.length() > 0) {
            sb.deleteCharAt(sb.length() - 1);
        }
        return sb.toString();
    }
}
