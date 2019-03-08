package com.jingzhun.controller;

import com.jingzhun.utils.twodimensional.logo.ZXingCode;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.io.File;

/**
 * Created by Administrator on 2019/3/6 0006.
 */
@RestController
@CrossOrigin(origins ="*",maxAge = 3600)
public class AController {

    @RequestMapping("/a")
    public String a(){
        File logoFile = new File("images/logo.jpg");
//        File QrCodeFile=new File("G:/公司代码/王丹/业务代码/dishwasher2/src/main/webapp/images/1.jpg");
        File QrCodeFile=new File("images/","1.jpg");

//        File QrCodeFile =ResourceUtils.getFile("images/1.jpg");
        String url = "https://www.baidu.com/";
        String note = "设备A型";
       ZXingCode.drawLogoQRCode(logoFile, QrCodeFile, url, note);
       return QrCodeFile.getAbsolutePath();
    }
}
