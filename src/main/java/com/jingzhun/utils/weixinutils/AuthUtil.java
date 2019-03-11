package com.jingzhun.utils.weixinutils;

import java.io.IOException;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.util.EntityUtils;

import net.sf.json.JSONObject;

/**
 *
 * 工具类
 * 用来根据接口地址进行网络请求
 * @author wlw
 *
 */
public class AuthUtil {
    public static final String APP_ID = "wx778f313eff0f980b";     //填写自己的APPID
    public static final String APP_SECRET = "910415b15c96d7268cc1ee899f5fc8cd";   //填写自己的APPSECRET
    public static JSONObject doGetJson(String url) throws Exception, IOException {
        JSONObject jsonObject=null;
        //初始化httpClient
        DefaultHttpClient client=new DefaultHttpClient();
        //用Get方式进行提交
        HttpGet httpGet=new HttpGet(url);
        //发送请求
        HttpResponse response= client.execute(httpGet);
        //获取数据
        HttpEntity entity=response.getEntity();
        //格式转换
        if (entity!=null) {
            String result=EntityUtils.toString(entity,"UTF-8");
            jsonObject=JSONObject.fromObject(result);
        }
        //释放链接
        httpGet.releaseConnection();
        return jsonObject;
    }

}
