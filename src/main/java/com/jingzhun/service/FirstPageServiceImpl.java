package com.jingzhun.service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.jingzhun.dao.GoodsDao;
import com.jingzhun.dao.ImgDao;
import com.jingzhun.dao.UserDao;
import com.jingzhun.entity.Goods;
import com.jingzhun.entity.GoodsImg;
import com.jingzhun.entity.Img;
import com.jingzhun.entity.User;
import com.jingzhun.utils.properties.PropertiesUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.ResourceUtils;

import java.io.File;
import java.io.FileNotFoundException;
import java.math.BigDecimal;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by Administrator on 2019/2/27 0027.
 */
@Service
@Transactional
@Slf4j
public class FirstPageServiceImpl implements FirstPageService  {

    @Autowired
    private GoodsDao goodsDao;

    @Autowired
    private ImgDao imgDao;
    @Autowired
    private UserDao ud;
    @Override
    public Map<String,Object> selectByFistPage(Integer userId,Integer pageNum,Integer pageSize) throws FileNotFoundException {
        Map<String,Object> map=new HashMap();

    //首页商品分页信息
        PageHelper.startPage(pageNum,pageSize);
            List<Goods> goodsList = goodsDao.selectAll();
//            拼接url
        for (Goods goods:goodsList){
            for(GoodsImg goodsImg:goods.getGoodsImgList()){

                String urlName = PropertiesUtil.readValue("main.properties", "urlName");
                String url = PropertiesUtil.readValue("url.properties", urlName);
                String imgUrl=url+goodsImg.getGoodsImgImg();
                log.debug(imgUrl);
                goodsImg.setGoodsImgImg(imgUrl);
            }
        }
        //        获取分页结果对象
        PageInfo<Goods> goodsPageInfo = new PageInfo<Goods>(goodsList);
//
            map.put("goodsList",goodsPageInfo);

//首页轮播图
        List<Img> imgList = imgDao.selectAll();
            for(Img img:imgList){
                String urlName = PropertiesUtil.readValue("main.properties", "urlName");
                String url = PropertiesUtil.readValue("url.properties", urlName);
                String imgUrl=url+img.getImgImgUrl();
                img.setImgImgUrl(imgUrl);
            }

        map.put("imgList",imgList);

            User user = ud.selectByPrimaryKey(userId);

            BigDecimal userCurrentScore = user.getUserCurrentScore();
            map.put("userCurrentScore",userCurrentScore);
            return map;

    }
}
