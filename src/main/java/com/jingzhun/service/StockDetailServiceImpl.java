package com.jingzhun.service;
import com.jingzhun.dao.StockDetailDao;
import com.jingzhun.entity.StockDetail;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * Created by Administrator on 2019/3/5 0005.
 */

@Service
@Transactional(rollbackFor = Exception.class)
@Slf4j
public class StockDetailServiceImpl implements  StockDetailService{
    @Autowired
    private StockDetailDao stockDetailDao;
    @Override
    public void insert(StockDetail stockDetail) {
        stockDetailDao.insert(stockDetail);
    }

    @Override
    public StockDetail selectByStockDetailId(Integer stockDetailId, Integer stockDetailDeviceNumber) {
        StockDetail stockDetail = stockDetailDao.selectByStockDetailId(stockDetailId, stockDetailDeviceNumber);

       return stockDetail;
    }

//
}
