package com.jingzhun.dao;

import com.jingzhun.entity.Img;
import java.util.List;

public interface ImgDao {
    int deleteByPrimaryKey(Integer imgId);

    int insert(Img record);

    Img selectByPrimaryKey(Integer imgId);

    List<Img> selectAll();

    int updateByPrimaryKey(Img record);
}