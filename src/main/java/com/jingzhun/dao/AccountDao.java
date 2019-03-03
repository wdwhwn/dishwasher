package com.jingzhun.dao;

import com.jingzhun.entity.Account;
import java.util.List;

public interface AccountDao {
    int deleteByPrimaryKey(Integer accountId);

    int insert(Account record);

    Account selectByPrimaryKey(Integer accountId);

    List<Account> selectAll();

    int updateByPrimaryKey(Account record);
}