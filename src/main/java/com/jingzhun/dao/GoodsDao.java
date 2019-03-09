package com.jingzhun.dao;

import com.jingzhun.entity.Goods;
import java.util.List;
/**
 * @author wd
 */
public interface GoodsDao {

   /* int deleteByPrimaryKey(Integer goodsId);

    int insert(Goods record);

    Goods selectByPrimaryKey(Integer goodsId);

    int updateByPrimaryKey(Goods record);*/

    /**
     * 首页商品展示
     * @return List<Goods>
     */
    List<Goods> selectAll();
    /**
     * 商品详情展示
     * @param goodsImgGoodsId  商品id
     * @return Goods
     */
    Goods selectById(Integer goodsImgGoodsId);

    /**
     *确认订单
     * @param goodsImgGoodsId  商品id
     * @return  Goods
     */
    Goods selectByGoodsId(Integer goodsImgGoodsId);


}