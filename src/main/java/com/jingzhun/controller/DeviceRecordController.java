package com.jingzhun.controller;

import com.jingzhun.entity.Device;
import com.jingzhun.service.DeviceRecordService;
import com.jingzhun.service.DeviceService;
import com.jingzhun.utils.jsonutil.JsonUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/**
 * Created by Administrator on 2019/2/27 0027.
 */
@Controller
@CrossOrigin(origins = "*",maxAge = 3600)
public class DeviceRecordController {
    @Autowired
    private DeviceRecordService deviceRecordService;
    @RequestMapping("/selectToDeviceRecord")
    @ResponseBody
    public String selectToDeviceRecord(Integer deviceId){
        List<Device> deviceList = deviceRecordService.selectToDeviceRecord(deviceId);
        return JsonUtil.toJson(deviceList);
    }
}
