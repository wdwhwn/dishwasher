package com.jingzhun;

import com.jingzhun.dao.GoodsDao;
import com.jingzhun.dao.ImgDao;
import com.jingzhun.dao.RatioDao;
import com.jingzhun.dao.VipDao;
import com.jingzhun.entity.*;
import com.jingzhun.service.*;
import com.jingzhun.utils.properties.PropertiesUtil;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.io.FileNotFoundException;
import java.util.List;
import java.util.Map;

/**
 * Created by Administrator on 2019/2/26 0026.
 */
@RunWith(SpringRunner.class)
@SpringBootTest(classes= App.class)
public class test {
    /*@Autowired
    private UserDao ud;
    @Test
    public void test(){
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
    private CashRecordService cashRecordService;
//  首页展示
    @Test
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



}
