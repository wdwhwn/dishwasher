package com.jingzhun.service;

import com.jingzhun.dao.GoodsDao;
import com.jingzhun.entity.Goods;
import com.jingzhun.entity.GoodsImg;
import com.jingzhun.utils.properties.PropertiesUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by Administrator on 2019/2/27 0027.
 * 首页展示所有商品信息
 * 查询条件为 deleteState为0
 */
@Service
public class GoodsServiceImpl implements GoodsService {
    @Autowired
    private GoodsDao goodsDao;
    @Override
    public List<Goods> selectAll() {
        List<Goods> goodsList = goodsDao.selectAll();

        return goodsList;
    }
}
