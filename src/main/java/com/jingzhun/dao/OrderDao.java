package com.jingzhun.dao;

import com.jingzhun.entity.Order;
import org.apache.ibatis.annotations.Param;

import java.util.List;
/**
 * @author wd
 */
public interface OrderDao {
    /*int deleteByPrimaryKey(Integer orderId);

    Order selectByPrimaryKey(Integer orderId);

    List<Order> selectAll();

    int updateByPrimaryKey(Order record);*/

    /**
     * 提交订单
     * @param record  订单对象
     *
     */
    void insertOrder(Order record);

    Order selectOrderToPay(Integer orderId);

    void updateByPrimaryKey(Order order);

    Order selectOrderByOrderSn(Integer orderSn);
}