package com.jingzhun.service;

import com.jingzhun.dao.GoodsDao;
import com.jingzhun.entity.Goods;
import com.jingzhun.entity.GoodsImg;
import com.jingzhun.utils.properties.PropertiesUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.FileNotFoundException;
import java.math.BigDecimal;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by Administrator on 2019/2/27 0027.
 * 商品详情页
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

    @Override
    public Map<String, Object> selectAllById(Integer goodsImgGoodsId) throws FileNotFoundException {
        HashMap<String,Object> hashMap = new HashMap<>();
        Goods goods = goodsDao.selectById(goodsImgGoodsId);
        BigDecimal goodsCurrnetScore = goods.getGoodsCurrnetScore();
        BigDecimal bigDecimal = new BigDecimal("10");
        BigDecimal divide = goodsCurrnetScore.divide(bigDecimal);
        String goodsDescribe = goods.getGoodsDescribe();
        String urlName = PropertiesUtil.readValue("main.properties", "urlName");
        String url = PropertiesUtil.readValue("url.properties", urlName);
        goodsDescribe=url+goodsDescribe;
        goods.setGoodsDescribe(goodsDescribe);
        List<GoodsImg> goodsImgList = goods.getGoodsImgList();
        for(GoodsImg goodsImg:goodsImgList){
            String goodsImgImg = goodsImg.getGoodsImgImg();
            goodsImgImg=url+goodsImgImg;
            goodsImg.setGoodsImgImg(goodsImgImg);
        }
        System.out.println("123");
        hashMap.put("goods",goods);
        return hashMap;
    }


}
