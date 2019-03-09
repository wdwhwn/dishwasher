package com.jingzhun.controller;

import com.jingzhun.entity.Address;
import com.jingzhun.service.AddressService;
import com.jingzhun.utils.jsonutil.JsonUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.HashMap;
import java.util.List;

/**
 * @author 王丹
 * @Description  收货地址
 * Created by Administrator on 2019/3/4 0004.
 */
@RestController
@CrossOrigin(origins="*",maxAge = 3600)
public class AddressController {

    @Autowired
    private AddressService addressService;

    /**
     * @title 地址列表
     * @param userId  用户id
     * @return 收货地址列表
     */
    @RequestMapping("selectAllToAddress")
    public String selectAllToAddress(Integer userId){
        List<Address> addresses = addressService.selectAll(userId);
        return JsonUtil.toJson(addresses);
    }
    /**
     * @title 添加收货地址
     * @param address  添加地址对象
     * @return  状态信息：执行成功
     */
    @RequestMapping("/insertAddress")
    public String insertAddress(Address address){
        HashMap<Object, Object> objectObjectHashMap = new HashMap<>(3);
        addressService.insert(address);
        objectObjectHashMap.put("message","添加地址成功");
        return JsonUtil.toJson(objectObjectHashMap);
    }

    /**
     * 设为默认
     * @param userId 用户id
     * @param addressId  收货地址id
     * @return  状态信息：执行成功
     */
    @RequestMapping("/updateToDefault")
    public String updateToDefault(Integer userId,Integer addressId){
        HashMap<Object, Object> objectObjectHashMap = new HashMap<>(3);
        addressService.updateToDefault(userId,addressId);
        objectObjectHashMap.put("message","执行成功");
           return JsonUtil.toJson(objectObjectHashMap);
    }

    /**
     *  编辑收货地址
     * @param address  地址对象
     * @return  状态信息：执行成功
     */
    @RequestMapping("/updateToAddress")
    public String udateToAddress(Address address){
        HashMap<Object, Object> objectObjectHashMap = new HashMap<>(3);
        addressService.updateToAddress(address);
        objectObjectHashMap.put("message","执行成功");
        return JsonUtil.toJson(objectObjectHashMap);
    }


    /**
     *   删除地址
     * @param addressId  收货地址id
     * @return      状态信息：执行成功
     */
    @RequestMapping("/deleteToAddress")
    public String deleteToAddress(Integer addressId){
        HashMap<Object, Object> objectObjectHashMap = new HashMap<>(3);
        addressService.deleteToAddress(addressId);
        objectObjectHashMap.put("message","执行成功");
        return JsonUtil.toJson(objectObjectHashMap);
    }
}
