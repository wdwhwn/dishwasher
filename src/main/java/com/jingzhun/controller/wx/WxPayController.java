package com.jingzhun.controller.wx;

import com.alibaba.fastjson.JSONObject;
import com.jingzhun.service.AccountService;
import com.jingzhun.utils.jsonutil.JsonUtil;
import com.jingzhun.utils.weixinutils.AuthUtil;
import com.jingzhun.utils.wxpay.HttpRequest;
import com.jingzhun.utils.wxpay.WXPay;
import com.jingzhun.utils.wxpay.WXPayUtil;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.*;
import java.math.BigDecimal;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.HashMap;
import java.util.Map;
/**
 * @ClassName WxPayController
 * @Description 微信支付成功后回调次接口
 * @author wtao wangtao@eyaoshun.com
 * @date 2018年1月11日 下午3:10:59
 */
//回调路径是自己在之前已经填写过的
@RequestMapping("/pay/")
@Controller
@Slf4j
public class WxPayController {
    //    @Autowired
//    private OrdersService ordersService;
    @Autowired
    private AccountService accountService;
//    @Autowired
//    private PointService pointService;
    // 微信appid 1
    String appid = "wx778f313eff0f980b";
    // 微信secret
    String secret = "910415b15c96d7268cc1ee899f5fc8cd";
    // 初始化access_token
    String access_token = "jingzhun";
    //    商户id
    String mchId = "1512803161";
    //    商户key
    String paternerKey = "jingzhunkejiyouxiangongsi1234567";

