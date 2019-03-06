package com.jingzhun.service;

import com.jingzhun.entity.Vip;

import java.util.List;

/**
 * Created by Administrator on 2019/2/27 0027.
 */
public interface VipService {
    public List<Vip> selectAll();
    String scoreExchange(Integer userId,Integer vipId,Integer deviceId);
}
