package com.jingzhun;

import com.jingzhun.dao.StockDetailDao;
import com.jingzhun.entity.StockDetail;
import com.jingzhun.service.TwoDimensionalService;
import com.jingzhun.utils.idrandom.RandomNumber;
import com.jingzhun.utils.jedisUtil.JedisUtil;
import com.jingzhun.utils.token.JwtUtil;
import com.jingzhun.utils.twodimensional.QrCodeUtils;
import io.jsonwebtoken.Claims;
import lombok.extern.slf4j.Slf4j;
import org.apache.jasper.tagplugins.jstl.core.ForEach;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import javax.servlet.ServletException;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 2019/3/1 0001.
 */
@Slf4j
public class TestB extends Test1 {
    @Autowired
    private StockDetailDao stockDetailDao;
    @Autowired
    private TwoDimensionalService twoDimensionalService;
    @Test
    public void test(){

        String card = RandomNumber.getCard();
        System.out.println(card);
    }
    @Test
    public void test1(){
//        JedisUtil.getJedis().set("456","123");
        String s = JedisUtil.getJedis().get("13781981469");
        System.out.println(s);

//        String s = JedisUtil.getJedis().get(JsonUtil.toJson("13781981469"));
//        System.out.println(JsonUtil.toObject(s,String.class));
    }
    @Test
    public void test2() throws ServletException {
//        String wd = JwtUtil.getToken("wd");
//        System.out.println(nn);
//        System.out.println(wd);
        Claims claims = JwtUtil.checkToken("eyJhbGciOiJIUzI1NiJ9.eyJzdWIiOiJ3ZCIsInJvbGVzIjoidXNlciIsImlhdCI6MTU1MTUyOTU5MiwiZXhwIjoxNTUxNTMwMTkyfQ.UQIVKs_y3_DO3KvDeqNUUAlF9bihMkvF_jMWjxVbe1c");

        System.out.println(claims.getSubject());
    }
    @Test
    public void test3() throws FileNotFoundException {
       /* String urlName = PropertiesUtil.readValue("main.properties", "urlName");
        System.out.println(urlName);*/
//        Log log = LogFactory.getLog(TestB.class);

    }
    @Test
    public void test4()  {
        System.out.println(stockDetailDao);
        List<StockDetail> stockDetails = stockDetailDao.selectAll();
        for(StockDetail stockDetail:stockDetails){
            String stockDetailDeviceNumber = stockDetail.getStockDetailDeviceNumber();
            Integer stockDetailId = stockDetail.getStockDetailId();
           /* String pre="https://cli.im/api/qrcode/code?text=";
            String behind="&mhid=sELPDFnok80gPHovKdI";*/
            String url="http://xiwanji.91xiaokong.com/devideCode?";
            url=url+"stockDetailDeviceNumber="+stockDetailDeviceNumber+"&stockDetailId="+ stockDetailId;
            /*url=pre+url+behind;*/
            String binary = QrCodeUtils.creatRrCode("123", 200,200);

//            System.out.println(binary);`
//           stockDetail.setStockDetailTwoDimensional(url);
//            stockDetailDao.updateByPrimaryKey(stockDetail);
        }
    }
@Test
    public void testC(){
    File file = new File("images/a.jpg");
    String absolutePath = file.getAbsolutePath();
    System.out.println(absolutePath+"SSSSSSSSSSSSSSS");
}
@Test
    public void testD() throws FileNotFoundException {
    List<Object> objects = twoDimensionalService.selectToUserDeviceStyle(1);
    log.error(objects.toString());
}

}
