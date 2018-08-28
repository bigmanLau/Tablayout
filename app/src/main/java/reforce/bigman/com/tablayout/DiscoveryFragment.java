package reforce.bigman.com.tablayout;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;


import com.flyco.tablayout.listener.OnTabSelectListener;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import reforce.bigman.com.customtablayout.CustomSlidingTablayout;

/**
 * 发现页
 */
public class DiscoveryFragment extends Fragment {


    ViewPager mViewPager;


    CustomSlidingTablayout mTabLayout;

    private List<Fragment> mFragments;

    private List<String> mTitles = new ArrayList<>();

    private ArrayList<String> mTabEntities = new ArrayList<>();

    public static DiscoveryFragment newInstance() {
        DiscoveryFragment fragment = new DiscoveryFragment();
        return fragment;
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = LayoutInflater.from(getActivity()).inflate(R.layout.fragment_discovery, container,false);
        ButterKnife.bind(this, view);
        return view;

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

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        mTabEntities.clear();

        for (int i = 0; i < 10; i++) {
            mTabEntities.add("测试");
        }
        initViewPager();
        setUpTabLayout();
    }

    private void initViewPager() {
        mViewPager=getView().findViewById(R.id.view_pager);
        mTabLayout=getView().findViewById(R.id.tab_layout);
        mFragments = new ArrayList<>();
        String[] array = new String[mTabEntities.size()];
        for (int i = 0; i < mTabEntities.size(); i++) {
            array[i] = mTabEntities.get(i);
            mFragments.add(TradeFragmentFragment.newInstance());
        }

        mViewPager.setAdapter(new MyPagerAdapter(getChildFragmentManager()));
        mTabLayout.setViewPager(mViewPager, array);


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
            return (Fragment) mFragments.get(position);
        }

    }


}
