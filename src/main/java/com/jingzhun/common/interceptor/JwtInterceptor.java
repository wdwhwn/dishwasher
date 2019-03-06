package com.jingzhun.common.interceptor;

import com.jingzhun.common.exception.zdy.UserLoginException;
import com.jingzhun.service.UserService;
import com.jingzhun.utils.token.JwtUtil;
import io.jsonwebtoken.Claims;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import javax.servlet.http.HttpServletRequest;

import javax.servlet.http.HttpServletResponse;

//@Component
public class JwtInterceptor extends HandlerInterceptorAdapter {

        @Override
        public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
            String token = request.getParameter("token");
//            String token = request.getHeader("token");
                if (token == null ) {
                    throw new UserLoginException("用户未登录");
                }
            //验证token
            Claims claims=JwtUtil.checkToken(token);
            request.setAttribute("userName",claims.getSubject());
                return true;
        }

}
