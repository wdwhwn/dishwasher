package com.jingzhun.service;

import com.jingzhun.dao.*;
import com.jingzhun.entity.*;
import lombok.extern.slf4j.Slf4j;
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
@Slf4j
public class DeviceServiceImpl implements DeviceService {
    @Autowired
    private DeviceDao deviceDao;
    @Autowired
    private DeviceStyleDao deviceStyleDao;
    @Autowired
    private UserDao userDao;
    @Autowired
    private ScoreItemDao scoreItemDao;
    @Autowired
    private StockDetailDao stockDetailDao;
    @Override
    public List<Device> selectToDevice(Integer userId) {
        List<Device> deviceList = deviceDao.selectToDevice(userId);
        return deviceList;
    }
//  添加设备    返还积分   添加积分记录
    @Override
    public void pinTurn(Integer userId, Integer deviceStyleId,Integer pid) {
        Device device = new Device();
        Date date = new Date();
        device.setDeviceRenewDate(date);
        device.setDevicePurchaseDate(date);
        int month = date.getMonth();
        if(month==12){
            int year = date.getYear();
            date.setYear(year+1);
            date.setMonth(1);
        }else{
            date.setMonth(month+1);
        }
        device.setDeviceExpireDate(date);
        DeviceStyle deviceStyle = deviceStyleDao.selectByStyleId(deviceStyleId);
        device.setDeviceName(deviceStyle.getDevieStyleName());
//        添加设备号
        int deviceStyle1= stockDetailDao.selectOne(deviceStyleId);
        device.setDeviceNumber(deviceStyle1+"");
        device.setDeviceStyleId(deviceStyleId);
        device.setDeviceUserId(userId);
//        计算最终日期
        Integer deviceStyleNumber = deviceStyle.getDeviceStyleNumber();
        Date date1 = new Date();
        int i = date1.getMonth() + deviceStyleNumber;
        int i1 = i / 12;
        date1.setYear(date1.getYear()+i1);
        date1.setMonth(i%12);
        device.setDeviceEndDate(date1);
        //      添加设备
        deviceDao.insert(device);
//       返还积分  推荐一人 200分
        User user = userDao.selectByPrimaryKey(pid);
        System.out.println(user.getUserCurrentScore());
        BigDecimal add = user.getUserCurrentScore().add(new BigDecimal(200));
        System.out.println(add+"AAAAAAAAAAAAAAA");
        System.out.println(user.getUserTotalScore());
        BigDecimal add1 = user.getUserTotalScore().add(new BigDecimal(200));
        user.setUserCurrentScore(add);
        user.setUserTotalScore(add1);
        userDao.updateByPrimaryKey(user);
//        添加积分记录
        ScoreItem scoreItem = new ScoreItem();
        scoreItem.setScoreItemScore(new BigDecimal(200));
        Date date2 = new Date();
        scoreItem.setScoreItemDate(date2);
        scoreItem.setScoreItemType("分享朋友购买产生积分收益");
        scoreItem.setScoreItemUserId(pid);
        scoreItem.setScoreItemState("0");
        scoreItemDao.insert(scoreItem);
    }


}
