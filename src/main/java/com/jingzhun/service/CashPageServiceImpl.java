package com.jingzhun.service;

import com.jingzhun.dao.RatioDao;
import com.jingzhun.dao.UserDao;
import com.jingzhun.entity.Ratio;
import com.jingzhun.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by Administrator on 2019/2/27 0027.
 */
@Service
@Transactional
public class CashPageServiceImpl implements CashPageService {
    @Autowired
    private UserDao userDao;
    @Autowired
    private RatioDao ratioDao;


    @Override
    public Map<String,Object> selectByCashPage(Integer userId) {
       Map<String,Object> map=new HashMap<String,Object>();

        List<User> userList = userDao.selectByCashPage(userId);
        User user = userList.get(0);
        BigDecimal userCurrentScore = user.getUserCurrentScore();
//        获取比例
        Ratio ratio = ratioDao.selectOne();
        String ratioRatio = ratio.getRatioRatio();
        BigDecimal bigDecimal = new BigDecimal(ratioRatio);
//          换算为金钱
        BigDecimal divide = userCurrentScore.divide(bigDecimal);
        map.put("userList",userList);
        map.put("userCurrentMoney",divide);
        return map;
    }
}
