package com.example.fistinbone.myapplication.Fragment;

import android.graphics.Typeface;
import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.fistinbone.myapplication.R;

import static com.example.fistinbone.myapplication.WomCare.CHOOSEN_WOMBAT;
import static com.example.fistinbone.myapplication.WomCare.CURRENT_LESSON;
import static com.example.fistinbone.myapplication.WomCare.PAGE_NUMBER;
import static com.example.fistinbone.myapplication.WomCare.PAGE_SIZE;

/**
 * Created by fistinbone on 8/18/2017.
 */

public class ScreenSlidePageFragment3 extends Fragment {
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        View rootView = inflater.inflate(
                R.layout.fragment_screen_slide_page3, container, false
        );

        ImageView imageView = (ImageView) rootView.findViewById(R.id.distribution_I);
        TextView tv1 = (TextView) rootView.findViewById(R.id.distribution_Q);
        TextView tv2 = (TextView) rootView.findViewById(R.id.distibution_A);
        LinearLayout linearLayout = (LinearLayout) rootView.findViewById(R.id.page3_hint);


        Typeface customFont = Typeface.createFromAsset(this.getContext().getAssets(),"fonts/fontStyle1.ttf");
        tv1.setTypeface(customFont,Typeface.BOLD);
        tv2.setTypeface(customFont);


        String wombat = CHOOSEN_WOMBAT;
        int lesson = CURRENT_LESSON;

        switch (wombat){
            case "wombat1":
                switch (lesson){
                    case 5:
                        imageView.setImageResource(R.drawable.commonwombat_rangemap);
                        tv1.setText(R.string.wombat1_lesson5D_Q1);
                        tv2.setText(R.string.wombat1_lesson5D_A1);
                        break;
                }
                break;
            case "wombat2":
                imageView.setImageResource(R.drawable.commonwombat_rangemap);
                tv1.setText(R.string.wombat2S_lesson5D_Q1);
                tv2.setText(R.string.wombat2S_lesson5D_A1);
                break;
            case "wombat3":
                imageView.setImageResource(R.drawable.commonwombat_rangemap);
                tv1.setText(R.string.wombat3N_lesson5D_Q1);
                tv2.setText(R.string.wombat3N_lesson5D_A1);
                break;
        }

        float factor = rootView.getContext().getResources().getDisplayMetrics().density;
        linearLayout.removeAllViews();
        for (int i = 0; i < PAGE_SIZE; i++) {
            ImageView imageView_ = new ImageView(rootView.getContext());
            if (PAGE_NUMBER == i+1){
                imageView_.setImageResource(R.drawable.hint);
                int height = (int)(30*factor);
                int width = (int)(50*factor);
                imageView_.setLayoutParams(new ViewGroup.LayoutParams(height,width));
            }else {
                imageView_.setImageResource(R.drawable.hint_shade);
                int height = (int)(20*factor);
                int width = (int)(50*factor);
                imageView_.setLayoutParams(new ViewGroup.LayoutParams(height,width));//图片资源
            }
            imageView_.setPadding(15,0,15,0);
            linearLayout.addView(imageView_); //动态添加图片
        }

        return rootView;
    }
}

