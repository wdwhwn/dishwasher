package com.jingzhun.dao;

import com.jingzhun.entity.Vip;
import java.util.List;
/**
 * @author wd
 */
public interface VipDao {
   /* int deleteByPrimaryKey(Integer vipId);

    int insert(Vip record);*/
    /**
     * 积分兑换
     * @param vipId vipId
     * @return Vip
     */
    Vip selectByPrimaryKey(Integer vipId);

    /**
     *  设备续费列表
     * @return  List<Vip>
     */
    List<Vip> selectAll();

}