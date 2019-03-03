package com.jingzhun.service;

import com.jingzhun.entity.Cash;

import java.util.List;

/**
 * Created by Administrator on 2019/2/27 0027.
 */
public interface CashRecordService {
    public List<Cash> selectByCashRecord(Integer userId);
}
