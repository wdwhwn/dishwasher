package com.jingzhun.controller.wx;

import com.jingzhun.entity.Order;
import com.jingzhun.entity.Ratio;
import com.jingzhun.entity.User;
import com.jingzhun.service.AccountService;
import com.jingzhun.service.OrderService;
import com.jingzhun.service.RatioService;
import com.jingzhun.service.UserService;
import com.jingzhun.utils.jsonutil.JsonUtil;
import com.jingzhun.utils.wxpay.HttpRequest;
import com.jingzhun.utils.wxpay.WXPayUtil;
import com.jingzhun.utils.wxpay.wxrollback.WechatRefundApiResult;
import com.jingzhun.utils.wxpay.wxrollback.WechatUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.*;
import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

/**
 * @ClassName WxPayController
 * @Description 微信支付成功后回调次接口
 * @author wtao wangtao@eyaoshun.com
 * @date 2018年1月11日 下午3:10:59
 */
//回调路径是自己在之前已经填写过的
@RequestMapping("/pay/")
@CrossOrigin(origins="*",maxAge = 3600)
@Controller
@Slf4j
public class WxPayController {
    @Autowired
    private UserService userService;
    @Autowired
    private OrderService orderService;
    @Autowired
    private RatioService ratioService;

    // 微信appid 1
    String appid = "wx778f313eff0f980b";
    // 微信secret
    String secret = "910415b15c96d7268cc1ee899f5fc8cd";
    // 初始化access_token
    String access_token = "jingzhun";
    //    商户id
    String mchId = "1512803161";
    //    商户key
    String paternerKey = "jingzhunruanjiankejiyouxiangong0";

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
                    Order order = orderService.selectOrderByOrderSn(Integer.parseInt(ordersSn));
                    if(order !=null){
                        order.setOrderStatus("201");
                        order.setOrderPayStatus("2");
                    }
                }
            }
