package com.jingzhun.controller;

import com.jingzhun.common.enumpackage.OrderEnum;
import com.jingzhun.entity.Address;
import com.jingzhun.entity.Goods;
import com.jingzhun.entity.Order;
import com.jingzhun.service.OrderService;
import com.jingzhun.utils.jsonutil.JsonUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.io.FileNotFoundException;
import java.util.HashMap;

/**
 * @author  王丹
 * Created by Administrator on 2019/3/5 0005.
 */
@RestController
@CrossOrigin(origins = "*",maxAge = 3600)
@Slf4j
public class OrderController {
    @Autowired
    private OrderService orderService;
    /**
     * 确认商品
     * @param goodsId  商品id
     * @return  返回商品信息
     * @throws FileNotFoundException  文件未找到异常
     */
    @RequestMapping("/orderGoodsCheck")
    public String orderGoodsCheck(Integer goodsId) throws FileNotFoundException {
        Goods goods = orderService.selectByGoodsId(goodsId);
        return JsonUtil.toJson(goods);
    }
    /**
     * @title 确认收货地址1--默认收货地址
     * @description  从商品详情进入，显示默认收货地址
     * @param userId  用户id
     * @return  返回地址信息
     */
    @RequestMapping("/orderAddressCheck1")
    public String orderAddressCheck1(Integer userId){
        HashMap<String, Object> objectObjectHashMap = new HashMap<String,Object>(5);
        Address address = orderService.addressCheck1(userId);
        objectObjectHashMap.put("address",address);
        objectObjectHashMap.put("code",1);
        return JsonUtil.toJson(objectObjectHashMap);
    }
    /**
     *@title 确认收货地址2
     *@description  返回收货地址信息
     * @param userId  用户id
     * @param addressId  收货地址id
     * @return  返回收货地址  code=2 表明从收货地址跳转
     */
    @RequestMapping("/orderAddressCheck2")
    public String orderAddressCheck2(Integer userId,Integer addressId){
        HashMap<Object, Object> objectObjectHashMap = new HashMap<Object,Object>(4);
        Address address = orderService.addressCheck2(userId,addressId);
        objectObjectHashMap.put("address",address);
        objectObjectHashMap.put("code",2);
        return JsonUtil.toJson(objectObjectHashMap);
    }
    /**
     *@title 提交订单
     * @param order  订单对象
     * @return  状态信息：成功 or 余额不足
     */
    @RequestMapping("/orderInsert")
    public String orderInsert(Order order){
        HashMap<String,Object> hashMap = new HashMap<String,Object>(3);
        String s = orderService.insertOrder(order);
        if(OrderEnum.Success.getName().equals(s)){
            hashMap.put("message","订单提交成功");
        }else if(OrderEnum.Fail.getName().equals(s)){
            hashMap.put("message","积分余额不足");
        }
        return JsonUtil.toJson(hashMap);
    }
}
