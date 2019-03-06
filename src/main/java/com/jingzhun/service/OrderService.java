package com.jingzhun.service;

import com.jingzhun.entity.Address;
import com.jingzhun.entity.Goods;
import com.jingzhun.entity.Order;

import java.io.FileNotFoundException;

/**
 * Created by Administrator on 2019/3/5 0005.
 */

public interface OrderService {
    public Goods selectByGoodsId(Integer goodsId) throws FileNotFoundException;
    public Address addressCheck1(Integer userId);
    public Address addressCheck2(Integer userId,Integer addressId);
    public String insertOrder(Order order);
}
