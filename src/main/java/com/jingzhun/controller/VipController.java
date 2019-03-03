package com.jingzhun.controller;

import com.jingzhun.entity.Vip;
import com.jingzhun.service.VipService;
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
public class VipController {
    @Autowired
    private VipService vipService;
    @RequestMapping("/vipSelectAll")
    @ResponseBody
    public List<Vip> selectAll(){
        List<Vip> vipList = vipService.selectAll();
        return vipList;
    }
}
