package com.jingzhun.controller;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.jingzhun.entity.User;
import com.jingzhun.service.UserTeamService;
import com.jingzhun.utils.jsonutil.JsonUtil;
import com.jingzhun.utils.properties.PropertiesUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.io.FileNotFoundException;
import java.util.List;

/**
 * Created by Administrator on 2019/2/27 0027.
 */
@RestController
@CrossOrigin(origins = "*",maxAge = 3600)
public class UserTeamController {
    @Autowired
    private UserTeamService userTeamService;
    @RequestMapping("/selectByUserTeam")
    public String selectByUserTeam(Integer userId,Integer pageNum,Integer pageSize) throws FileNotFoundException {
        PageHelper.startPage(pageNum, pageSize);
        List<User> userList = userTeamService.selectByUserTeam(userId);
        for(User user:userList){
            String userWxImg = user.getUserWxImg();
            String urlName = PropertiesUtil.readValue("main.properties", "urlName");
            String url = PropertiesUtil.readValue("url.properties", urlName);
             user.setUserWxImg(url+userWxImg);
        }
        PageInfo<User> userPageInfo = new PageInfo<User>(userList);
        return JsonUtil.toJson(userPageInfo);
    }

}
