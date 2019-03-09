package com.jingzhun.dao;

import com.jingzhun.entity.DeviceStyle;


/**
 * @author wd
 */
public interface DeviceStyleDao {
    /**
     * 根据设备类型查询
     * @param deviceStyleId 设备类型id
     * @return  DeviceStyle
     */
    DeviceStyle selectByStyleId(Integer  deviceStyleId);

}
