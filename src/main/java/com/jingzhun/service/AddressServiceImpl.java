package com.jingzhun.service;

import com.jingzhun.dao.AddressDao;
import com.jingzhun.entity.Address;
import com.jingzhun.utils.jsonutil.JsonUtil;
import net.sf.json.JSON;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by Administrator on 2019/3/4 0004.
 */
@Service
@Transactional
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
            addressDao.update();
            addressDao.insert(address);
        }
    }
//    查询默认收货地址
        public Address selectByDefault(Integer userId){
            Address address = addressDao.selectByDefault(userId);
            return address;
        }



}
