package com.jingzhun.service;

import com.jingzhun.dao.AccountDao;
import com.jingzhun.dao.ScoreItemDao;
import com.jingzhun.entity.Account;
import com.jingzhun.entity.Cash;
import com.jingzhun.entity.ScoreItem;
import com.jingzhun.entity.User;
import com.jingzhun.utils.bigdecimal.Arith;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CachePut;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

/**
 * Created by Administrator on 2019/3/4 0004.
 */
@Service
@Transactional(rollbackFor = Exception.class)
@Slf4j
public class AccountServiceImpl implements AccountService {
    @Autowired
    private AccountDao accountDao;
    @Autowired
    private UserService userService;
    @Autowired
    private  CashRecordService cashRecordService;
    @Autowired
    private ScoreItemDao scoreItemDao;
    @Override
    public void insert(Account account) {
        accountDao.insert(account);
    }
//提现
    @Override
    public void cash(Integer accountId, Integer userId, Double money) {
        User user = userService.selectByPrimaryKey(userId);
//        提现的积分
        double mul = Arith.mul(money, 10);
        BigDecimal bigDecimal = new BigDecimal(mul);
//      当前积分
        BigDecimal userCurrentScore = user.getUserCurrentScore();
        BigDecimal subtract = userCurrentScore.subtract(bigDecimal);
        user.setUserCurrentScore(subtract);
//        更新数据
        userService.updateByPrimaryKey(user);
//        调用wx接口 提现
//        本地记录提现状态
        Date date = new Date();
        Cash cash = new Cash();
        cash.setCashScore(bigDecimal);
        cash.setCashAccountId(accountId);
        cash.setCashDate(date);
        cash.setCashUserId(userId);
        cashRecordService.insert(cash);
//        积分明细表 记录 积分的改变
        ScoreItem scoreItem = new ScoreItem();
        scoreItem.setScoreItemDate(date);
        scoreItem.setScoreItemScore(bigDecimal);
        scoreItem.setScoreItemType("1");
        scoreItem.setScoreItemUserId(userId);
        scoreItemDao.insert(scoreItem);
    }

    @Override
    public void delete(Account account) {
        accountDao.delete(account.getAccountId());
    }

    @Override
    public void update(Account account) {
        accountDao.update(account);
    }

    @Override
    public List<Account> selectAll(Integer accountUserId) {
        List<Account> accountList = accountDao.selectAll(accountUserId);
        return accountList;
    }
}
