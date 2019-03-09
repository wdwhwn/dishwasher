package com.jingzhun.controller;

import com.jingzhun.service.GoodsService;
import com.jingzhun.utils.jsonutil.JsonUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.io.FileNotFoundException;
import java.util.Map;

/**
 * @author 王丹
 * @Description 商品展示
 * Created by Administrator on 2019/3/4 0004.
 */
@RestController
@CrossOrigin(origins = "*",maxAge = 3600)
public class GoodDetailController {
    @Autowired
    private GoodsService goodsService;
    /**
     * 商品详情展示
     * @param goodsImgGoodsId  商品id
     * @return  状态信息：商品展示成功
     * @throws FileNotFoundException  使用propertiesUtil工具类   文件找不到异常
     */
    @RequestMapping("/selectToGoodsDetail")
    public String selectToGoodsDetail(Integer goodsImgGoodsId) throws FileNotFoundException {
        Map<String, Object> stringObjectMap = goodsService.selectAllById(goodsImgGoodsId);
        stringObjectMap.put("message","商品详情展示成功");
        return JsonUtil.toJson(stringObjectMap);
    }
//  积分兑换

}
