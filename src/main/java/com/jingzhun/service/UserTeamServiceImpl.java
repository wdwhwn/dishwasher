package com.jingzhun.service;

import com.jingzhun.dao.UserDao;
import com.jingzhun.entity.User;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by Administrator on 2019/2/27 0027.
 */
@Service
@Transactional(rollbackFor = Exception.class)
@Slf4j
public class UserTeamServiceImpl implements UserTeamService {
    @Autowired
    private UserDao userDao;
    @Override
    public List<User> selectByUserTeam(Integer userId) {
        List<User> userList = userDao.selectByPid(userId);

        return userList;
    }
}
