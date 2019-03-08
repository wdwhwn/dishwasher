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
 * Created by Administrator on 2019/3/4 0004.
 */
@RestController
@CrossOrigin(origins="*",maxAge = 3600)
public class AddressController {
//    地址列表
    @Autowired
    private AddressService addressService;
    @RequestMapping("selectAllToAddress")
    public String selectAllToAddress(Integer userId){
        List<Address> addresses = addressService.selectAll(userId);
        return JsonUtil.toJson(addresses);
    }
//    添加收货地址
    @RequestMapping("/insertAddress")
    public String insertAddress(Address address){
        HashMap<Object, Object> objectObjectHashMap = new HashMap<>();
        addressService.insert(address);
        objectObjectHashMap.put("message","添加地址成功");
        return JsonUtil.toJson(objectObjectHashMap);
    }
    //    设为默认
//    public void updateToDefault(Integer userId,Integer addressId);
    //    编辑收货地址
//    public void updateToAddress(Address address);
    //    删除地址
//    public void deleteToAddress(Integer addressId);
//    设为默认
    @RequestMapping("/updateToDefault")
    public String updateToDefault(Integer userId,Integer addressId){
        HashMap<Object, Object> objectObjectHashMap = new HashMap<>();
        addressService.updateToDefault(userId,addressId);
        objectObjectHashMap.put("message","执行成功");
           return JsonUtil.toJson(objectObjectHashMap);
    }
//    编辑收货地址
    @RequestMapping("/updateToAddress")
    public String udateToAddress(Address address){
        HashMap<Object, Object> objectObjectHashMap = new HashMap<>();
        addressService.updateToAddress(address);
        objectObjectHashMap.put("message","执行成功");
        return JsonUtil.toJson(objectObjectHashMap);
    }
//    删除地址
    @RequestMapping("/deleteToAddress")
    public String deleteToAddress(Integer addressId){
        HashMap<Object, Object> objectObjectHashMap = new HashMap<>();
        addressService.deleteToAddress(addressId);
        objectObjectHashMap.put("message","执行成功");
        return JsonUtil.toJson(objectObjectHashMap);
    }
}
