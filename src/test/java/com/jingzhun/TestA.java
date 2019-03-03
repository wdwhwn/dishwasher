package com.jingzhun;

/**
 * Created by Administrator on 2019/2/28 0028.
 */
import com.jingzhun.utils.properties.PropertiesUtil;
import org.eclipse.jdt.internal.compiler.lookup.SourceTypeBinding;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class TestA {
    public static void main(String[] args) throws IOException {
        String url = PropertiesUtil.readValue("src/main/resources/url.properties", "url_local");
        System.out.println("中文");
        System.out.println(url);
    }

}