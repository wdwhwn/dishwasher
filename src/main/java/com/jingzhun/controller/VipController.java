package com.jingzhun.controller;

import com.jingzhun.entity.Vip;
import com.jingzhun.service.VipService;
import com.jingzhun.utils.jsonutil.JsonUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.List;

/**
 * Created by Administrator on 2019/2/27 0027.
 */
@Controller
@CrossOrigin(origins = "*",maxAge = 3600)
public class VipController {
    @Autowired
    private VipService vipService;
//    设备续费
    @RequestMapping("/vipSelectAll")
    @ResponseBody
    public List<Vip> selectAll(){
        List<Vip> vipList = vipService.selectAll();
        return vipList;
    }
//    积分兑换
    @RequestMapping("/scoreExchange")
    @ResponseBody
    public String scoreExchange(Integer userId,Integer vipId,Integer deviceId){
        HashMap<String, Object> objectObjectHashMap = new HashMap<>();
        String s = vipService.scoreExchange(userId, vipId, deviceId);
        if(!"续费成功".equals(s)){
            objectObjectHashMap.put("message","请选择低版本卡片");
        }else{
            objectObjectHashMap.put("message","续费成功");
        }
        return JsonUtil.toJson(objectObjectHashMap);
    }
}
