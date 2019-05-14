<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2019/5/11 0011
  Time: 14:27
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<html>
<head>
    <title>Title</title>
    <script src="jquery/jquery-3.4.1.js"></script>
</head>
<body>
<%--<!—pay.jsp中点击”微信支付”按钮执行pay()方法>--%>
<input id="code"type="button" value="微信支付"onclick="pay()" code="${param.code}"/>
</body>
<script type="text/javascript" src="http://res.wx.qq.com/open/js/jweixin-1.0.0.js"></script>
<script type="text/javascript">
    var appId,timeStamp,nonceStr,package,signType,paySign;
    function pay(){
        var code = $("#code").attr("code");//页面链接上的code参数
        alert('请求的url为'+location.href.split('#')[0])
        alert(code);
        if(code){
//            var url = "http://异步地址?code="+code+";
            var url = "http://xiwanji.91xiaokong.com/pay/orders?code="+code;
            $.get(url,function(result) {
                appId = result.appId;
                timeStamp = result.timeStamp;
                nonceStr = result.nonceStr;
                package = result.package;
                signType = result.signType;
                paySign = result.paySign;
                alert("appid:"+appId);
                alert("timeStamp:"+timeStamp);
                alert("nonceStr:"+nonceStr);
                alert("package:"+package);
                alert("signType:"+signType);
                alert("paySign:"+paySign);
                if (typeof WeixinJSBridge == "undefined") {
                    if (document.addEventListener) {
                        alert("1");
                        document.addEventListener('WeixinJSBridgeReady',
                            onBridgeReady, false);
                    } else if (document.attachEvent) {
                        alert("2");
                        document.attachEvent('WeixinJSBridgeReady',
                            onBridgeReady);
                        document.attachEvent('onWeixinJSBridgeReady',
                            onBridgeReady);
                    }
                } else {
                    alert("3");
                    onBridgeReady();
                }
            });
        } else {
            alert("服务器错误")
        }
    }
    function onBridgeReady(){
        WeixinJSBridge.invoke( 'getBrandWCPayRequest', {
                "appId":appId,     //公众号名称,由商户传入
                "timeStamp":timeStamp,         //时间戳,自1970年以来的秒数
                "nonceStr":nonceStr, //随机串
                "package":package,
                "signType":signType,         //微信签名方式：
                "paySign":paySign //微信签名
            },
            function(res){
            alert('res:'+JSON.stringify(res));
                if(res.err_msg == "get_brand_wcpay_request:ok" ) {
                    console.log('支付成功')
                    alert('支付成功');
                    //支付成功后跳转的页面
                }else if(res.err_msg == "get_brand_wcpay_request:cancel"){
                    console('支付取消');
                    alert.log('支付取消');
                }else if(res.err_msg == "get_brand_wcpay_request:fail"){
                    console.log('支付失败');
                    alert('支付失败');
//                    WeixinJSBridge.call('closeWindow');
                }else{
                    alert("测试结束");
                } //使用以上方式判断前端返回,微信团队郑重提示：res.err_msg将在用户支付成功后返回ok,但并不保证它绝对可靠。
            });
    }
</script>

</html>
