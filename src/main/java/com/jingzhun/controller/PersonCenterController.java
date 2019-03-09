package com.jingzhun.controller;

import com.jingzhun.dao.UserDao;
import com.jingzhun.entity.User;
import com.jingzhun.utils.jsonutil.JsonUtil;
import com.jingzhun.utils.properties.PropertiesUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.io.FileNotFoundException;
import java.math.BigDecimal;
import java.util.HashMap;

/**
 * @author 王丹
 * Created by Administrator on 2019/2/27 0027.
 */
@RestController
@CrossOrigin(origins = "*",maxAge = 3600)
@Slf4j
public class PersonCenterController {
    @Autowired
    private UserDao userDao;
    @RequestMapping("/selectByScore")
    public String selectByScore(Integer userId) throws FileNotFoundException {
        HashMap<String,Object> map=new HashMap<String, Object>(3);
        User user = userDao.selectByPrimaryKey(userId);
        log.error("对象",user);
//        拼接路径
        String userImg = user.getUserWxImg();
        log.error(userImg);
        String urlName = PropertiesUtil.readValue("main.properties", "urlName");
        String userImgUrl = PropertiesUtil.readValue("url.properties", urlName)+userImg;

        user.setUserWxImg(userImgUrl);

        map.put("user",user);
        return JsonUtil.toJson(map);
    }
}
