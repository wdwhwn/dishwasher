package com.jingzhun.service;
import com.jingzhun.dao.AddressDao;
import com.jingzhun.dao.GoodsDao;
import com.jingzhun.dao.OrderDao;
import com.jingzhun.dao.UserDao;
import com.jingzhun.entity.*;
import com.jingzhun.utils.properties.PropertiesUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.io.FileNotFoundException;
import java.math.BigDecimal;
import java.util.UUID;

/**
 * Created by Administrator on 2019/3/5 0005.
 */
@Service
@Transactional(rollbackFor = Exception.class)
@Slf4j
public class OrderServiceImpl implements  OrderService {
    @Autowired
    private GoodsDao goodsDao;
    @Autowired
    private AddressDao addressDao;
    @Autowired
    private OrderDao orderDao;
    @Autowired
    private UserDao userDao;
//    确认商品订单
    @Override
    public Goods selectByGoodsId(Integer goodsId) throws FileNotFoundException {
        Goods goods = goodsDao.selectByGoodsId(goodsId);
        String urlName = PropertiesUtil.readValue("main.properties", "urlName");
        String url = PropertiesUtil.readValue("url.properties", urlName);
        GoodsImg goodsImg = goods.getGoodsImgList().get(0);
        String imgUrl=url+goodsImg.getGoodsImgImg();
        goodsImg.setGoodsImgImg(imgUrl);
        goods.getGoodsImgList().set(0,goodsImg);
        System.out.println("123456");
        return goods;
    }
    //  确认收货人信息1
    @Override
    public Address addressCheck1(Integer userId) {
        Address address = addressDao.selectByDefault(userId);
        return address;
    }
    //  确认收货人信息2
    @Override
    public Address addressCheck2(Integer userId,Integer addressId) {
        Address address = addressDao.selectByAddressId(userId,addressId);
        return address;
    }

    @Override
    public String insertOrder(Order order) {
//        判断积分是否充足
        Integer orderUserId = order.getOrderUserId();
        User user = userDao.selectByPrimaryKey(orderUserId);
        BigDecimal userCurrentScore = user.getUserCurrentScore();
        int i = userCurrentScore.compareTo(order.getOrderTotalPrice());
        if(i<0){
            return "积分余额不足";
        }
        String orderSn = UUID.randomUUID().toString().replace("-", "");
        order.setOrderSn(orderSn);
        orderDao.insertOrder(order);
        BigDecimal orderTotalPrice = order.getOrderTotalPrice();
        BigDecimal subtract = userCurrentScore.subtract(orderTotalPrice);
        BigDecimal userConsumeScore = user.getUserConsumeScore();
        BigDecimal add = userConsumeScore.add(orderTotalPrice);
        user.setUserCurrentScore(subtract);
        user.setUserConsumeScore(add);
        userDao.insert(user);
        return "订单提交成功";
    }


    @Override
    public Order selectOrderToPay(Integer orderId) {
        Order order = orderDao.selectOrderToPay(orderId);
        return order;
    }

    @Override
    public Order selectOrderByOrderSn(Integer orderSn) {
        Order order = orderDao.selectOrderByOrderSn(orderSn);
        return order;
    }

    @Override
    public void updateOrder(Order order) {
        orderDao.updateByPrimaryKey(order);
    }


}
