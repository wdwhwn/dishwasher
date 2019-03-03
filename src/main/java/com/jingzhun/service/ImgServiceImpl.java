package com.jingzhun.service;

import com.jingzhun.dao.ImgDao;
import com.jingzhun.entity.Img;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by Administrator on 2019/2/27 0027.
 *获取首页轮播图list
 * 查询条件为deleteState为0
 */
@Service
public class ImgServiceImpl implements ImgService {
    @Autowired
    private ImgDao imgDao;
    @Override
    public List<Img> selectAll() {
        List<Img> imgList = imgDao.selectAll();
        return imgList;
    }
}
