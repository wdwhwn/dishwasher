package com.jingzhun.utils.idrandom;

import java.util.Random;

/**
 * Created by Administrator on 2018/12/4.
 */
public class RandomNumber {


    /*public String returnCard(){
        String cardNnumer=getCard();//调用生成随机数的方法
        //生成的随机数进入数据库中查询一下，看时候有相同的。
        if(eCard != null){//如果有相同的数据
            return returnCard();//再次调用方法，生成一个随机数
        }else{//否则
            return cardNnumer;//这个数据我就要
        }
    }*/


    //生成随机数
    public static String getCard() {
        Random rand = new Random();//生成随机数
        String cardNnumer = "";
        for (int a = 0; a < 4; a++) {
            cardNnumer += rand.nextInt(10);//生成4位数字
        }
      /*  if(new Double(cardNnumer).doubleValue()<10000000d){
            getCard();
        }*/
        return cardNnumer;
    }

    //生成随机数
    public static int getRandomNum(int min,int max) {
        Random rand = new Random();//生成随机数

        return rand.nextInt(max)+min;
    }




    public static boolean isExit(Object count) {
        return count == null ? true : false;
    }

}
