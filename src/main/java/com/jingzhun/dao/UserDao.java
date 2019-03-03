package com.jingzhun.dao;

import com.jingzhun.entity.User;
import java.util.List;

public interface UserDao {
    /*int deleteByPrimaryKey(Integer userId);



    User selectByPrimaryKey(Integer userId);

    List<User> selectAll();

    int updateByPrimaryKey(User record);*/

    //个人中心页面
    User selectByPrimaryKey(Integer userId);

    //提现页面
    List<User> selectByCashPage(Integer userId);

    //积分页面
    User selectByCashSummary(Integer UserId);
    //    我的团友列表
    List<User> selectByPid(Integer userId);

//    短信验证通过   即添加用户信息
    void insert(User record);
}