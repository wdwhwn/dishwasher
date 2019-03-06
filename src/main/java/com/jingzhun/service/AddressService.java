package com.jingzhun.service;

import com.jingzhun.entity.Address;

import java.util.List;

/**
 * Created by Administrator on 2019/3/4 0004.
 */
public interface AddressService {
    public List<Address> selectAll(Integer userId);
    public void insert(Address address);
//    查询默认收货地址
    public Address selectByDefault(Integer userId);




}
