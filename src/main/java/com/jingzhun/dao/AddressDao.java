package com.jingzhun.dao;

import com.jingzhun.entity.Address;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface AddressDao {
    int deleteByPrimaryKey(Integer addressId);

    int insert(Address record);

    Address selectByPrimaryKey(Integer addressId);

    int update();
//  查询所有收货地址
    List<Address> selectAll(Integer userId);

//    查询默认收货地址
    Address selectByDefault(Integer userId);
//    根据地址id  查询
    Address selectByAddressId(@Param("userId")Integer userId, @Param("addressId")Integer addressId);


}