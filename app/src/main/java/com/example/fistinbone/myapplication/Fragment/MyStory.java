package com.example.fistinbone.myapplication.Fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;

import com.example.fistinbone.myapplication.R;

import static com.example.fistinbone.myapplication.WomCare.CHOOSEN_WOMBAT;
import static com.example.fistinbone.myapplication.WomCare.CURRENT_LEARN;
import static com.example.fistinbone.myapplication.WomCare.CURRENT_TEST;
import static com.example.fistinbone.myapplication.WomCare.PAGE_SIZE;

/**
 * Created by fistinbone on 8/27/2017.
 */

public class MyStory extends Fragment {
    String wombat;
    int lesson;
    int testNum;
    Button button;
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.mystory,container,false);
        button = (Button) view.findViewById(R.id.starttest);
        button.setVisibility(View.GONE);
        LinearLayout linearLayout = (LinearLayout) view.findViewById(R.id.mystory_layout);

        ImageView image = (ImageView) view.findViewById(R.id.imageView11);

        wombat = CHOOSEN_WOMBAT;
        lesson = CURRENT_LEARN;
        testNum = CURRENT_TEST;

        switch (wombat) {
            case "wombat1":
                switch (lesson) {
                    case 1:
                            image.setImageResource(R.drawable.c_learn1);
                        break;

                    case 2:
                            image.setImageResource(R.drawable.c_learn2);
                        break;

                    case 3:
                            image.setImageResource(R.drawable.c_learn3);
                        break;

                    case 4:
                            image.setImageResource(R.drawable.c_learn4);
                        break;

                    case 5:
                            image.setImageResource(R.drawable.c_learn5);
                        break;

                    case 6:
                            image.setImageResource(R.drawable.c_learn6);
                        break;

                    case 7:
                        image.setImageResource(R.drawable.c_learn7);
                        break;
                }

                break;


            case "wombat2":
                switch (lesson) {
                    case 1:
                            image.setImageResource(R.drawable.s_learn1);
                        break;

                    case 2:
                            image.setImageResource(R.drawable.s_learn2);
                        break;

                    case 3:
                            image.setImageResource(R.drawable.s_learn3);
                        break;

                    case 4:
                            image.setImageResource(R.drawable.s_learn4);
                        break;

                    case 5:
                            image.setImageResource(R.drawable.s_learn5);
                        break;

                    case 6:
                            image.setImageResource(R.drawable.s_learn6);
                        break;

                    case 7:
                        image.setImageResource(R.drawable.s_learn7);
                        break;

                }
                break;


            case "wombat3":
                switch (lesson) {
                    case 1:
                            image.setImageResource(R.drawable.n_learn1);
                        break;

                    case 2:
                            image.setImageResource(R.drawable.n_learn2);
                        break;

                    case 3:
                            image.setImageResource(R.drawable.n_learn3);
                        break;

                    case 4:
                            image.setImageResource(R.drawable.n_learn4);
                        break;

                    case 5:
                            image.setImageResource(R.drawable.n_learn5);
                        break;

                    case 6:
                            image.setImageResource(R.drawable.n_learn6);
                        break;

                    case 7:
                        image.setImageResource(R.drawable.n_learn7);
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
