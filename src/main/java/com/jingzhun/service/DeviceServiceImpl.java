package com.jingzhun.service;

import com.jingzhun.dao.DeviceDao;
import com.jingzhun.entity.Device;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by Administrator on 2019/2/27 0027.
 */
@Service
@Transactional
public class DeviceServiceImpl implements DeviceService {
    @Autowired
    private DeviceDao deviceDao;
    @Override
    public List<Device> selectToDevice(Integer userId) {
        List<Device> deviceList = deviceDao.selectToDevice(userId);
        return deviceList;
    }
}
