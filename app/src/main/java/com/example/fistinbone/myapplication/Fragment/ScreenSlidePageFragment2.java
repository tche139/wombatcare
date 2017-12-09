package com.example.fistinbone.myapplication.Fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;

import com.example.fistinbone.myapplication.R;

import static com.example.fistinbone.myapplication.WomCare.CHOOSEN_WOMBAT;
import static com.example.fistinbone.myapplication.WomCare.CURRENT_LESSON;
import static com.example.fistinbone.myapplication.WomCare.PAGE_NUMBER;
import static com.example.fistinbone.myapplication.WomCare.PAGE_SIZE;

/**
 * Created by fistinbone on 8/18/2017.
 */

public class ScreenSlidePageFragment2 extends Fragment {
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View rootView =  inflater.inflate(
                R.layout.fragment_screen_slide_page2, container, false);


        ImageView imageView = (ImageView) rootView.findViewById(R.id.wombat_pic);
        LinearLayout linearLayout = (LinearLayout) rootView.findViewById(R.id.page2_hint);


        String wombat = CHOOSEN_WOMBAT;
        int lesson = CURRENT_LESSON;

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


        switch (wombat){
            case "wombat1":
                        switch (PAGE_NUMBER){
                            case 2:
                                imageView.setImageResource(R.drawable.cm_1);
                                break;
                            case 3:
                                imageView.setImageResource(R.drawable.cm_2);
                                break;
                            case 4:
                                imageView.setImageResource(R.drawable.cm_3);
                                break;
                        }

                        break;

            case "wombat2":

                        switch (PAGE_NUMBER){
                            case 2:
                                imageView.setImageResource(R.drawable.sw1);

                                break;
                            case 3:
                                imageView.setImageResource(R.drawable.sw2);
                                break;
                            case 4:
                                imageView.setImageResource(R.drawable.sw3);
                                break;
                        }

                        break;


            case "wombat3":
                        switch (PAGE_NUMBER){
                            case 2:
                                imageView.setImageResource(R.drawable.nw1);

                                break;
                            case 3:
                                imageView.setImageResource(R.drawable.nw2);
                                break;
                            case 4:
                                imageView.setImageResource(R.drawable.nw3);
                                break;
                        }

                        break;
        }



        return rootView;
    }
}
