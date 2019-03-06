package com.jingzhun.service;

import com.jingzhun.dao.DeviceDao;
import com.jingzhun.entity.Device;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 2019/3/5 0005.
 */
@Controller
@Transactional
public class TwoDimensionalServiceImpl implements TwoDimensionalService {
    @Autowired
    private DeviceDao deviceDao;
    //    展示当前用户拥有所有类型设备
    public List<Object> selectToUserDeviceStyle(Integer userId){
//        https://cli.im/api/qrcode/code?text=a&mhid=sELPDFnok80gPHovKdI

        List<Device> devices = deviceDao.selectToUserStyle(userId);
        ArrayList<Object> objectArrayList = new ArrayList<>();
        for(Device device:devices){
            String pre="https://cli.im/api/qrcode/code?text=";
            String behind="&mhid=sELPDFnok80gPHovKdI";
            String url="http://140.143.200.89:8080/dishwasher/pinTurnMiddle?";
            Integer deviceStyleId = device.getDeviceStyleId();
            url=url+"pid="+userId+"&deviceStyleId="+ deviceStyleId;
            url=pre+url+behind;
            System.out.println(url);
            objectArrayList.add(url);
        }
        return objectArrayList;
    }
    @Override
    public String assemble(Integer userId) {

        return null;
    }
}
