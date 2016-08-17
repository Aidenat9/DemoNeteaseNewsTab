package com.tianmu.demoneteasenewstab;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.Window;
import android.widget.Toast;

import com.viewpagerindicator.TabPageIndicator;

public class HomeActivity extends FragmentActivity {
    /**
     * Tab标题
     * 写完最后记得在清单文件里配置activity的主题和label,或者修改application的主题样式,
     * 默认的主题样式PageIndicatorDefaults
     */
    private static final String[] TITLE = new String[]{"头条", "房产", "另一面", "女人",
            "财经", "数码", "情感", "科技"};
    private ViewPager viewPager;
    private TabPageIndicator indicator;
    private TabPageIndicatorAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.activity_home);
        initView();
        initAdapter();
        doView();
    }

    private void doView() {
        viewPager.setAdapter(adapter);
        //实例化TabPageIndicator然后设置ViewPager与之关联
        indicator.setViewPager(viewPager);
        //如果我们要对ViewPager设置监听，用indicator设置就行了
        indicator.setOnPageChangeListener(pageListener);

    }
   private ViewPager.OnPageChangeListener pageListener =  new ViewPager.OnPageChangeListener(){

       @Override
       public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {
       }

       @Override
       public void onPageSelected(int position) {
           Toast.makeText(HomeActivity.this, TITLE[position], Toast.LENGTH_SHORT).show();

       }

       @Override
       public void onPageScrollStateChanged(int state) {

       }
   };

    private void initAdapter() {
        adapter = new TabPageIndicatorAdapter(getSupportFragmentManager());

    }

    private void initView() {

        viewPager = (ViewPager) findViewById(R.id.viewPager);
        indicator = (TabPageIndicator) findViewById(R.id.indicator);
    }

    private class TabPageIndicatorAdapter extends FragmentPagerAdapter {
        public TabPageIndicatorAdapter(FragmentManager fm) {
            super(fm);

        }



        @Override
        public Fragment getItem(int position) {
            ItemFragment itemFragment = new ItemFragment();
            Bundle args = new Bundle();
            args.putString("arg",TITLE[position]);
            itemFragment.setArguments(args);

            return itemFragment;
        }

        @Override
        public CharSequence getPageTitle(int position) {
            return TITLE[position % TITLE.length];
        }

        @Override
        public int getCount() {
            return TITLE.length;
        }
    }
}
