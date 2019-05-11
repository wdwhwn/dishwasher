package com.jingzhun.service;

import com.jingzhun.dao.DeviceDao;
import com.jingzhun.entity.Device;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by Administrator on 2019/2/27 0027.
 */
@Service
@Transactional(rollbackFor = Exception.class)
@Slf4j
public class DeviceRecordServiceImpl implements DeviceRecordService {
    @Autowired
    private DeviceDao deviceDao;
    @Override
    public List<Device> selectToDeviceRecord(Integer deviceId) {
        List<Device> deviceList = deviceDao.selectToDeviceRecord(deviceId);

        return deviceList;
    }
}
