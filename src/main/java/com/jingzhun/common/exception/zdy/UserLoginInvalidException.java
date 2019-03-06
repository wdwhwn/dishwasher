package com.jingzhun.common.exception.zdy;

/**
 * Created by Administrator on 2019/3/4 0004.
 */
public class UserLoginInvalidException extends RuntimeException{
    public UserLoginInvalidException() {
    }

    public UserLoginInvalidException(String message) {
        super(message);
    }
}
