package com.example.fistinbone.myapplication.Fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;

import com.example.fistinbone.myapplication.R;

import static com.example.fistinbone.myapplication.WomCare.CHOOSEN_WOMBAT;
import static com.example.fistinbone.myapplication.WomCare.CURRENT_LESSON;
import static com.example.fistinbone.myapplication.WomCare.CURRENT_TEST;
import static com.example.fistinbone.myapplication.WomCare.PAGE_SIZE;

/**
 * Created by mafuyu on 1/9/17.
 */

public class MyStory2 extends Fragment {
    String wombat;
    int lesson;
    int testNum;
    Button button;
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.mystory,container,false);

        LinearLayout linearLayout = (LinearLayout) view.findViewById(R.id.mystory_layout);
        button =(Button) view.findViewById(R.id.starttest);
        ImageView image = (ImageView) view.findViewById(R.id.imageView11);
        button.setVisibility(View.VISIBLE);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ViewPager viewPager = (ViewPager) getActivity().findViewById(R.id.pager);
                viewPager.setCurrentItem(viewPager.getCurrentItem()+1);
            }
        });
        wombat = CHOOSEN_WOMBAT;
        lesson = CURRENT_LESSON;
        testNum = CURRENT_TEST;

        switch (wombat) {
            case "wombat1":
                switch (testNum) {
                    case 1:
                        image.setImageResource(R.drawable.c_testing1);
                        break;

                    case 2:
                        image.setImageResource(R.drawable.c_testing2);
                        break;

                    case 3:
                        image.setImageResource(R.drawable.c_testing3);
                        break;

                    case 4:
                        image.setImageResource(R.drawable.c_testing4);
                        break;

                    case 5:
                        image.setImageResource(R.drawable.c_testing5);
                        break;

                    case 6:
                        image.setImageResource(R.drawable.c_testing6);
                        break;
                    case 7:
                        image.setImageResource(R.drawable.c_testing7);
                        break;
                }

                break;


            case "wombat2":
                switch (testNum) {
                    case 1:
                        image.setImageResource(R.drawable.s_testing1);
                        break;

                    case 2:
                        image.setImageResource(R.drawable.s_testing2);
                        break;

                    case 3:
                        image.setImageResource(R.drawable.s_testing3);
                        break;

                    case 4:
                        image.setImageResource(R.drawable.s_testing4);
                        break;

                    case 5:
                        image.setImageResource(R.drawable.s_testing5);
                        break;

                    case 6:
                        image.setImageResource(R.drawable.s_testing6);
                        break;

                    case 7:
                        image.setImageResource(R.drawable.s_testing7);
                        break;
                }
                break;


            case "wombat3":
                switch (testNum) {
                    case 1:
                        image.setImageResource(R.drawable.n_testing1);
                        break;

                    case 2:
                        image.setImageResource(R.drawable.n_testing2);
                        break;

                    case 3:
                        image.setImageResource(R.drawable.n_testing3);
                        break;

                    case 4:
                        image.setImageResource(R.drawable.n_testing4);
                        break;

                    case 5:
                        image.setImageResource(R.drawable.n_testing5);
                        break;

                    case 6:
                        image.setImageResource(R.drawable.n_testing6);
                        break;

                    case 7:
                        image.setImageResource(R.drawable.n_testing7);
                        break;

                }
                break;
        }



        float factor = view.getContext().getResources().getDisplayMetrics().density;
        linearLayout.removeAllViews();
        for (int i = 0; i < PAGE_SIZE; i++) {
            ImageView imageView = new ImageView(view.getContext());
            if (i == 0){
                int height = (int)(30*factor);
                int width = (int)(50*factor);
                imageView.setLayoutParams(new ViewGroup.LayoutParams(height,width));
                imageView.setImageResource(R.drawable.hint);
            }else {
                imageView.setImageResource(R.drawable.hint_shade);
                int height = (int)(20*factor);
                int width = (int)(50*factor);
                imageView.setLayoutParams(new ViewGroup.LayoutParams(height,width));//图片资源
            }
            imageView.setPadding(15,0,15,0);
            linearLayout.addView(imageView); //动态添加图片
        }
        return view;
    }
}
