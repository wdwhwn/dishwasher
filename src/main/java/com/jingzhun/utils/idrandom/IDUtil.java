package com.jingzhun.utils.idrandom;

import java.util.Random;
import java.util.UUID;

/**
 * Created by Administrator on 2018/12/7 0007.
 */
public class IDUtil {

    private static final Random torrent = new Random();

    private static final String chars = "abcdefghijklmnopqrstuvwxyz";
    /**
     * 返回一个32位的唯一ID串
     * @return
     */
    public static String RANDOM32(){
        String uid = UUID.randomUUID().toString();
        uid = uid.replaceAll("-", "").toLowerCase();
        if(Character.isDigit(uid.charAt(0))){
            uid = chars.charAt((int)(Math.random() * 26)) + uid.substring(1);
        }
        return uid;
    }
    /**
     * 返回一个64位的唯一ID串
     * @return
     */
    public static String RANDOM64(){
        return RANDOM32() + RANDOM32();
    }

    /**
     * 返回一个128位的唯一ID串
     * @return
     */
    public static String RANDOM128(){
        return RANDOM64() + RANDOM64();
    }

    public synchronized static Long RANDOM(){
        return torrent.nextLong();
    }

    public static void main(String a[]){
        for(int i=0;i<54;i++){
            System.out.println(IDUtil.RANDOM128());
        }
    }

    /**
     * 获取范围内指定随机数
     * @param min
     * @param max
     * @return
     */
    public static int getRandom(int min, int max){
        Random random = new Random();
        int s = random.nextInt(max) % (max - min + 1) + min;
        return s;

    }
}
