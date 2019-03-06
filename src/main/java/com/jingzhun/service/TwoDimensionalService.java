package com.jingzhun.service;

import com.jingzhun.entity.Device;

import java.util.List;

/**
 * Created by Administrator on 2019/3/5 0005.
 */

public interface TwoDimensionalService {
    public String  assemble(Integer userId);
    public List<Object> selectToUserDeviceStyle(Integer userId);
}
