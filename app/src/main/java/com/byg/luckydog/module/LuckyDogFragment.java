package com.byg.luckydog.module;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;

import com.byg.luckydog.R;

/**
 * @author NeoPi
 * @date 2015/9/7
 * @TODO 用一句话描述这个类的作用
 */
public class LuckyDogFragment extends Fragment{

    private View mRootView = null;

    private ViewPager mPager = null;
    private LinearLayout mLL = null;
    private LuckyDogFragmentAdapter fAdapter = null;

    private static String TYPE_POSITION = "position";

    private int current = 0;  // 用于记录当前fragment是处于viewPager的第几个view

    private static LuckyDogFragment fragment = null;
    public static LuckyDogFragment newInstance(int position) {

        if (fragment == null) {
            fragment = new LuckyDogFragment();
        }
        Bundle mbundle = new Bundle();
        mbundle.putInt(TYPE_POSITION,position);
        fragment.setArguments(mbundle);
        return fragment;

    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        Bundle mbund = getArguments();
        current = mbund.getInt(TYPE_POSITION);

        Log.d("123","current:"+current);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        if (mRootView == null){
            mRootView = inflater.inflate(R.layout.fragment_lucydog,null);

            initView();
            mPager.setCurrentItem(3); // 设置viewpager默认显示的item
        } else {
            ViewGroup  mviewGroup = (ViewGroup) mRootView.getParent();
            if (mviewGroup != null){
                mviewGroup.removeAllViewsInLayout();
            }
        }

        return mRootView;
    }

    /**
     * 初始化视图
     */
    private void initView() {

        FragmentManager fm =getFragmentManager();
        fAdapter = new LuckyDogFragmentAdapter(fm);

        mPager = (ViewPager) mRootView.findViewById(R.id.viewPager);
        mLL = (LinearLayout) mRootView.findViewById(R.id.dot_ll);


        mPager.setAdapter(fAdapter);
    }

    class LuckyDogFragmentAdapter extends FragmentPagerAdapter{

        public LuckyDogFragmentAdapter(FragmentManager fm) {
            super(fm);
        }

        @Override
        public Fragment getItem(int position) {
            return OneFragment.newInstance(position);
        }

        @Override
        public int getCount() {
            return 6;
        }
    }
}
