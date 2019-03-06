package com.jingzhun.service;

import com.jingzhun.entity.Account;

/**
 * Created by Administrator on 2019/3/4 0004.
 */
public interface AccountService {
    void insert(Account account);
    void cash(Integer accountId,Integer userId,Double money );
}
