package com.jingzhun.controller;
import com.jingzhun.dao.DeviceStyleDao;
import com.jingzhun.entity.DeviceStyle;
import com.jingzhun.entity.StockDetail;
import com.jingzhun.service.DeviceService;
import com.jingzhun.service.StockDetailService;
import com.jingzhun.service.TwoDimensionalService;
import com.jingzhun.utils.jsonutil.JsonUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.FileNotFoundException;
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

    /**
     * @title 展示当前用户拥有所有类型设备二维码
     * @param userId  用户id
     * @return  返回设备类型名称和对应的二维码
     */
    @RequestMapping("/selectToUserDeviceStyle")
    public String selectToUserDeviceStyle(Integer userId) throws FileNotFoundException {
        HashMap<Object, Object> objectObjectHashMap = new HashMap<>(3);
        List<Object> objects = twoDimensionalService.selectToUserDeviceStyle(userId);
        objectObjectHashMap.put("DTO",objects);
        return JsonUtil.toJson(objects);
    }
    /**
     * @title  拼团码  确认页面
     * @description  需要插入当前用户id
     * @param pid   分享二维码用户的id
     * @param deviceStyleId  设备类型id
     * @return
     */
    @RequestMapping("/pinTurnMiddle")
    private String pinTurnMiddle(Integer pid,Integer deviceStyleId ){
        HashMap<Object, Object> objectObjectHashMap = new HashMap<>(4);
        DeviceStyle deviceStyle = deviceStyleDao.selectByStyleId(deviceStyleId);
        objectObjectHashMap.put("deviceStyle",deviceStyle);
        objectObjectHashMap.put("pid",pid);
        return JsonUtil.toJson(objectObjectHashMap);
    }

    /**
     *@title 拼团码
     * @description  执行拼团，购买设备
     * @param userId
     * @param deviceStyleId
     * @param pid
     * @return
     */
    @RequestMapping("/pinTurn")
    private String pinTurn(Integer userId,Integer deviceStyleId,Integer pid ){
        HashMap<Object, Object> objectObjectHashMap = new HashMap<>(3);
        deviceService.pinTurn(userId,deviceStyleId,pid);
        objectObjectHashMap.put("message", "拼团成功");
        return JsonUtil.toJson(objectObjectHashMap);
    }
    /**
     * @title 设备码
     * @description  第一步 展示  设备信息  insertDervieByTwoDimensional
     * @param stockDetailDeviceNumber  设备号
     * @param stockDetailId  库存设备id
     * @return  库存设备信息
     */
    @RequestMapping("/insertDervieByTwoDimensional")
    private String insertDervieByTwoDimensional(Integer stockDetailDeviceNumber,Integer stockDetailId) {
        StockDetail stockDetail = stockDetailService.selectByStockDetailId(stockDetailId,stockDetailDeviceNumber);
        return JsonUtil.toJson(stockDetail);

    }
     /**
     * @title 设备码
     * @description 第二步 添加  设备信息
     * @param userId  用户id
     * @param deviceStyleId  设备类型id
     * @param stockDetailDeviceNumber  设备号
     * @return 状态信息
     */
    @RequestMapping("/insertDervieByTwoDimensional1")
    private String insertDervieByTwoDimensional1(Integer userId,Integer deviceStyleId,Integer stockDetailDeviceNumber) {
        HashMap<String,Object> hashMap = new HashMap<>(3);
        twoDimensionalService.insertDervieByTwoDimensional1(userId,deviceStyleId,stockDetailDeviceNumber);
            hashMap.put("message","添加成功");
        return JsonUtil.toJson(hashMap);
    }
}
