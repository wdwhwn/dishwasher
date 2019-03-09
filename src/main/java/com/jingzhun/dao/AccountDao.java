package com.jingzhun.dao;

import com.jingzhun.entity.Account;

/**
 * @author wd
 */
public interface AccountDao {
   /* int deleteByPrimaryKey(Integer accountId);

    Account selectByPrimaryKey(Integer accountId);

    List<Account> selectAll();

    int updateByPrimaryKey(Account record);*/
//  添加用户账号

    /**
     * 添加用户账号
     * @param record  账户对象
     *
     */
    void insert(Account record);
}