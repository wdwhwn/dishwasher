package com.jingzhun.service;

import com.jingzhun.dao.RatioDao;
import com.jingzhun.entity.Ratio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by Administrator on 2019/5/15 0015.
 */
@Service
public class RatioServiceImpl implements  RatioService {
    @Autowired
    private RatioDao ratioDao;
    @Override
    public Ratio selectOne() {
        Ratio ratio = ratioDao.selectOne();
        return ratio;
    }
}
