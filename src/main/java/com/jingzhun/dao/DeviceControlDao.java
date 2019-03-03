package com.jingzhun.dao;

import com.jingzhun.entity.DeviceControl;
import java.util.List;

public interface DeviceControlDao {
    int deleteByPrimaryKey(Integer deviceControlId);

    int insert(DeviceControl record);

    DeviceControl selectByPrimaryKey(Integer deviceControlId);

    List<DeviceControl> selectAll();

    int updateByPrimaryKey(DeviceControl record);


}