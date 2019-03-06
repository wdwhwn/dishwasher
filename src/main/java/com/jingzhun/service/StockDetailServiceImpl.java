package com.jingzhun.service;

import com.jingzhun.dao.StockDetailDao;
import com.jingzhun.entity.StockDetail;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * Created by Administrator on 2019/3/5 0005.
 */
@Service
@Transactional
public class StockDetailServiceImpl implements  StockDetailService{
    @Autowired
    private StockDetailDao stockDetailDao;
    @Override
    public void insert(StockDetail stockDetail) {
        stockDetailDao.insert(stockDetail);
    }
}
