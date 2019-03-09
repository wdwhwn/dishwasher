package com.jingzhun.controller;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.jingzhun.entity.Device;
import com.jingzhun.service.DeviceService;
import com.jingzhun.utils.jsonutil.JsonUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @author  王丹
 * Created by Administrator on 2019/2/27 0027.
 */
@RestController
@CrossOrigin(origins = "*",maxAge = 3600)
public class DeviceController {
    @Autowired
    private DeviceService deviceService;
    @RequestMapping("/selectToDevice")
    public String selectToDevice(Integer userId,Integer pageNum,Integer pageSize,String token){
        System.out.println("设备");
        PageHelper.startPage(pageNum,pageSize);
        List<Device> deviceList = deviceService.selectToDevice(userId);
        PageInfo<Device> devicePageInfo = new PageInfo<Device>(deviceList);
        return JsonUtil.toJson(devicePageInfo);
    }

//    通过拼团码 添加设备（后续完善购买） 返还积分
    @RequestMapping("/pintuan")
    public String pintuan(Integer userId,Integer deviceStyleId){


        return null;
    }
}
