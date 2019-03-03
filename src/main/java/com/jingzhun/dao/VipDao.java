package com.jingzhun.dao;

import com.jingzhun.entity.Ratio;
import com.jingzhun.entity.Vip;
import java.util.List;

public interface VipDao {
    int deleteByPrimaryKey(Integer vipId);

    int insert(Vip record);

    Vip selectByPrimaryKey(Integer vipId);

    List<Vip> selectAll();

    int updateByPrimaryKey(Vip record);


}