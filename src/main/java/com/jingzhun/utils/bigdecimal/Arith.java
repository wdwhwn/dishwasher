package com.jingzhun.utils.bigdecimal;/**
 * Created by Administrator on 2018/8/22 0022.
 */

import java.math.BigDecimal;
import java.text.DecimalFormat;

/**
 * @program: FXMUST
 * @description:
 * @author: Zhanggs
 * @create: 2018-08-22 10:57
 **/
public class Arith {

    /**
     * 功能：BigDecimal类型的加法运算。
     * @param s1 被加数
     * @param s2 加数
     * @return 两个参数的和
     */
    public static double add(double s1, double s2)
    {
        BigDecimal b1 = new BigDecimal(Double.toString(s1));
        BigDecimal b2 = new BigDecimal(Double.toString(s2));
        return b1.add(b2).doubleValue();
    }

    /**
     * 功能：BigDecimal类型的减法运算。
     * @param s1 被减数
     * @param s2 减数
     * @return 两个参数的差
     */
    public static double sub(double s1, double s2)
    {
        BigDecimal b1 = new BigDecimal(Double.toString(s1));
        BigDecimal b2 = new BigDecimal(Double.toString(s2));
        return b1.subtract(b2).doubleValue();
    }

    /**
     * 功能：BigDecimal类型的乘法运算。
     * @param s1 被乘数
     * @param s2 乘数
     * @return 两个参数的积
     */
    public static double mul(double s1, double s2)
    {
        BigDecimal b1 = new BigDecimal(Double.toString(s1));
        BigDecimal b2 = new BigDecimal(Double.toString(s2));
        return round(b1.multiply(b2).doubleValue(),4);
    }


    /**
     * 功能：提供（相对）精确的除法运算。当发生除不尽的情况时，由scale参数指
     * 定精度，以后的数字四舍五入。
     * @param s1 被除数 (前面的)
     * @param s2 除数 	 (后面的)
     * @param scale 表示表示需要精确到小数点以后几位。
     * @return 两个参数的商
     */
    public static double div(double s1, double s2, int scale)
    {
        if (scale < 0)
        {
            throw new IllegalArgumentException("精确度不能小于0！");
        }

        BigDecimal b1 = new BigDecimal(Double.toString(s1));
        BigDecimal b2 = new BigDecimal(Double.toString(s2));
        return b1.divide(b2, scale, BigDecimal.ROUND_HALF_UP).doubleValue();
    }

    /**
     * 功能：提供精确的小数位四舍五入处理。
     * @param v 需要四舍五入的数字
     * @param scale 小数点后保留几位
     * @return 四舍五入后的结果
     */
    public static double round(double v, int scale) {
        if (scale < 0) {
            throw new IllegalArgumentException("精确度不能小于0！");
        }

        BigDecimal b = new BigDecimal(Double.toString(v));

        return b.setScale(scale,BigDecimal.ROUND_HALF_UP).doubleValue();
    }


    /**
     * 功能：提供精确的小数位向上取整处理。
     * @param v 需要向上取整的数字
     * @param scale 小数点后保留几位
     * @return 向上取整的结果
     */
    public static double roundUp(double v, int scale) {
        if (scale < 0) {
            throw new IllegalArgumentException("精确度不能小于0！");
        }

        BigDecimal b = new BigDecimal(Double.toString(v));

        return b.setScale(scale,BigDecimal.ROUND_UP).doubleValue();
    }


    /**
     * 功能：提供精确的小数位向上取整处理。
     * @param v 需要向上取整的数字
     * @return 向上取整的结果
     */
    public static String scale(double v) {
        DecimalFormat df = new DecimalFormat("0.00");
        return  df.format(v)+"";
    }


    /**
     * 功能：提供精确的小数位格式化。
     * @param v 格式化的数字
     * @return 格式化的结果
     */
    public static String scaleFour(BigDecimal v) {
        DecimalFormat df = new DecimalFormat("0.0000");
        return  df.format(v)+"";
    }


}
