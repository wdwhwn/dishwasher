
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>测试</title>
    <script src="http://res.wx.qq.com/open/js/jweixin-1.4.0.js"></script>
    <script  >
        <%--这里建议ur参数不要写成固定地址，用提供的获取当前路径的方法获取--%>
//        var url 	 = location.href.split('#')[0];
        $(function(){
            var title    = $("#title").val();
            var desc   	 = $("#desc").val();
            var name   	 = $("#program_name").val();
            var imgUrl   = $("#imgurl").val();
            var path	 = $("#path").val();
            var url 	 = location.href.split('#')[0];

            var signature,timestamp,noncestr,appid;

            /*微信分享*/
            $.ajax({
                url:path+"/weiXinShare",
                type:'GET',
                data:{
                    url : url
                },
                success:function (data) {
                    signature = data.weixinShare.wx_signature;
                    timestamp = data.weixinShare.wx_timestamp;
                    noncestr = data.weixinShare.wx_noncestr;
                    appid = data.appid;
                    wx.config({
                        debug: false, // 开启调试模式,调用的所有api的返回值会在客户端alert出来，若要查看传入的参数，可以在pc端打开，参数信息会通过log打出，仅在pc端时才会打印。
                        appId: appid, // 必填，公众号的唯一标识
                        timestamp: timestamp, // 必填，生成签名的时间戳
                        nonceStr: noncestr, // 必填，生成签名的随机串
                        signature: signature,// 必填，签名
                        jsApiList: ['onMenuShareAppMessage','onMenuShareTimeline'] // 必填，需要使用的JS接口列表
                    });

                    wx.ready(function(){
                        //分享给朋友
                        wx.onMenuShareAppMessage({
                            title: title, // 分享标题
                            desc: desc, // 分享描述
                            link: path, // 分享链接，该链接域名或路径必须与当前页面对应的公众号JS安全域名一致
                            imgUrl:imgUrl, // 分享图标s
                            type: 'link', // 分享类型,music、video或link，不填默认为link
                            dataUrl: '', // 如果type是music或video，则要提供数据链接，默认为空
                            success: function () {
                                // 用户确认分享后执行的回调函数
//	    					 alert("OK");
                            },
                            cancel: function () {
                                // 用户取消分享后执行的回调函数
//	    					 alert("fail");
                            }
                        });
                        //分享给朋友圈
                        wx.onMenuShareTimeline({
                            title: title, // 分享标题
                            link: path, // 分享链接，该链接域名或路径必须与当前页面对应的公众号JS安全域名一致
                            imgUrl: imgUrl, // 分享图标
                            success: function () {
                                // 用户确认分享后执行的回调函数
                            },
                        });
                    });
                },
                error:function(error){
                    console.log(error);
                }
            });
        })
    </script>
</head>
<body>
欢迎

</body>
</html>
