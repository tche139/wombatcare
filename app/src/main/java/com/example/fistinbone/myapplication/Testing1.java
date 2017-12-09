package com.example.fistinbone.myapplication;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.view.MotionEvent;
import android.view.View;

import com.example.fistinbone.myapplication.Fragment.CongratulationFragment;
import com.example.fistinbone.myapplication.Fragment.ConstructionFragment;
import com.example.fistinbone.myapplication.Fragment.MyStory2;
import com.example.fistinbone.myapplication.Fragment.TestFragment1;

import static com.example.fistinbone.myapplication.WomCare.PAGE_NUMBER;
import static com.example.fistinbone.myapplication.WomCare.PAGE_SIZE;
import static com.example.fistinbone.myapplication.WomCare.testCompleted;

/**
 * Created by fistinbone on 8/18/2017.
 */

public class Testing1 extends AppCompatActivity {
    private static final int NUM_PAGES = 4;
    private ViewPager mPager;
    private PagerAdapter mPagerAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_screen_slide);

        testCompleted = 0;

        mPager = (ViewPager) findViewById(R.id.pager);
        mPagerAdapter = new ScreenSlidePagerAdapter(getSupportFragmentManager());
        mPager.setAdapter(mPagerAdapter);
        PAGE_SIZE = NUM_PAGES;
        mPager.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                return true;
            }
        });
    }

    private class ScreenSlidePagerAdapter extends FragmentStatePagerAdapter {
        public ScreenSlidePagerAdapter(FragmentManager fm) {super(fm);}


        //set diaplay to each page
        @Override
        public Fragment getItem(int position) {
            switch (position) {
                case 0:
                    PAGE_NUMBER = 1;
                    return new MyStory2();
                case 1:
                    PAGE_NUMBER = 2;
                    return new TestFragment1();
                case 2:
                    PAGE_NUMBER = 3;
                    return new TestFragment1();
                case 3:
                    return new CongratulationFragment();
                default:
                    return new ConstructionFragment();
            }
        }

        //get number of pages
        @Override
        public int getCount() {
            return NUM_PAGES;
        }
    }
}
