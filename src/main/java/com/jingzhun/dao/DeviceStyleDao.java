package com.jingzhun.dao;

import com.jingzhun.entity.DeviceControl;
import com.jingzhun.entity.DeviceStyle;

import java.util.List;

/**
 * Created by Administrator on 2019/3/5 0005.
 */
public interface DeviceStyleDao {

    DeviceStyle selectByStyleId(Integer  deviceStyleId);

}
