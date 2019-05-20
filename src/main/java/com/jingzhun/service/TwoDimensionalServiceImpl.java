package com.jingzhun.service;

import com.jingzhun.dao.DeviceDao;
import com.jingzhun.dao.DeviceStyleDao;
import com.jingzhun.dao.StockDetailDao;
import com.jingzhun.entity.Device;
import com.jingzhun.entity.DeviceStyle;
import com.jingzhun.entity.DeviceTwoDimensionalDTO;
import com.jingzhun.utils.jsonutil.JsonUtil;
import com.jingzhun.utils.properties.PropertiesUtil;
import com.jingzhun.utils.twodimensional.QrCodeUtils;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;

/**
 * Created by Administrator on 2019/3/5 0005.
 */
@Service
@Transactional(rollbackFor = Exception.class)
@Slf4j
public class TwoDimensionalServiceImpl implements TwoDimensionalService {
    @Autowired
    private DeviceDao deviceDao;
    @Autowired
    private DeviceStyleDao deviceStyleDao;
    @Autowired
    private StockDetailDao stockDetailDao;
    @Override
    public void insertDervieByTwoDimensional1(Integer userId, Integer stockDetailId,Integer deviceStyleId,Integer stockDetailDeviceNumber ) {
        Device device = new Device();
        Date date = new Date();
        device.setDeviceRenewDate(date);
        device.setDevicePurchaseDate(date);
        int month = date.getMonth();
        if(month==12){
            int year = date.getYear();
            date.setYear(year+1);
            date.setMonth(1);
        }else{
            date.setMonth(month+1);
        }
        device.setDeviceExpireDate(date);
        DeviceStyle deviceStyle = deviceStyleDao.selectByStyleId(deviceStyleId);
        device.setDeviceName(deviceStyle.getDevieStyleName());

        device.setDeviceNumber(stockDetailDeviceNumber+"");
        device.setDeviceStyleId(deviceStyleId);
        device.setDeviceUserId(userId);
//        计算最终日期
        Integer deviceStyleNumber = deviceStyle.getDeviceStyleNumber();
        Date date1 = new Date();
        int i = date1.getMonth() + deviceStyleNumber;
        int i1 = i / 12;
        date1.setYear(date1.getYear()+i1);
        date1.setMonth(i%12);
        device.setDeviceEndDate(date1);
        //      添加设备
        deviceDao.insert(device);
//        从库存表更改设备编号
        stockDetailDao.updateState(stockDetailId);
    }

    //    展示当前用户拥有所有类型设备
    @Override
    public List<Object> selectToUserDeviceStyle(Integer userId) throws FileNotFoundException {
//        https://cli.im/api/qrcode/code?text=a&mhid=sELPDFnok80gPHovKdI
        ArrayList<Object> objects = new ArrayList<Object>();
        List<Device> devices = deviceDao.selectToUserStyle(userId);
        for(int i=0;i<devices.size();i++){
            /*String pre="https://cli.im/api/qrcode/code?text=";
            String behind="&mhid=sELPDFnok80gPHovKdI";*/
//            String url="http://140.143.200.89:8080/dishwasher/pinTurnMiddle?";
            Integer deviceStyleId = devices.get(i).getDeviceStyleId();
//            url=url+"pid="+userId+"&deviceStyleId="+ deviceStyleId;
//            url=pre+url+behind;
            DeviceStyle deviceStyle = deviceStyleDao.selectByStyleId(deviceStyleId);
            String urlName = PropertiesUtil.readValue("main.properties", "urlName");
            String url = PropertiesUtil.readValue("url.properties", urlName);
            url="http://"+url+"/#/numpintuan";
            url=url+"?"+deviceStyle.getDeviceStyleId()+"&devieStyleName="+deviceStyle.getDevieStyleName()+"&devieStyleMonthSupply="+deviceStyle.getDevieStyleMonthSupply()+"&deviceStyleNumber="+deviceStyle.getDeviceStyleNumber();


            String binary = QrCodeUtils.creatRrCode(url, 200, 200);
            DeviceTwoDimensionalDTO deviceTwoDimensionalDTO = new DeviceTwoDimensionalDTO();
            deviceTwoDimensionalDTO.setName(deviceStyle.getDevieStyleName());
            deviceTwoDimensionalDTO.setUrl(binary);
            objects.add(deviceTwoDimensionalDTO);
        }

        return objects;
    }

}
