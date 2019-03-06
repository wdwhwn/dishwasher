package com.jingzhun.dao;

import com.jingzhun.entity.Order;
import java.util.List;

public interface OrderDao {
    /*int deleteByPrimaryKey(Integer orderId);

    Order selectByPrimaryKey(Integer orderId);

    List<Order> selectAll();

    int updateByPrimaryKey(Order record);*/

    int insertOrder(Order record);
}