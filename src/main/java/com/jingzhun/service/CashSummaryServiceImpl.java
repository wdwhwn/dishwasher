package com.jingzhun.service;

import com.jingzhun.dao.UserDao;
import com.jingzhun.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * Created by Administrator on 2019/2/27 0027.
 */
@Service
@Transactional
public class CashSummaryServiceImpl implements CashSummaryService {
    @Autowired
    private UserDao userDao;
    @Override
    public User selectByCashSummary(Integer userId) {
        User user = userDao.selectByCashSummary(userId);
        return user;
    }
}