//            }
            log.error("+++++++++++++++++++++++++++++++++支付回调：支付成功++++++++++++++++++++++++++++++++++++++++++++++++");
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
     * @param
     * @return Map
     * @Description 微信浏览器内微信支付/公众号支付(JSAPI)
     */
    @RequestMapping(value = "orders", method = RequestMethod.GET)
    @ResponseBody
    public Map orders(HttpServletRequest request, Integer userId,Integer orderId) {
        try {
            //页面获取openId接口
//            String getopenid_url = "https://api.weixin.qq.com/sns/oauth2/access_token";
//            log.error(getopenid_url);
//            String param = "appid=" + appid + "&secret=" + secret + "&code=" + code + "&grant_type=authorization_code";
//            String url = getopenid_url + "?" + param;
            //向微信服务器发送get请求获取openIdStr
//            String openIdStr = HttpRequest.sendGet(getopenid_url, param);
//            JSONObject json = JSONObject.parseObject(openIdStr);//转成Json格式
//            String openId = json.getString("openid");//获取openId
//            JSONObject jsonObject = AuthUtil.doGetJson(url);
//            String openid = jsonObject.getString("openid");
            User user = userService.selectByPrimaryKey(userId);
            String openId = user.getUserWxOpenid();
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
            Order order = orderService.selectOrderToPay(orderId);
            String body = order.getGoods().getGoodsTitle();
            body  = new String(body.toString().getBytes("ISO8859-1"),"UTF-8");
            paraMap.put("body", body);
//            商户id
            paraMap.put("mch_id", mchId);
            paraMap.put("nonce_str", WXPayUtil.generateNonceStr());
            paraMap.put("openid", openId);
//            paraMap.put("openid", "ogiDYs13i0uirzjket3XBIUMhRbc");
//            paraMap.put("out_trade_no", 你的订单号);//订单号
            String orderSn = order.getOrderSn();
            paraMap.put("out_trade_no", orderSn);//订单号
            paraMap.put("spbill_create_ip", ip);
//            价格为
            BigDecimal orderTotalPrice = order.getOrderTotalPrice();
//        获取比例
            Ratio ratio = ratioService.selectOne();
            String ratioRatio = ratio.getRatioRatio();
            BigDecimal bigDecimal = new BigDecimal(ratioRatio);
//          换算为金钱元
          orderTotalPrice = orderTotalPrice.divide(bigDecimal);
//          换算为分
            orderTotalPrice=orderTotalPrice.multiply(new BigDecimal(100));
          String totalFee=orderTotalPrice+"";
            paraMap.put("total_fee", totalFee);
            paraMap.put("trade_type", "JSAPI");
            paraMap.put("notify_url", "http://xiwanji.91xiaokong.com/pay/callback");// 此路径是微信服务器调用支付结果通知路径随意写
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
            String paySign = WXPayUtil.generateSignature(payMap,paternerKey);
            payMap.put("paySign", paySign);
            log.error("支付使用的xml"+WXPayUtil.mapToXml(payMap));
            return payMap;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
    /**
     *  查询订单
     * @return
     */
    @RequestMapping(value = "selectOrder", method = RequestMethod.GET)
    @ResponseBody
    public Map selectOrder(){
//        appid mch_id transaction_id out_trade_no nonce_str sign sign_type
//        https://api.mch.weixin.qq.com/pay/orderquery
        try {
            Map<String, String> paraMap = new TreeMap<String, String>();
            paraMap.put("appid",appid);
            paraMap.put("mch_id",mchId);
            paraMap.put("nonce_str",WXPayUtil.generateNonceStr());
            paraMap.put("out_trade_no","201901120456");
            String  sign = WXPayUtil.generateSignature(paraMap, paternerKey);
            paraMap.put("sign",sign);
            String xml = WXPayUtil.mapToXml(paraMap);//将所有参数(map)转xml格式
            log.error("查询订单参数"+xml);
            String orderquery_url = "https://api.mch.weixin.qq.com/pay/orderquery";
            String xmlStr = HttpRequest.sendPost(orderquery_url, xml);//发送post请求"查询订单"
            log.error("查询订单结果"+xmlStr);
            Map<String, String> stringStringMap = WXPayUtil.xmlToMap(xmlStr);
            return stringStringMap;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
    /**
     *  申请退款
     *  1、交易时间超过一年的订单无法提交退款
     2、微信支付退款支持单笔交易分多次退款，多次退款需要提交原支付订单的商户订单号和设置不同的退款单号。申请退款总金额不能超过订单金额。 一笔退款失败后重新提交，请不要更换退款单号，请使用原商户退款单号
     3、请求频率限制：150qps，即每秒钟正常的申请退款请求次数不超过150次错误或无效请求频率限制：6qps，即每秒钟异常或错误的退款申请请求不超过6次
     4、每个支付订单的部分退款次数不能超过50次
     * @return
     */
    @RequestMapping(value = "refund", method = RequestMethod.GET)
    @ResponseBody
    public Map refund(){
//        appid mch_id nonce_str   out_trade_no out_refund_no  total_fee refund_fee sign
//        https://api.mch.weixin.qq.com/secapi/pay/refund
        /*try {
            Map<String, String> paraMap = new TreeMap<String, String>();
            paraMap.put("appid",appid);
            paraMap.put("mch_id",mchId);
            paraMap.put("nonce_str",WXPayUtil.generateNonceStr());
            paraMap.put("out_trade_no","201901120456");
            paraMap.put("out_refund_no","201901120456");
            paraMap.put("total_fee","1");
            paraMap.put("refund_fee","1");
            String  sign = WXPayUtil.generateSignature(paraMap, paternerKey);
            paraMap.put("sign",sign);
            String xml = WXPayUtil.mapToXml(paraMap);//将所有参数(map)转xml格式
            log.error("查询订单参数"+xml);
            String orderquery_url = "https://api.mch.weixin.qq.com/pay/orderquery";
            String xmlStr = HttpRequest.sendPost(orderquery_url, xml);//发送post请求"查询订单"
            log.error("查询订单结果"+xmlStr);
            Map<String, String> stringStringMap = WXPayUtil.xmlToMap(xmlStr);
            return stringStringMap;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;*/
        Map<String,String> map=new HashMap<String,String>();
        WechatRefundApiResult result = WechatUtil.wxRefund("201901120456",
                1.00, 1.00);
        log.error("controller中退款数据："+result);
        if (result.getResult_code().equals("SUCCESS")) {
            map.put("msg","success");
        } else {
            map.put("msg","fail");
        }
        return map;
    }
}
