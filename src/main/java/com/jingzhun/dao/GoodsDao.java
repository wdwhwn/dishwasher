package com.jingzhun.dao;

import com.jingzhun.entity.Goods;
import java.util.List;

public interface GoodsDao {
    int deleteByPrimaryKey(Integer goodsId);

    int insert(Goods record);

    Goods selectByPrimaryKey(Integer goodsId);

    int updateByPrimaryKey(Goods record);
//   首页商品展示
    List<Goods> selectAll();
//    商品展示
    Goods selectById(Integer goodsImgGoodsId);

//    确认订单
    Goods selectByGoodsId(Integer goodsImgGoodsId);


}