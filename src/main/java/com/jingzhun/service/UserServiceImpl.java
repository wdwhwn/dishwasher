package com.jingzhun.service;

import com.jingzhun.dao.UserDao;
import com.jingzhun.entity.User;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by Administrator on 2019/3/1 0001.
 */
@Service
@Transactional(rollbackFor = Exception.class)
@Slf4j
public class UserServiceImpl implements UserService {
    @Autowired
    private UserDao userDao;
    @Override
    public boolean insert(User user) {
        String userWxOppenid = user.getUserWxOpenid();
        List<User> userList = userDao.selectAll();
        for(User user1:userList){
            String userWxOppenid1 = user1.getUserWxOpenid();
            if(userWxOppenid1.equals(userWxOppenid)){
                return false;
            }
        }
            userDao.insert(user);
        log.error("授权时添加用户");
            return true;
    }

    @Override
    public User selectByPrimaryKey(Integer userId) {
        User user = userDao.selectByPrimaryKey(userId);
        return user;
    }

    @Override
    public void updateByPrimaryKey(User user) {
        userDao.updateByPrimaryKey(user);
    }
}
