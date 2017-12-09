package com.example.fistinbone.myapplication;

import android.animation.ObjectAnimator;
import android.animation.ValueAnimator;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.util.DisplayMetrics;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;

/**
 * Created by fistinbone on 8/29/2017.
 */

public class Event extends AppCompatActivity {
    ImageView info1,info2;
    DisplayMetrics metrics;
    Boolean info1_display = false, info2_display = false;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.find_them);
        getSupportActionBar().setTitle("Event");



        info1 = (ImageView) findViewById(R.id.info1);
        info2 = (ImageView) findViewById(R.id.info2);
    }

    //set up event extended page
    public static void anim(final View view, int startHeight, int endHeight, int duration){
        ObjectAnimator anim = ObjectAnimator.ofInt(view, view.toString(), startHeight,endHeight ).setDuration(duration);
        anim.start();
        anim.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
            @Override
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                int cVal = (int) valueAnimator.getAnimatedValue();
                LinearLayout.LayoutParams lp = (LinearLayout.LayoutParams) view.getLayoutParams();
                lp.height = cVal;
                view.setLayoutParams(lp);
            }
        });
    }


    //set event onclick to expand
    public void onClick(View v) {
        metrics = getResources().getDisplayMetrics();
        int x = (int)(419*metrics.density);
        switch (v.getId()){
            case R.id.find_item1:
                if (info2_display) {
                    anim(info2, x, 0, 300);
                    info2_display = !info2_display;
                }
                if (!info1_display) {
                    anim(info1, 0, x, 300);
                } else {
                    anim(info1,x,0,300);
                }
                info1_display = !info1_display;
                break;
            case R.id.find_item2:
                if(info1_display) {
                    anim(info1, x, 0, 300);
                    info1_display = !info1_display;
                }
                if (!info2_display) {
                    anim(info2, 0, x, 300);
                } else {
                    anim(info2,x,0,300);
                }
                info2_display = !info2_display;
                break;
        }
    }

}
