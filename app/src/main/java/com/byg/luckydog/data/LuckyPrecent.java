package com.byg.luckydog.data;

/**
 * @author NeoPi.
 * @date 2015/8/25
 */
public class LuckyPrecent {


    public static String[] jianzhi =
            {
                    "手气不好",             // 91-135   16%
                    "5",                  // 136-180   3%
                    "差一点点就中奖了",      // 181-225   20%
                    "20",                 // 226-270   0.5%
                    "你太给力了",           // 271-315   19%
                    "1" ,                 // 316-360    20%
                    "再来一次",            // 0-45      14%
                    "2"                   // 46-90      7.5%
            };


    /**
     * 中奖金额
     *
     */
    public static int[] zhongzhi =
            {
                    -5,  // 手气不好
                    5,
                    -20, // 就差一点点
                    20,
                    -1,  // 你太给力了
                    1,
                    -2,  // 再来一次
                    2
            };

    public static String[] jianzhimc=
            {
                    " ",
                    "金币",
                    " ",
                    "金币",
                    " ",
                    "金币",
                    " ",
                    "金币"
            }; // 价值名称;
}
