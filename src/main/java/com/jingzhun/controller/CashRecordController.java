package com.jingzhun.controller;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.jingzhun.entity.Cash;
import com.jingzhun.service.CashRecordService;
import com.jingzhun.utils.jsonutil.JsonUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.List;

/**
 * @author 王丹
 * @description 提现记录
 * Created by Administrator on 2019/2/27 0027.
 * */
@RestController
@CrossOrigin(origins = "*",maxAge = 3600)
public class CashRecordController {
    @Autowired
    private CashRecordService cashRecordService;

    /**
     *
     * @param userId
     * @param pageNum
     * @param pageSize
     * @return
     */
    @RequestMapping("/selectByCashRecord")
    public String selectByCashRecord(Integer userId,Integer pageNum,Integer pageSize){
        PageHelper.startPage(pageNum,pageSize);
        List<Cash> cashList = cashRecordService.selectByCashRecord(userId);
        PageInfo<Cash> cashPageInfo = new PageInfo<Cash>(cashList);
        return JsonUtil.toJson(cashPageInfo);
    }
}
