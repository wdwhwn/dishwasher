package com.jingzhun.service;

import com.jingzhun.entity.Device;

import java.util.List;

/**
 * Created by Administrator on 2019/2/27 0027.
 */
public interface DeviceRecordService {
    public List<Device>  selectToDeviceRecord(Integer deviceId);
}
