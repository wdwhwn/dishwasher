package com.jingzhun.service;

import com.jingzhun.dao.AddressDao;
import com.jingzhun.entity.Address;
import com.sun.media.jfxmedia.logging.Logger;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CachePut;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by Administrator on 2019/3/4 0004.
 */
@Service
@Transactional
@Slf4j
public class AddressServiceImpl implements AddressService {
    @Autowired
    private AddressDao addressDao;
    @Override
    public List<Address> selectAll(Integer userId) {
        List<Address> addressList = addressDao.selectAll(userId);
        return addressList;
    }
//  添加收货地址
    @Override
    public void insert(Address address) {
        String addressDefaultState = address.getAddressDefaultState();
        if("1".equals(addressDefaultState)){
            addressDao.insert(address);
        }else {
            addressDao.update(address.getAddressUserId());
            addressDao.insert(address);
        }
    }
//    查询默认收货地址
        @Override
        public Address selectByDefault(Integer userId){
            Address address = addressDao.selectByDefault(userId);
            return address;
        }

    /**
     * 修改为默认
     * @param userId  用户id
     * @param addressId   地址id
     */
    @Override
    public void updateToDefault(Integer userId, Integer addressId) {
        addressDao.update(userId);
        addressDao.updateToDefault(addressId);
    }

    /**
     *编辑地址
     *  * @param address 地址对象
     */
    @Override
    public void updateToAddress(Address address) {
        if(("1").equals(address.getAddressDefaultState())){
            addressDao.updateToAddress(address);
        }else{
            addressDao.update(address.getAddressUserId());
            addressDao.updateToAddress(address);
        }
    }

    /**
     * 删除地址
     *
     * @param addressId   地址id
     */
    @Override
    public void deleteToAddress(Integer addressId) {
            addressDao.deleteToAddress(addressId);
    }


}
