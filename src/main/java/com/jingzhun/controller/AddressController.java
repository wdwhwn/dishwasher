package com.jingzhun.controller;

import com.jingzhun.entity.Address;
import com.jingzhun.service.AddressService;
import com.jingzhun.utils.jsonutil.JsonUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.List;

/**
 * Created by Administrator on 2019/3/4 0004.
 */
@Controller
@CrossOrigin(origins="*",maxAge = 3600)
public class AddressController {
//    地址列表
    @Autowired
    private AddressService addressService;
    @RequestMapping("selectAllToAddress")
    @ResponseBody
    public String selectAllToAddress(Integer userId){
        List<Address> addresses = addressService.selectAll(userId);
        return JsonUtil.toJson(addresses);
    }
//    添加收货地址
    @RequestMapping("/insertAddress")
    @ResponseBody
    public String insertAddress(Address address){
        HashMap<Object, Object> objectObjectHashMap = new HashMap<>();
        addressService.insert(address);
        objectObjectHashMap.put("message","添加地址成功");
        return JsonUtil.toJson(objectObjectHashMap);
    }
}
