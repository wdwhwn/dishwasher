package com.jingzhun.service;

import com.jingzhun.entity.User;

/**
 * Created by Administrator on 2019/3/1 0001.
 */
public interface UserService {
    public boolean insert(User user);
    User selectByPrimaryKey(Integer userId);
    void updateByPrimaryKey(User user);
}
