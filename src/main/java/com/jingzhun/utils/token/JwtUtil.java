package com.jingzhun.utils.token;

import com.jingzhun.common.exception.zdy.UserLoginException;
import com.jingzhun.common.exception.zdy.UserLoginInvalidException;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.ExpiredJwtException;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

import javax.servlet.ServletException;
import java.util.Date;

/**
 * Created by Administrator on 2019/3/2 0002.
 */
public class JwtUtil {
    final static String base64EncodedSecretKey = "dishwasher";//私钥
    final static long TOKEN_EXP = 1000 * 60 * 10;//过期时间,测试使用十分钟 
    public static String getToken(String userName) {
        return Jwts.builder().setSubject(userName).claim("roles", "user").setIssuedAt(new Date()).setExpiration(new Date(System.currentTimeMillis() + TOKEN_EXP)) /*过期时间*/.signWith(SignatureAlgorithm.HS256, base64EncodedSecretKey).compact();
    }
    /**
     * 检查token,只要不正确就会抛出异常
     **/

    public static Claims checkToken(String token) throws ServletException {
         Claims claims=null;
        try {
            claims = Jwts.parser().setSigningKey(base64EncodedSecretKey).parseClaimsJws(token).getBody();
        } catch (ExpiredJwtException e1) {
            throw new UserLoginInvalidException("登录信息过期，请重新登录");
        } catch (Exception e) {
            throw new UserLoginException("用户未登录，请重新登录");
        }
        return claims;
    }
}

