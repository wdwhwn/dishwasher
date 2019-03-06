package com.jingzhun.service;

import com.jingzhun.dao.DeviceDao;
import com.jingzhun.dao.RatioDao;
import com.jingzhun.dao.ScoreItemDao;
import com.jingzhun.dao.VipDao;
import com.jingzhun.entity.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

/**
 * Created by Administrator on 2019/2/27 0027.
 */
@Service
@Transactional
public class VipServiceImpl implements VipService {
    @Autowired
    private VipDao vipDao;
    @Autowired
    private RatioDao ratioDao;
    @Autowired
    private UserService userService;
    @Autowired
    private DeviceDao deviceDao;
    @Autowired
    private ScoreItemDao scoreItemDao;
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
    //    积分兑换
    @Override
    public String scoreExchange(Integer userId, Integer vipId,Integer deviceId) {
//        更改用户积分信息
        Vip vip = vipDao.selectByPrimaryKey(vipId);
        BigDecimal vipScore = vip.getVipScore();
        Integer vipTerm = vip.getVipTerm();
        User user = userService.selectByPrimaryKey(userId);
        BigDecimal userConsumeScore = user.getUserConsumeScore();
        BigDecimal add = userConsumeScore.add(vipScore);
        user.setUserConsumeScore(add);
        BigDecimal userCurrentScore = user.getUserCurrentScore();
        BigDecimal subtract = userCurrentScore.subtract(vipScore);
        user.setUserCurrentScore(subtract);
        userService.updateByPrimaryKey(user);


//        更改设备本次激活时间  下次到期时间
        Device device = deviceDao.selectByPrimaryKey(deviceId);
        Date date = new Date();
//        获取上一次激活时间 用于计算下次到期时间
        Date deviceExpireDate = device.getDeviceExpireDate();
//        获取最终时间  验证vip是否冲过了
        Date deviceEndDate = device.getDeviceEndDate();
        int monthExpire=deviceExpireDate.getMonth();
        int yearExpire = deviceExpireDate.getYear();
        int monthEnd = deviceEndDate.getMonth();
        int yearEnd = deviceEndDate.getYear();
        if(vipTerm==30){
            int i = (yearEnd - yearExpire) * 12;
            int z=monthEnd+i;
            int month=monthExpire+1;
            if(month>=z){
               return "选择的卡片超过了需要续费的期限，请选择低版本的卡片";
            }
            if(month<=12) {
                deviceExpireDate.setMonth(month);
            }else{
                deviceExpireDate.setMonth(month-12);
                deviceExpireDate.setYear(yearExpire+1);
            }


        }else if(vipTerm==90){
            int i = (yearEnd - yearExpire) * 12;
            int z=monthEnd+i;
            int month=monthExpire+3;
            if(month>=z){
                return "选择的卡片超过了需要续费的期限，请选择低版本的卡片";
            }
            if(month<=12) {
                deviceExpireDate.setMonth(month);
            }else{
                deviceExpireDate.setMonth(month-12);
                deviceExpireDate.setYear(yearExpire+1);
            }
        }else {
            int i = (yearEnd - yearExpire) * 12;
            int z=monthEnd+i;
            int month=monthExpire+12;
            if(month>=z){
                return "选择的卡片超过了需要续费的期限，请选择低版本的卡片";
            }

                deviceExpireDate.setMonth(monthExpire);
                deviceExpireDate.setYear(yearExpire+1);

        }
        device.setDeviceRenewDate(date);
        device.setDeviceExpireDate(deviceExpireDate);
        deviceDao.updateByPrimaryKey(device);

//        记录用户积分的改变
        ScoreItem scoreItem = new ScoreItem();
        scoreItem.setScoreItemUserId(userId);
        scoreItem.setScoreItemType("客户续费洗碗机直接返积分");
        scoreItem.setScoreItemDate(date);
        scoreItem.setScoreItemScore(vipScore);

        scoreItemDao.insert(scoreItem);
        return "续费成功";
    }

}
