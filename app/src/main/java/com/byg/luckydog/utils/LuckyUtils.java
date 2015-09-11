package com.byg.luckydog.utils;

import android.content.Context;

import com.byg.luckydog.data.LuckyPrecent;

/**
 * @author NeoPi.
 * @date 2015/8/25
 */
public class LuckyUtils {


    private static float TYPE = 22.5f;

    /**
     * 在抽奖结束后提示中奖信息
     */
    public static void showEndToast(Context context, float i) {
        if (i >= 90 && i < 135){
            ToastUtils.show(context, "哎哟，手气不好！！");
        } else if (i > 135 && i< 180){ // 5G
            ToastUtils.show(context, "恭喜你，中奖" + LuckyPrecent.jianzhi[1] + LuckyPrecent.jianzhimc[1]);
        } else if (i > 180 && i< 225){
            ToastUtils.show(context, "哎哟，就差一点点啦！！");
        } else if (i > 225 && i < 270){ // 20G
            ToastUtils.show(context, "恭喜你，中大奖" + LuckyPrecent.jianzhi[3] + LuckyPrecent.jianzhimc[3]);
        } else if (i > 270 && i < 315){
            ToastUtils.show(context, "哎哟，你太给力了！！");
        } else if (i > 315 && i < 360){ // 1G
            ToastUtils.show(context, "恭喜你，中奖" + LuckyPrecent.jianzhi[5] + LuckyPrecent.jianzhimc[5]);
        } else if (i > 0 && i < 45){
            ToastUtils.show(context, "亲，再来一次吧！！");
        } else {
            ToastUtils.show(context, "恭喜你，中奖" + LuckyPrecent.jianzhi[7] + LuckyPrecent.jianzhimc[7]);
        }
    }

    /**
     * 获取随机数
     * @return
     */

    public static float getRandom() {
        int i = 0;
        i = (int) (Math.random() * 1000);

        if (i >= 0 && i < 160){
            return TYPE * 5;
        } else if (i > 160 && i< 190){
            return TYPE * 7;
        } else if (i > 190 && i< 390){
            return TYPE * 9;
        } else if (i > 390 && i < 395){
            return TYPE * 11;
        } else if (i > 395 && i < 585){
            return TYPE * 13;
        } else if (i > 585 && i < 785){
            return TYPE * 15;
        } else if (i > 785 && i < 925){
            return TYPE * 1;
        } else {
            return TYPE * 3;
        }
    }
}
