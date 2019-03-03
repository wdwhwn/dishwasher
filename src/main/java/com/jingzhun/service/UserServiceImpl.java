package com.jingzhun.service;

import com.jingzhun.dao.UserDao;
import com.jingzhun.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * Created by Administrator on 2019/3/1 0001.
 */
@Service
@Transactional
public class UserServiceImpl implements UserService {
    @Autowired
    private UserDao userDao;
    @Override
    public void insert(User user) {
            userDao.insert(user);
    }
}
