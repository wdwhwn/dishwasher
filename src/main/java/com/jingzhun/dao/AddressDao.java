package com.jingzhun.dao;

import com.jingzhun.entity.Address;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface AddressDao {
    /*int deleteByPrimaryKey(Integer addressId);

    int insert(Address record);

    Address selectByPrimaryKey(Integer addressId);

    int update();*/
//  查询所有收货地址 1
    List<Address> selectAll(Integer userId);

//    查询默认收货地址 4
    Address selectByDefault(Integer userId);
//    根据地址id  查询 5
    Address selectByAddressId(@Param("userId")Integer userId, @Param("addressId")Integer addressId);
//    添加收货地址 2
    int insert(Address record);
//    其它的设为非默认 3
    public void update(Integer userId);
    //    设为默认 6
    public void updateToDefault(Integer addressId);
    //    编辑收货地址 7
    public void updateToAddress(Address address);
    //    删除地址 8
    public void deleteToAddress(Integer addressId);



}