package com.jingzhun.controller;
import com.jingzhun.dao.DeviceStyleDao;
import com.jingzhun.entity.DeviceStyle;
import com.jingzhun.entity.StockDetail;
import com.jingzhun.service.DeviceService;
import com.jingzhun.service.StockDetailService;
import com.jingzhun.service.TwoDimensionalService;
import com.jingzhun.utils.jsonutil.JsonUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.List;

/**
 * @author 王丹
 * Created by Administrator on 2019/3/5 0005.
 */
@RestController
@CrossOrigin(origins = "*",maxAge = 3600)
public class TwoDimensionalController {
    @Autowired
    private DeviceService deviceService;
    @Autowired
    private TwoDimensionalService twoDimensionalService;
    @Autowired
    private DeviceStyleDao deviceStyleDao;
    @Autowired
    private StockDetailService stockDetailService;
//    展示当前用户拥有所有类型设备
    @RequestMapping("/selectToUserDeviceStyle")
    public String selectToUserDeviceStyle(Integer userId){
        HashMap<Object, Object> objectObjectHashMap = new HashMap<>();
        List<Object> objects = twoDimensionalService.selectToUserDeviceStyle(userId);
        objectObjectHashMap.put("DTO",objects);
        return JsonUtil.toJson(objects);
    }
    //    拼团码  确认页面
    @RequestMapping("/pinTurnMiddle")
    private String pinTurnMiddle(Integer pid,Integer deviceStyleId ){
        HashMap<Object, Object> objectObjectHashMap = new HashMap<>();
        DeviceStyle deviceStyle = deviceStyleDao.selectByStyleId(deviceStyleId);
        objectObjectHashMap.put("deviceStyle",deviceStyle);
        objectObjectHashMap.put("pid",pid);
        return JsonUtil.toJson(objectObjectHashMap);
    }
//    拼团码
    @RequestMapping("/pinTurn")
    private String pinTurn(Integer userId,Integer deviceStyleId,Integer pid ){
        HashMap<Object, Object> objectObjectHashMap = new HashMap<>();
        deviceService.pinTurn(userId,deviceStyleId,pid);
        objectObjectHashMap.put("message", "拼团成功");
        return JsonUtil.toJson(objectObjectHashMap);
    }
//    设备码
//   第一步 展示  设备信息  insertDervieByTwoDimensional
    @RequestMapping("/insertDervieByTwoDimensional")
    private String insertDervieByTwoDimensional(Integer stockDetailDeviceNumber,Integer stockDetailId) {
        StockDetail stockDetail = stockDetailService.selectByStockDetailId(stockDetailId,stockDetailDeviceNumber);
        return JsonUtil.toJson(stockDetail);

    }
    //    设备码
//   第二步 添加  设备信息
    @RequestMapping("/insertDervieByTwoDimensional1")
    private String insertDervieByTwoDimensional1(Integer userId,Integer deviceStyleId,Integer stockDetailDeviceNumber) {
        HashMap<String,Object> hashMap = new HashMap<>();
        twoDimensionalService.insertDervieByTwoDimensional1(userId,deviceStyleId,stockDetailDeviceNumber);
            hashMap.put("message","添加成功");
        return null;

    }

}
