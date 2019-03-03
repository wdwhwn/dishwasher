package com.jingzhun.dao;

import com.jingzhun.entity.Goods;
import java.util.List;

public interface GoodsDao {
    int deleteByPrimaryKey(Integer goodsId);

    int insert(Goods record);

    Goods selectByPrimaryKey(Integer goodsId);

    List<Goods> selectAll();

    int updateByPrimaryKey(Goods record);
}