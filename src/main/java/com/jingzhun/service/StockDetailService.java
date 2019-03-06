package com.jingzhun.service;

import com.jingzhun.entity.StockDetail;
import org.apache.ibatis.annotations.Param;

/**
 * Created by Administrator on 2019/3/5 0005.
 */
public interface StockDetailService {

    public void insert(StockDetail stockDetail);

    // 根据id 查询  设备号 设备类型信息
    StockDetail selectByStockDetailId( Integer stockDetailId,Integer stockDetailDeviceNumber);


}
