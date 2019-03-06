package com.jingzhun.dao;

import com.jingzhun.entity.Account;
import java.util.List;

public interface AccountDao {
   /* int deleteByPrimaryKey(Integer accountId);

    Account selectByPrimaryKey(Integer accountId);

    List<Account> selectAll();

    int updateByPrimaryKey(Account record);*/
//  添加用户账号
    int insert(Account record);
}