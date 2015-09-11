package com.byg.luckydog.module;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.DecelerateInterpolator;
import android.view.animation.RotateAnimation;
import android.widget.Button;
import android.widget.Toast;

import com.byg.luckydog.R;
import com.byg.luckydog.utils.LuckyUtils;
import com.byg.luckydog.widget.LuckyDogView;

/**
 * @author NeoPi
 * @date 2015/9/7
 * @TODO 用一句话描述这个类的作用
 */
public class OneFragment extends Fragment{

    private View rootView = null;
    private Button mBt = null;
    private LuckyDogView mLuckyView = null;

    private RotateAnimation anim = null;
    private static String TYPE_POSITION = "position";

    private int current = 0;  // 用于记录当前fragment是处于viewPager的第几个view


    public static OneFragment newInstance(int position) {

        OneFragment fragment = new OneFragment();
        Bundle mbundle = new Bundle();
        mbundle.putInt(TYPE_POSITION,position);
        fragment.setArguments(mbundle);
        return fragment;

    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        Bundle mb = getArguments();
        current = mb.getInt(TYPE_POSITION,0);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        if(rootView == null){
            rootView = inflater.inflate(R.layout.one_rmb,null);
            initView();

        } else {
            ViewGroup viewGroup = (ViewGroup) rootView.getParent();
            if (viewGroup != null) {
                viewGroup.removeAllViewsInLayout();
            }
        }

        return rootView;
    }

    /**
     * 初始化视图
     */
    private void initView() {
        mLuckyView = (LuckyDogView) rootView.findViewById(R.id.zview);
        mBt = (Button) rootView.findViewById(R.id.bt_start);

        mBt.setOnClickListener(mListener);
    }

    View.OnClickListener mListener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            switch (v.getId()) {
                case R.id.bt_start:
                    mBt.setEnabled(false);
                    startAround();
                    break;
            }
        }
    };

    /**
     * 开始旋转
     */
    private void startAround() {
        final float alphy = LuckyUtils.getRandom();
        mBt.clearAnimation();
        // 设置动画的旋转角度
        anim = new RotateAnimation(0f,8*360+alphy,
                Animation.RELATIVE_TO_SELF,0.5f,Animation.RELATIVE_TO_SELF,0.5f);
        DecelerateInterpolator interpolator = new DecelerateInterpolator();
        anim.setInterpolator(interpolator);
        anim.setDuration(4*1000);
        anim.setFillAfter(true);
        mBt.startAnimation(anim);

        anim.setAnimationListener(new Animation.AnimationListener() {
            @Override
            public void onAnimationStart(Animation animation) {
                Toast.makeText(getActivity(), "开始抽奖，祝你好运", Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onAnimationEnd(Animation animation) {
                LuckyUtils.showEndToast(getActivity(),alphy);
                mBt.setEnabled(true);
            }
            @Override
            public void onAnimationRepeat(Animation animation) {

            }
        });
    }
}
