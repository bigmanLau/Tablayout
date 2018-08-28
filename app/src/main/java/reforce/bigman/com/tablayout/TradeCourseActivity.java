package reforce.bigman.com.tablayout;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;

import com.flyco.tablayout.listener.OnTabSelectListener;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import reforce.bigman.com.customtablayout.CustomSlidingTablayout;

public class TradeCourseActivity extends AppCompatActivity {


    CustomSlidingTablayout mTabLayout;


    ViewPager mViewPager;

    private ArrayList<Fragment> mFragments = new ArrayList<>();
    private ArrayList<String> mTabEntities = new ArrayList<>();
    private List<String> mTitles = new ArrayList<>();


    public static void openTradeCourseActivity(Activity activity) {
        Intent intent = new Intent(activity, TradeCourseActivity.class);
        activity.startActivity(intent);
    }


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_trade_course);
        initData();
    }


    public void initData() {
        mTabLayout=findViewById(R.id.tab_layout);
        mViewPager=findViewById(R.id.view_pager);
        initDatas();
        initViewPager();
    }

    private void initDatas() {
        mTabEntities.clear();
        mTitles.clear();
        mTitles.add("全部");
        mTabEntities.add("全部");
        for (int i = 0; i < 10; i++) {
            mTitles.add("测试");
            mTabEntities.add("测试");
        }
        setUpTabLayout();
    }


    private void initViewPager() {

        String[] array = new String[mTitles.size()];
        for (int i = 0; i < mTitles.size(); i++) {
            array[i] = mTitles.get(i);
            mFragments.add(BlankFragment.newInstance());
        }
        mViewPager.setAdapter(new MyPagerAdapter(getSupportFragmentManager()));
        mTabLayout.setViewPager(mViewPager, array);
        mViewPager.setOffscreenPageLimit(mTitles.size());

    }


    private class MyPagerAdapter extends FragmentPagerAdapter {
        public MyPagerAdapter(FragmentManager fm) {
            super(fm);
        }

        @Override
        public int getCount() {
            return mFragments.size();
        }

        @Override
        public CharSequence getPageTitle(int position) {
            return mTitles.get(position);
        }

        @Override
        public Fragment getItem(int position) {
            return mFragments.get(position);
        }

    }


    private void setUpTabLayout() {

        mTabLayout.setOnTabSelectListener(new OnTabSelectListener() {
            @Override
            public void onTabSelect(int position) {

                mViewPager.setCurrentItem(position);
            }

            @Override
            public void onTabReselect(int position) {
            }
        });

        mViewPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) {
                mTabLayout.setCurrentTab(position);
            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });

    }


}
