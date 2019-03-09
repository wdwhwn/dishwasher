package com.jingzhun.dao;

import com.jingzhun.entity.Img;
import java.util.List;
/**
 * @author wd
 */
public interface ImgDao {
    /*int deleteByPrimaryKey(Integer imgId);

    int insert(Img record);

    Img selectByPrimaryKey(Integer imgId);


    int updateByPrimaryKey(Img record);*/

    /**
     *  首页轮播图
     * @return List<Img>
     */
    List<Img> selectAll();
}