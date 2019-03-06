package com.jingzhun.dao;

import com.jingzhun.entity.Cash;
import java.util.List;

public interface CashDao {
    /*int deleteByPrimaryKey(Integer cashId);

    int insert(Cash record);

    Cash selectByPrimaryKey(Integer cashId);

    List<Cash> selectAll();

    int updateByPrimaryKey(Cash record);*/

//    提现记录详情
    List<Cash> selectByCashRecord(Integer userId);
//   添加提现记录
    int insert(Cash record);
}