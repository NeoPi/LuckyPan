package com.byg.luckydog.utils;

import android.content.Context;
import android.widget.Toast;

/**
 * @author NeoPi.
 * @date 2015/8/24
 */
public class ToastUtils {

    public static Toast mToast = null;


    /**
     *
     * @param mctx
     * @param sequence
     * @param time
     */
    public synchronized static void show(Context mctx,CharSequence sequence,int time){
        if (mctx == null){
            return ;
        }
        if (mToast == null){
            mToast = Toast.makeText(mctx, sequence, time);
        } else {
            mToast.setText(sequence);
            mToast.setDuration(time);
        }
        mToast.show();
    }

    /**
     *
     * @param mctx
     * @param id
     * @param time
     */
    public synchronized static void show(Context mctx,int id,int time){
        if (mctx == null){
            return ;
        }
        if (mToast == null){
            mToast = Toast.makeText(mctx, id, time);
        } else {
            mToast.setText(id);
            mToast.setDuration(time);
        }
        mToast.show();
    }

    /**
     *
     * @param mctx
     * @param id
     */
    public synchronized static void show(Context mctx,int id){
        if (mctx == null){
            return ;
        }
        if (mToast == null){
            mToast = Toast.makeText(mctx, id, Toast.LENGTH_SHORT);
        } else {
            mToast.setText(id);
            mToast.setDuration(Toast.LENGTH_SHORT);
        }
        mToast.show();
    }

    /**
     *
     * @param mctx
     * @param str
     */
    public synchronized static void show(Context mctx,String str){
        if (mctx == null){
            return ;
        }
        if (mToast == null){
            mToast = Toast.makeText(mctx, str, Toast.LENGTH_SHORT);
        } else {
            mToast.setText(str);
            mToast.setDuration(Toast.LENGTH_SHORT);
        }
        mToast.show();
    }
}
