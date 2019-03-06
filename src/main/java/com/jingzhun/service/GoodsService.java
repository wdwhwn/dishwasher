package com.jingzhun.service;

import com.jingzhun.entity.Goods;

import java.io.FileNotFoundException;
import java.util.List;
import java.util.Map;

/**
 * Created by Administrator on 2019/2/27 0027.
 */
public interface GoodsService {
    public List<Goods> selectAll();
    public Map<String, Object> selectAllById(Integer goodsImgGoodsId) throws FileNotFoundException;
}
