package com.byg.luckydog;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.ActionBarActivity;
import android.support.v7.app.ActionBar;
import android.support.v4.app.FragmentManager;
import android.os.Bundle;
import android.support.v4.widget.DrawerLayout;
import android.util.Log;

import com.byg.luckydog.module.LuckyDogFragment;

public class MainActivity extends ActionBarActivity implements NavigationDrawerFragment.NavigationDrawerCallbacks {


    private static String TAG = MainActivity.class.getSimpleName();
    /**
     * Fragment managing the behaviors, interactions and presentation of the navigation drawer.
     */
    private NavigationDrawerFragment mNavigationDrawerFragment;

    /**
     * Used to store the last screen title. For use in {@link #restoreActionBar()}.
     */
    private CharSequence mTitle;

    private Fragment mCurrentFragment = null; // 记录当前展示的fragment

    private FragmentManager mFManager = null;  // fragment 管理者
    private Bundle bundle = new Bundle();
    private String mCurFragName = "";          // 当前fragment的标题

    private Fragment mLuckyDogFragmnet = null;        // 展示抽奖转盘的Fragment
    private Fragment mPlaceholderFragment = null;

    private static String INDEX_LUCKYDOG = "lucky_dog";
    private static String INDEX_CONGZHI = "cong_zhi";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mNavigationDrawerFragment = (NavigationDrawerFragment)
                getSupportFragmentManager().findFragmentById(R.id.navigation_drawer);
        mTitle = getTitle();

        // Set up the drawer.
        mNavigationDrawerFragment.setUp(
                R.id.navigation_drawer,
                (DrawerLayout) findViewById(R.id.drawer_layout));

        initFragment(INDEX_LUCKYDOG);
    }

    @Override
    public void onNavigationDrawerItemSelected(int position) {
        Log.i("123", "Positons:" + position);
        switch (position){
            case 0:
                initFragment(INDEX_LUCKYDOG);
                break;
            case 1:
                initFragment(INDEX_CONGZHI);
                break;
        }

    }

    private void initFragment(String index) {
        if (INDEX_LUCKYDOG .equals(index)){
            if (mLuckyDogFragmnet == null){
                mLuckyDogFragmnet = LuckyDogFragment.newInstance(0);
            }
            showFragment(mLuckyDogFragmnet,INDEX_LUCKYDOG);
        }else if (INDEX_CONGZHI.equals(index)){
            if (mPlaceholderFragment == null){
                mPlaceholderFragment = PlaceholderFragment.newInstance(1);
            }
            showFragment(mPlaceholderFragment,INDEX_CONGZHI);
        }
    }


    private void showFragment(Fragment fragment, String destTab) {

        try {
            if (mCurrentFragment == fragment) {
                return;
            }
            if (mFManager == null) {
                mFManager = getSupportFragmentManager();
            }
            FragmentTransaction mFTransaction = mFManager.beginTransaction();

            Fragment frag = mFManager.getFragment(bundle, destTab);
            if (null != mCurrentFragment) {
                mFManager.saveFragmentInstanceState(mCurrentFragment);
                mFManager.putFragment(bundle, mCurFragName, mCurrentFragment);
            }
            if (null != frag) {
                Log.d("123", "Use saved Fragment");
                mFTransaction.attach(frag);
            } else {
                Log.d("123", "Create New Fragment");
                mFTransaction.add(R.id.container, fragment);
            }
            if (mCurrentFragment != null) {
                mFTransaction.detach(mCurrentFragment);
            }

            mFTransaction.commitAllowingStateLoss();
            mFManager.executePendingTransactions();

            mCurrentFragment = fragment;
            mCurFragName = destTab;

        } catch (Exception e) {
            Log.e("123", "showFragment Exception --> " + e.toString());
            e.printStackTrace();
        }

    }

    public void onSectionAttached(int number) {
        switch (number) {
            case 1:
                mTitle = getString(R.string.title_section1);
                break;
            case 2:
                mTitle = getString(R.string.title_section2);
                break;
        }
    }

    public void restoreActionBar() {
        ActionBar actionBar = getSupportActionBar();
        actionBar.setNavigationMode(ActionBar.NAVIGATION_MODE_STANDARD);
        actionBar.setDisplayShowTitleEnabled(true);
        actionBar.setTitle(mTitle);
    }

}
