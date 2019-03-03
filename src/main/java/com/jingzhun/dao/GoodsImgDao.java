package com.jingzhun.dao;

import com.jingzhun.entity.GoodsImg;
import java.util.List;

public interface GoodsImgDao {
    int deleteByPrimaryKey(Integer goodsImgId);

    int insert(GoodsImg record);

    GoodsImg selectByPrimaryKey(Integer goodsImgId);

    List<GoodsImg> selectAll();

    int updateByPrimaryKey(GoodsImg record);
}