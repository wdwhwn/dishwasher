package com.jingzhun.controller;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.jingzhun.entity.Cash;
import com.jingzhun.service.CashRecordService;
import com.jingzhun.utils.jsonutil.JsonUtil;
import com.sun.prism.impl.Disposer;
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
public class CashRecordController {
    @Autowired
    private CashRecordService cashRecordService;
    @RequestMapping("/selectByCashRecord")
    @ResponseBody
    public String selectByCashRecord(Integer userId,Integer pageNum,Integer pageSize){

        PageHelper.startPage(pageNum,pageSize);
        List<Cash> cashList = cashRecordService.selectByCashRecord(userId);
        PageInfo<Cash> cashPageInfo = new PageInfo<Cash>(cashList);
        return JsonUtil.toJson(cashPageInfo);
    }
}
