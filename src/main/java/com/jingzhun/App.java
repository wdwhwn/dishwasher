package com.jingzhun;


import com.github.pagehelper.PageHelper;
import org.apache.ibatis.plugin.Interceptor;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.annotation.MapperScan;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.support.SpringBootServletInitializer;
import org.springframework.context.annotation.Bean;

import java.util.Properties;

/**
 * Created by Administrator on 2019/2/26 0026.
 */
@SpringBootApplication
@MapperScan("com.jingzhun.dao")

public class App  extends SpringBootServletInitializer{
    public static void main(String[] args) {
        SpringApplication.run(App.class,args);
    }
    @Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder builder) {
        //此处的Application.class为带有@SpringBootApplication注解的启动类
        return builder.sources(App.class);
    }

}
