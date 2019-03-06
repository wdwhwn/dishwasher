package com.jingzhun.service;

import java.util.List;

/**
 * Created by Administrator on 2019/3/5 0005.
 */

public interface TwoDimensionalService {
    //    扫描二维码 添加设备号  insertDervieByTwoDimensional1
    void insertDervieByTwoDimensional1(Integer userId, Integer deviceStyleId,Integer stockDetailDeviceNumber);
    public List<Object> selectToUserDeviceStyle(Integer userId);
}
