package com.jingzhun.utils.weixinutils;

import com.jingzhun.entity.weixin.AccessToken;
import com.jingzhun.entity.weixin.Button;
import com.jingzhun.entity.weixin.Menu;
import com.jingzhun.entity.weixin.ViewButton;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * 菜单管理器类
 *
 * @author wd
 * @date
 */
public class MenuManager {
    private static Logger log = LoggerFactory.getLogger(MenuManager.class);

    public static void main(String[] args) {
        // 第三方用户唯一凭证
        String appId = "wx778f313eff0f980b";
        // 第三方用户唯一凭证密钥
        String appSecret = "910415b15c96d7268cc1ee899f5fc8cd";

        // 调用接口获取access_token
        AccessToken at = WeixinUtil.getAccessToken(appId, appSecret);

        if (null != at) {
            // 调用接口创建菜单
            int result = WeixinUtil.createMenu(getMenu(), at.getToken());

            // 判断菜单创建结果
            if (0 == result) {
                log.info("菜单创建成功！");
            }
            else {
                log.info("菜单创建失败，错误码：" + result);
            }
        }
    }

    /**
     * 组装自定义菜单
     * @return  Menu
     */
    public static Menu getMenu(){
        Menu menu=new Menu();
        ViewButton viewButton = new ViewButton();
        viewButton.setName("积分商城");
        viewButton.setType("view");
        viewButton.setUrl("http://xiwanji.91xiaokong.com");
        ViewButton viewButton1 = new ViewButton();
        viewButton1.setName("授权");
        viewButton1.setType("view");
        //viewButton.setUrl("http://myjava.ngrok.xiaomiqiu.cn/tomainpage");
//        viewButton1.setUrl("http://xiwanji.91xiaokong.com/wx/wxLogin");
//       viewButton.setUrl("http://xiwanji.91xiaokong.com");
        viewButton1.setUrl("https://open.weixin.qq.com/connect/oauth2/authorize?appid=wx778f313eff0f980b&redirect_uri=http://xiwanji.91xiaokong.com/tologin/userinfo&response_type=code&scope=snsapi_userinfo&state=1#wechat_redirect");



        Button button = new Button();
        button.setName("莱田洗碗机");
        button.setSub_button(new Button[]{viewButton,viewButton1});
        menu.setButton(new Button[]{button});
        return menu;
    }
}
