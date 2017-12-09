package com.example.fistinbone.myapplication;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.view.ViewGroup;
import android.widget.LinearLayout;

import com.example.fistinbone.myapplication.Fragment.ConstructionFragment;
import com.example.fistinbone.myapplication.Fragment.FinishFragment;
import com.example.fistinbone.myapplication.Fragment.MyStory;
import com.example.fistinbone.myapplication.Fragment.ScreenSlidePageFragment1;

import static com.example.fistinbone.myapplication.WomCare.PAGE_NUMBER;
import static com.example.fistinbone.myapplication.WomCare.PAGE_SIZE;

/**
 * Created by fistinbone on 8/17/2017.
 */

public class Learning1 extends AppCompatActivity {

    private static final int NUM_PAGES = 4;
    private ViewPager mPager;
    private PagerAdapter mPagerAdapter;
    public LinearLayout hint;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_screen_slide);

        PAGE_SIZE = NUM_PAGES;
        mPager = (ViewPager) findViewById(R.id.pager);
        mPagerAdapter = new ScreenSlidePagerAdapter(getSupportFragmentManager());
        mPager.setAdapter(mPagerAdapter);

    }

    public class ScreenSlidePagerAdapter extends FragmentStatePagerAdapter {

        public ScreenSlidePagerAdapter(FragmentManager fm) {
            super(fm);
        }

        @Override
        // If we already have this item instantiated, there is nothing
        // to do.  This can happen when we are restoring the entire pager
        // from its saved state, where the fragment manager has already
        // taken care of restoring the fragments we previously had instantiated.
        public Object instantiateItem(ViewGroup container, int position) {
            return super.instantiateItem(container, position);
        }


        @Override
        //read the position and move to the right page
        public Fragment getItem(int position) {

            switch (position) {
                case 0:
                    PAGE_NUMBER = 1;
                    return new MyStory();
                case 1:
                    PAGE_NUMBER = 2;
                    return new ScreenSlidePageFragment1();
                case 2:
                    PAGE_NUMBER = 3;
                    return new ScreenSlidePageFragment1();
                case 3:
                    return new FinishFragment();
                default:
                    return new ConstructionFragment();
            }
        }

        @Override
        public int getCount() {
            return NUM_PAGES;
        }
    }


}
