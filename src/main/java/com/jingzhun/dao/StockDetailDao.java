package com.jingzhun.dao;

import com.jingzhun.entity.StockDetail;
import java.util.List;

public interface StockDetailDao {
   /* int deleteByPrimaryKey(Integer stockDetailId);

    StockDetail selectByPrimaryKey(Integer stockDetailId);

    List<StockDetail> selectAll();

    int updateByPrimaryKey(StockDetail record);*/
//      添加测试数据
    int insert(StockDetail record);
//    查询全部
    List<StockDetail> selectAll();
//  出货
    int selectOne(Integer stockDetailId);
}