package com.jingzhun.dao;

import com.jingzhun.entity.Device;
import java.util.List;

public interface DeviceDao {
    int deleteByPrimaryKey(Integer deviceId);

    int insert(Device record);

    Device selectByPrimaryKey(Integer deviceId);

    List<Device> selectAll();

    int updateByPrimaryKey(Device record);

    //我的设备
    List<Device> selectToDevice(Integer userId);

//我的设备记录
    List<Device> selectToDeviceRecord(Integer deviceId);
}