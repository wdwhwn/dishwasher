package com.jingzhun.service;

import com.jingzhun.dao.CashDao;
import com.jingzhun.dao.RatioDao;
import com.jingzhun.entity.Cash;
import com.jingzhun.entity.Ratio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.util.List;

/**
 * Created by Administrator on 2019/2/27 0027.
 */
@Service
@Transactional
public class CashRecordServiceImpl implements CashRecordService {
    @Autowired
    private CashDao cashDao;

    @Autowired
    private RatioDao ratioDao;
    @Override
    public List<Cash> selectByCashRecord(Integer userId) {
        List<Cash> cashList = cashDao.selectByCashRecord(userId);
        System.out.println(cashList);
        Ratio ratio = ratioDao.selectOne();
        String ratioRatio = ratio.getRatioRatio();
        BigDecimal bigDecimal = new BigDecimal(ratioRatio);

        for(Cash cash:cashList){
            BigDecimal cashScore = cash.getCashScore();
            BigDecimal divide = cashScore.divide(bigDecimal);
            cash.setCashScore(divide);
        }
        return cashList;
    }

    @Override
    public void insert(Cash cash) {
         cashDao.insert(cash);
    }
}
