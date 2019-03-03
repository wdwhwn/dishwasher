package com.jingzhun;

import com.jingzhun.common.msg.Msg;
import com.jingzhun.utils.idrandom.RandomNumber;
import com.jingzhun.utils.jedisUtil.JedisUtil;
import com.jingzhun.utils.jsonutil.JsonUtil;
import com.jingzhun.utils.properties.PropertiesUtil;
import com.jingzhun.utils.token.JwtUtil;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.junit.Test;

import javax.servlet.ServletException;
import java.io.FileNotFoundException;
import java.util.Date;

/**
 * Created by Administrator on 2019/3/1 0001.
 */
public class TestB {
    @Test
    public void test(){

        String card = RandomNumber.getCard();
        System.out.println(card);
    }
    @Test
    public void test1(){
//        JedisUtil.getJedis().set("456","123");
        String s = JedisUtil.getJedis().get("13781981469");
        System.out.println(s);

//        String s = JedisUtil.getJedis().get(JsonUtil.toJson("13781981469"));
//        System.out.println(JsonUtil.toObject(s,String.class));
    }
    @Test
    public void test2() throws ServletException {
//        String wd = JwtUtil.getToken("wd");
//        System.out.println(nn);
//        System.out.println(wd);
        Claims claims = JwtUtil.checkToken("eyJhbGciOiJIUzI1NiJ9.eyJzdWIiOiJ3ZCIsInJvbGVzIjoidXNlciIsImlhdCI6MTU1MTUyOTU5MiwiZXhwIjoxNTUxNTMwMTkyfQ.UQIVKs_y3_DO3KvDeqNUUAlF9bihMkvF_jMWjxVbe1c");

        System.out.println(claims.getSubject());
    }
    @Test
    public void test3() throws FileNotFoundException {
        String urlName = PropertiesUtil.readValue("main.properties", "urlName");
        System.out.println(urlName);

    }
}
