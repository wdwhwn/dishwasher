package com.jingzhun.dao;

import com.jingzhun.entity.User;
import java.util.List;
/**
 * @author wd
 */
public interface UserDao {
    /*int deleteByPrimaryKey(Integer userId);
    User selectByPrimaryKey(Integer userId);
    List<User> selectAll();

    int updateByPrimaryKey(User record);*/

    /**
     *个人中心页面：总积分、当前积分、消费积分、微信昵称、微信头像
     * @param userId  用户id
     * @return User
     */
    User selectByPrimaryKey(Integer userId);

    /**
     * 提现页面：当前积分、账号
     * @param userId   用户id
     * @return List<User>
     */
    List<User> selectByCashPage(Integer userId);

    /**
     *  积分页面: 当前积分、消费积分、总积分
     * @param userId 用户id
     * @return User
     */
    User selectByCashSummary(Integer userId);

    /**
     * 我的团友列表
     * @param userId 用户id
     * @return List<User>
     */
    List<User> selectByPid(Integer userId);

    /**
     *  短信验证通过   即添加用户信息
     * @param record  微信授权信息
     */
    void insert(User record);

    /**
     *  查询所有用户
     * @return  List<User>
     */
    List<User> selectAll();
    /**
     *  提现  更新积分
     * @param record 用户对象
     */
    void updateByPrimaryKey(User record);
}