package com.jingzhun.dao;

import com.jingzhun.entity.Device;
import java.util.List;

public interface DeviceDao {

   /* int deleteByPrimaryKey(Integer deviceId);
    int insert(Device record);

    Device selectByPrimaryKey(Integer deviceId);

    List<Device> selectAll();*/

    //我的设备
    List<Device> selectToDevice(Integer userId);

    //我的设备记录
    List<Device> selectToDeviceRecord(Integer deviceId);

    //  设备续费 之后更新 设备下次激活时间
    int updateByPrimaryKey(Device record);

    // 设备续费  选择哪个设备   根据vip卡  更新信息
    Device selectByPrimaryKey(Integer deviceId);

    //拼团码   查询当前用户所有的设备类型
    List<Device> selectToUserStyle(Integer userId);

    //拼团码 购买设备（添加设备）
    int insert(Device record);
}