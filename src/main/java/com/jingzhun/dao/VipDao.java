package com.jingzhun.dao;

import com.jingzhun.entity.Ratio;
import com.jingzhun.entity.Vip;
import java.util.List;

public interface VipDao {
    int deleteByPrimaryKey(Integer vipId);

    int insert(Vip record);

    //积分兑换
    Vip selectByPrimaryKey(Integer vipId);

    //设备续费列表
    List<Vip> selectAll();

}