package com.jingzhun.dao;

import com.jingzhun.entity.StockDetail;
import org.apache.ibatis.annotations.Param;

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
// 根据id 查询  设备号 设备类型信息
    StockDetail selectByStockDetailId(@Param("stockDetailId") Integer stockDetailId,@Param("stockDetailDeviceNumber") Integer stockDetailDeviceNumber);
//  更新 二维码
    void updateByPrimaryKey(StockDetail stockDetail);
}