package com.jingzhun.service;

import com.jingzhun.dao.RatioDao;
import com.jingzhun.dao.VipDao;
import com.jingzhun.entity.Ratio;
import com.jingzhun.entity.Vip;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;

/**
 * Created by Administrator on 2019/2/27 0027.
 */
@Service
public class VipServiceImpl implements VipService {
    @Autowired
    private VipDao vipDao;
    @Autowired
    private RatioDao ratioDao;
    @Override
    public List<Vip> selectAll() {
        List<Vip> vipList = vipDao.selectAll();
        Ratio ratio = ratioDao.selectOne();
        String ratioRatio = ratio.getRatioRatio();
        BigDecimal bigDecimal = new BigDecimal(ratioRatio);

        for(Vip vip:vipList){
            BigDecimal vipScore = vip.getVipScore();
            BigDecimal divide = vipScore.divide(bigDecimal);
            vip.setVipScore(divide);
        }
        return vipList;
    }
}
