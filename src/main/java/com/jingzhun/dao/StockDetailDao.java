package com.jingzhun.dao;

import com.jingzhun.entity.StockDetail;
import org.apache.ibatis.annotations.Param;

import java.util.List;
/**
 * @author wd
 */
public interface StockDetailDao {
   /* int deleteByPrimaryKey(Integer stockDetailId);

    StockDetail selectByPrimaryKey(Integer stockDetailId);

    List<StockDetail> selectAll();

    int updateByPrimaryKey(StockDetail record);*/
    /**
     *  添加测试数据
     * @param record  洗碗机
     * @return
     */
    void insert(StockDetail record);

    /**
     * 查询全部
     * @return  List<StockDetail>
     */
    List<StockDetail> selectAll();

    /**
     * 出货
     * @param stockDetailId  洗碗机类型Id
     * @return int 洗碗机id
     */
    int selectOne(Integer stockDetailId);

    /**
     *  根据id 查询  设备号 设备类型信息
     * @param stockDetailId  洗碗机Id
     * @param stockDetailDeviceNumber  洗碗机设备号
     * @return StockDetail
     */
    StockDetail selectByStockDetailId(@Param("stockDetailId") Integer stockDetailId,@Param("stockDetailDeviceNumber") Integer stockDetailDeviceNumber);

    /**
     *  更新 二维码
     * @param stockDetail 洗碗机对象
     */
    void updateByPrimaryKey(StockDetail stockDetail);
}