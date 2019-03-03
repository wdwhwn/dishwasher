package com.jingzhun.controller;

import com.jingzhun.dao.UserDao;
import com.jingzhun.entity.User;
import com.jingzhun.utils.jsonutil.JsonUtil;
import com.jingzhun.utils.properties.PropertiesUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.io.FileNotFoundException;
import java.math.BigDecimal;
import java.util.HashMap;

/**
 * Created by Administrator on 2019/2/27 0027.
 */
@Controller
@CrossOrigin(origins = "*",maxAge = 3600)
public class PersonCenterController {
    @Autowired
    private UserDao userDao;
    @RequestMapping("/selectByScore")
    @ResponseBody
    public String selectByScore(Integer userId) throws FileNotFoundException {
        HashMap<String,Object> map=new HashMap<String, Object>();
        User user = userDao.selectByPrimaryKey(userId);
//        拼接路径
        String userImg = user.getUserWxImg();
        String urlName = PropertiesUtil.readValue("main.properties", "urlName");
        String userImgUrl = PropertiesUtil.readValue("url.properties", urlName)+userImg;

        user.setUserWxImg(userImgUrl);
//        BigDecimal userCurrentScore = user.getUserCurrentScore();

        map.put("user",user);
        return JsonUtil.toJson(map);
    }
}
