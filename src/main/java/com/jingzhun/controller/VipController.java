package com.jingzhun.controller;

import com.jingzhun.entity.Vip;
import com.jingzhun.service.VipService;
import com.jingzhun.utils.jsonutil.JsonUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;

/**
 * @author  王丹
 * @Description  设备续费  积分兑换
 * Created by Administrator on 2019/2/27 0027.
 */
@RestController
@CrossOrigin(origins = "*",maxAge = 3600)
public class VipController {
    private static final String SUCCESS="续费成功";
    @Autowired
    private VipService vipService;
    @RequestMapping("/vipSelectAll")
    public String selectAll(HttpServletResponse response) throws IOException {
        List<Vip> vipList = vipService.selectAll();

        return JsonUtil.toJson(vipList);
    }

    @RequestMapping("/scoreExchange")
    public String scoreExchange(Integer userId,Integer vipId,Integer deviceId){
        HashMap<String, Object> objectObjectHashMap = new HashMap<String,Object>(3);
        String s = vipService.scoreExchange(userId, vipId, deviceId);
        if(!SUCCESS.equals(s)){
            objectObjectHashMap.put("message","请选择低版本卡片");
        }else{
            objectObjectHashMap.put("message","续费成功");
        }
        return JsonUtil.toJson(objectObjectHashMap);
    }
}
