package com.jingzhun.controller;

import com.jingzhun.entity.Address;
import com.jingzhun.entity.Goods;
import com.jingzhun.entity.Order;
import com.jingzhun.service.OrderService;
import com.jingzhun.utils.jsonutil.JsonUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.io.FileNotFoundException;
import java.util.HashMap;

/**
 * Created by Administrator on 2019/3/5 0005.
 */
@Controller
@CrossOrigin(origins = "*",maxAge = 3600)
public class OrderController {
    @Autowired
    private OrderService orderService;
//    确认商品
    @RequestMapping("/orderGoodsCheck")
    @ResponseBody
    public String orderGoodsCheck(Integer goodsId) throws FileNotFoundException {
        Goods goods = orderService.selectByGoodsId(goodsId);
        return JsonUtil.toJson(goods);
    }
//   确认收货地址1--默认收货地址
    @RequestMapping("/orderAddressCheck1")
    @ResponseBody
    public String orderAddressCheck1(Integer userId){
        HashMap<String, Object> objectObjectHashMap = new HashMap<>();
        Address address = orderService.addressCheck1(userId);
        objectObjectHashMap.put("address",address);
        objectObjectHashMap.put("code",1);
        objectObjectHashMap.get("address");
        return JsonUtil.toJson(objectObjectHashMap);
    }
    //   确认收货地址2
    @RequestMapping("/orderAddressCheck2")
    @ResponseBody
    public String orderAddressCheck2(Integer userId,Integer addressId){
        HashMap<Object, Object> objectObjectHashMap = new HashMap<>();
        Address address = orderService.addressCheck2(userId,addressId);
        objectObjectHashMap.put("address",address);
        objectObjectHashMap.put("code",2);
        return JsonUtil.toJson(objectObjectHashMap);
    }
//   提交订单
    @RequestMapping("/orderInsert")
    @ResponseBody
    public String orderInsert(Order order){
        HashMap<String,Object> hashMap = new HashMap<>();
        String s = orderService.insertOrder(order);
        if("订单提交成功".equals(s)){
            hashMap.put("message","订单提交成功");
        }else if("积分余额不足".equals(s)){
            hashMap.put("message","积分余额不足");
        }
        return JsonUtil.toJson(hashMap);
    }
}
