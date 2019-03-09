package com.jingzhun.dao;

import com.jingzhun.entity.Address;
import org.apache.ibatis.annotations.Param;

import java.util.List;
/**
 * @author wd
 */
public interface AddressDao {
    /*int deleteByPrimaryKey(Integer addressId);

    int insert(Address record);

    Address selectByPrimaryKey(Integer addressId);

    int update();*/
    /**
     * 查询所有收货地址
     * @param userId   用户id
     * @return  当前用户地址列表
     */
    List<Address> selectAll(Integer userId);
    /**
     *查询默认收货地址
     * @param userId   用户id
     * @return  返回当前用户默认地址
     */
    Address selectByDefault(Integer userId);
    /**
     *根据地址id  查询
     * @param userId  用户id
     * @param addressId  地址id
     * @return Address
     */
    Address selectByAddressId(@Param("userId")Integer userId, @Param("addressId")Integer addressId);

    /**
     * 添加地址
     * @param record 地址对象
     *
     */
    void insert(Address record);

    /**
     * 当前用户其它地址设为非默认
     * @param userId  用户id
     */
    public void update(Integer userId);

    /**
     *当前地址设为默认
     * @param addressId  地址id
     */
    public void updateToDefault(Integer addressId);

    /**
     *编辑当前地址
     * @param address 地址对象
     */
    public void updateToAddress(Address address);

    /**
     *删除当前地址
     * @param addressId  地址id
     */
    public void deleteToAddress(Integer addressId);



}