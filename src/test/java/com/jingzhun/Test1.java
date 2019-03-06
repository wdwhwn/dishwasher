package com.jingzhun;

import com.jingzhun.dao.*;
import com.jingzhun.entity.*;
import com.jingzhun.service.*;
import com.jingzhun.utils.idrandom.RandomNumber;
import com.jingzhun.utils.properties.PropertiesUtil;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.io.FileNotFoundException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by Administrator on 2019/2/26 0026.
 */
@RunWith(SpringRunner.class)
@SpringBootTest(classes= App.class)
@Slf4j
public class Test1 {
    /*@Autowired
    private UserDao ud;
    @Test1
    public void Test1(){
        List<User> users = ud.selectAll();
        System.out.println(users);
    }*/

    @Autowired
    private FirstPageService fps;

    @Autowired
    private GoodsService gs;

    @Autowired
    private ImgService is;

    @Autowired
    private ImgDao imgDao;

    @Autowired
    private VipDao vd;

    @Autowired
    private RatioDao rd;

    @Autowired
    private GoodsDao goodsDao;
    @Autowired
    private VipService vipService;

    @Autowired
    private CashPageService cashPageService;
    @Autowired
    private StockDetailDao stockDetailDao;

    @Autowired
    private CashRecordService cashRecordService;

    @Autowired
    private StockDetailService stockDetailService;
//  首页展示
    @org.junit.Test
    public void test() throws Exception {

//        System.out.println(user);

//        List<Goods> goods = gs.selectAll();
//        System.out.println(goods);

//        List<Img> imgs = is.selectAll();
//        System.out.println(imgs);

//        List<Vip> vips = vd.selectAll();
//        System.out.println(vips);

       /* List<Ratio> ratios = rd.selectAll();
        System.out.println(ratios);*/
    }

    @org.junit.Test
    public void testA(){
        HashMap<Object, Object> objectObjectHashMap = new HashMap<>();
        for(int i=0;i<25;i++) {
            StockDetail stockDetail = new StockDetail();
            String card = RandomNumber.getCard();
            List<StockDetail> stockDetails = stockDetailDao.selectAll();
            for(StockDetail stockDetail1:stockDetails){
                String stockDetailDeviceNumber = stockDetail.getStockDetailDeviceNumber();
                objectObjectHashMap.put(stockDetailDeviceNumber,4);
            }
            boolean b = objectObjectHashMap.containsKey(card);
            if(b) {
                continue;
            }
            stockDetail.setStockDetailDeviceNumber(card);
            stockDetail.setStockDetailDeviceStyleId(1);
            stockDetailService.insert(stockDetail);
        }
    }

}
