package com.jingzhun.dao;

import com.jingzhun.entity.Device;
import java.util.List;
/**
 * @author wd
 */
public interface DeviceDao {

   /* int deleteByPrimaryKey(Integer deviceId);
    int insert(Device record);

    Device selectByPrimaryKey(Integer deviceId);

    List<Device> selectAll();*/


    /**
     * 当前用户拥有的设备
     * @param userId  用户id
     * @return  List<Device>
     */
    List<Device> selectToDevice(Integer userId);

    /**
     *我的设备记录
     * @param deviceId 设备id
     * @return  List<Device>
     */
    List<Device> selectToDeviceRecord(Integer deviceId);

    /**
     * 设备续费 之后更新 设备下次激活时间
     * @param record  记录对象
     *
     */
    void updateByPrimaryKey(Device record);

    /**
     * 设备续费  选择哪个设备   根据vip卡  更新信息
     * @param deviceId  设备id
     * @return   Device
     */
    Device selectByPrimaryKey(Integer deviceId);

    /**
     * 拼团码   查询当前用户所有的设备类型
     * @param userId
     * @return List<Device>
     */
    List<Device> selectToUserStyle(Integer userId);

    /**
     * 拼团码 购买设备（添加设备）
     * @param record  记录对象
     * @return
     */
    void insert(Device record);
}