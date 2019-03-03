package com.jingzhun.utils.token;

import com.auth0.jwt.JWTSigner;
import com.auth0.jwt.JWTVerifier;
import com.auth0.jwt.internal.com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by Administrator on 2019/3/1 0001.
 */
public class JwtUtil1 {
    /**
     * 密钥
     */
    private static final String SECRET = "xxxx";
    /**
     * 默认字段key:exp
     */
    private static final String EXP = "exp";
    /**
     * 默认字段key:payload
     */
    private static final String PAYLOAD = "payload";

    /**
     * 加密
     *
     * @param object  加密数据
     * @param maxTime 有效期（毫秒数）
     * @param <T>
     * @return
     */
    public static <T> String encode(T object, long maxTime) {
        try {
            final JWTSigner signer = new JWTSigner(SECRET);
            final Map<String, Object> data = new HashMap<String, Object>(10);
            ObjectMapper objectMapper = new ObjectMapper();
            String jsonString = objectMapper.writeValueAsString(object);
            data.put(PAYLOAD, jsonString);
            data.put(EXP, System.currentTimeMillis() + maxTime);
            return signer.sign(data);
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }

    /**
     * 数据解密
     *
     * @param jwt    解密数据
     * @param tClass 解密类型
     * @param <T>
     * @return
     */
    public static <T> T decode(String jwt, Class<T> tClass) {
        final JWTVerifier jwtVerifier = new JWTVerifier(SECRET);
        try {
            final Map<String, Object> data = jwtVerifier.verify(jwt);
            //判断数据是否超时或者符合标准
            if (data.containsKey(EXP) && data.containsKey(PAYLOAD)) {

                System.out.println(EXP);
                long exp=Long.valueOf(String.valueOf(EXP));
                long currentTimeMillis = System.currentTimeMillis();
                if (exp > currentTimeMillis) {
                    String json = (String) data.get(PAYLOAD);
                    ObjectMapper objectMapper = new ObjectMapper();
                    return objectMapper.readValue(json, tClass);
                }
            }
            return null;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public static class User {
        Integer id;
        String name;
        String password;

        public User() {
        }

        public User(Integer id, String name, String password) {
            this.id = id;
            this.name = name;
            this.password = password;
        }

        public Integer getId() {
            return id;
        }

        public void setId(Integer id) {
            this.id = id;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getPassword() {
            return password;
        }

        public void setPassword(String password) {
            this.password = password;
        }

        @Override
        public String toString() {
            return "User{" +
                    "id=" + id +
                    ", name='" + name + '\'' +
                    ", password='" + password + '\'' +
                    '}';
        }
    }

    public static void main(String[] args) {


        String encode = JwtUtil1.encode("wd", 1000);
        System.out.println(encode);
       /* String decode = JwtUtil1.decode(encode, String.class);
        System.out.println(decode);*/
    }
}
