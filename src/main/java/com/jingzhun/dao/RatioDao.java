package com.jingzhun.dao;

import com.jingzhun.entity.Ratio;
import java.util.List;
/**
 * @author wd
 */
public interface RatioDao {
    /*int deleteByPrimaryKey(Integer ratioId);

    int insert(Ratio record);

    Ratio selectByPrimaryKey(Integer ratioId);

    List<Ratio> selectAll();

    int updateByPrimaryKey(Ratio record);*/

    /**
     *获取积分和金钱的比例
     * @return  Ratio
     */
    Ratio selectOne();
}