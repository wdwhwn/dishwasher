package com.jingzhun.common.interceptor;

import com.jingzhun.service.UserService;
import com.jingzhun.utils.token.JwtUtil;
import io.jsonwebtoken.Claims;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import javax.servlet.http.HttpServletRequest;

import javax.servlet.http.HttpServletResponse;


public class JwtInterceptor extends HandlerInterceptorAdapter {
    @Autowired
    private UserService userServicel;
        @Override
        public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
                String token = request.getHeader("token");
                if (token == null ) {
                    return false;
                }
            //验证token
            Claims claims=JwtUtil.checkToken(token);

                return true;
        }

}