    @RequestMapping("callback")
    public String callBack(HttpServletRequest request, HttpServletResponse response) {
        //System.out.println("微信支付成功,微信发送的callback信息,请注意修改订单信息");
        InputStream is = null;
        try {
            is = request.getInputStream();//获取请求的流信息(这里是微信发的xml格式所有只能使用流来读)
//            String xml = WXPayUtil.inputStream2String(is, "UTF-8");
            String xml = WXPayUtil.getStreamString(is);
            Map<String, String> notifyMap = WXPayUtil.xmlToMap(xml);//将微信发的xml转map
            if (notifyMap.get("return_code").equals("SUCCESS")) {
                if (notifyMap.get("result_code").equals("SUCCESS")) {
                    String ordersSn = notifyMap.get("out_trade_no");//商户订单号
                    String amountpaid = notifyMap.get("total_fee");//实际支付的订单金额:单位 分
                    BigDecimal amountPay = (new BigDecimal(amountpaid).divide(new BigDecimal("100"))).setScale(2);//将分转换成元-实际支付金额:元
                    //String openid = notifyMap.get("openid");  //如果有需要可以获取
                    //String trade_type = notifyMap.get("trade_type");
	                /*以下是自己的业务处理------仅做参考
	                 * 更新order对应字段/已支付金额/状态码
	                 */
//                    Orders order = ordersService.selectOrdersBySn(ordersSn);
//                    if(order != null) {
//                        order.setLastmodifieddate(new Date());
//                        order.setVersion(order.getVersion().add(BigDecimal.ONE));
//                        order.setAmountpaid(amountPay);//已支付金额
//                        order.setStatus(2L);//修改订单状态为待发货
//                        int num = ordersService.updateOrders(order);//更新order
                    String amount = amountPay.setScale(0, BigDecimal.ROUND_FLOOR).toString();//实际支付金额向下取整-123.23--123
	                	/*
	                	 * 更新用户经验值
	                	 */
//                        Member member = accountService.findObjectById(order.getMemberId());
//                        accountService.updateMemberByGrowth(amount, member);
	                	/*
	                	 * 添加用户积分数及添加积分记录表记录
	                	 */
//                        pointService.updateMemberPointAndLog(amount, member, "购买商品,订单号为:"+ordersSn);
                }
            }
//            }
            //告诉微信服务器收到信息了，不要在调用回调action了========这里很重要回复微信服务器信息用流发送一个xml即可
            response.getWriter().write("<xml><return_code><![CDATA[SUCCESS]]></return_code></xml>");
            is.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    /**
     * @param request
     * @param code
     * @return Map
     * @Description 微信浏览器内微信支付/公众号支付(JSAPI)
     */
    @RequestMapping(value = "orders", method = RequestMethod.GET)
    @ResponseBody

    public Map orders(HttpServletRequest request, String code) {
        try {
            //页面获取openId接口
            String getopenid_url = "https://api.weixin.qq.com/sns/oauth2/access_token";
            log.error(getopenid_url);
            String param = "appid=" + appid + "&secret=" + secret + "&code=" + code + "&grant_type=authorization_code";
            String url = getopenid_url + "?" + param;
            //向微信服务器发送get请求获取openIdStr
//            String openIdStr = HttpRequest.sendGet(getopenid_url, param);
//            JSONObject json = JSONObject.parseObject(openIdStr);//转成Json格式
//            String openId = json.getString("openid");//获取openId
            JSONObject jsonObject = AuthUtil.doGetJson(url);
            String openId = jsonObject.getString("openid");
            //拼接统一下单地址参数
            Map<String, String> paraMap = new HashMap<String, String>();
            //获取请求ip地址
            String ip = request.getHeader("x-forwarded-for");
            if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
                ip = request.getHeader("Proxy-Client-IP");
            }
            if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
                ip = request.getHeader("WL-Proxy-Client-IP");
            }
            if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
                ip = request.getRemoteAddr();
            }
            if (ip.indexOf(",") != -1) {
                String[] ips = ip.split(",");
                ip = ips[0].trim();
            }
            paraMap.put("appid", appid);
//            paraMap.put("body", "莱田洗碗机-订单结算");
            paraMap.put("body", "laitian");
//            paraMap.put("mch_id", 你mchId);
            paraMap.put("mch_id", mchId);
            paraMap.put("nonce_str", WXPayUtil.generateNonceStr());
            paraMap.put("openid", openId);
//            paraMap.put("openid", "ogiDYs13i0uirzjket3XBIUMhRbc");
//            paraMap.put("out_trade_no", 你的订单号);//订单号
            paraMap.put("out_trade_no", "201901120456");//订单号
            paraMap.put("spbill_create_ip", ip);
            paraMap.put("total_fee", "1");
            paraMap.put("trade_type", "JSAPI");
            paraMap.put("notify_url", "www.*******.com/***/**");// 此路径是微信服务器调用支付结果通知路径随意写
//            String sign = WXPayUtil.generateSignature(paraMap, paternerKey);
            log.error(JsonUtil.toJson(paraMap));
            log.error(paternerKey);
            log.error(ip);
            String sign = WXPayUtil.generateSignature(paraMap, paternerKey);
            paraMap.put("sign", sign);
            String xml = WXPayUtil.mapToXml(paraMap);//将所有参数(map)转xml格式
            log.error("发送的xml  "+xml);
            // 统一下单 https://api.mch.weixin.qq.com/pay/unifiedorder
            String unifiedorder_url = "https://api.mch.weixin.qq.com/pay/unifiedorder";
            String xmlStr = HttpRequest.sendPost(unifiedorder_url, xml);//发送post请求"统一下单接口"返回预支付id:prepay_id
            //以下内容是返回前端页面的json数据
            log.error("接收的xml"+xmlStr);
            String prepay_id = "";//预支付id
            if (xmlStr.indexOf("SUCCESS") != -1) {
                Map<String, String> map = WXPayUtil.xmlToMap(xmlStr);
                prepay_id = map.get("prepay_id");
            }
            log.error("AAAA  "+prepay_id);
            Map<String, String> payMap = new HashMap<String, String>();
            payMap.put("appId", appid);
            payMap.put("timeStamp", WXPayUtil.getCurrentTimestamp() + "");
            payMap.put("nonceStr", WXPayUtil.generateNonceStr());
            payMap.put("signType", "MD5");
            payMap.put("package", "prepay_id=" + prepay_id);
//            String paySign = WXPayUtil.generateSignature(payMap, paternerKey);
            String paySign = WXPayUtil.generateSignature(payMap, "paternerKey");
            payMap.put("paySign", paySign);
            return payMap;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }


}
