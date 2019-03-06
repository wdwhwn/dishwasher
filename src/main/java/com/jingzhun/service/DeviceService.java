package com.jingzhun.service;

import com.jingzhun.entity.Device;

import java.util.List;

/**
 * Created by Administrator on 2019/2/27 0027.
 */
public interface DeviceService {
    public List<Device> selectToDevice(Integer userId);
    public void pinTurn(Integer userId,Integer deviceStyleId,Integer pid);
}
