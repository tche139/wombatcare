package com.example.fistinbone.myapplication.Fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewStub;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.example.fistinbone.myapplication.R;

import static com.example.fistinbone.myapplication.WomCare.CHOOSEN_WOMBAT;
import static com.example.fistinbone.myapplication.WomCare.CURRENT_TEST;
import static com.example.fistinbone.myapplication.WomCare.PAGE_NUMBER;
import static com.example.fistinbone.myapplication.WomCare.PAGE_SIZE;
import static com.example.fistinbone.myapplication.WomCare.isQuizSelected1;
import static com.example.fistinbone.myapplication.WomCare.isQuizSelected2;
import static com.example.fistinbone.myapplication.WomCare.testCompleted;

/**
 * Created by fistinbone on 8/24/2017.
 */

public class TestFragment2 extends Fragment implements View.OnClickListener{
    static int id;
    TextView textView;
    ImageView imageView1;
    ImageView imageView2;
    ImageView imageView3;
    ImageView imageView4;
    RadioGroup radioAnswerGroup;
    int selectedId;
    ViewStub viewStub1, viewStub2;
    View guideSlideView;
    RadioButton radioB1,radioB2,radioB3,radioB4;
    ImageButton imageButton1;


    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.test_page2,container,false);

        LinearLayout linearLayout = (LinearLayout) view.findViewById(R.id.test_page2_hint);


        textView = (TextView) view.findViewById(R.id.test2_text);
        imageView1 = (ImageView) view.findViewById(R.id.imageB2);
        imageView2 = (ImageView) view.findViewById(R.id.imageB3);
        imageView3 = (ImageView) view.findViewById(R.id.imageB4);
        imageView4 = (ImageView) view.findViewById(R.id.imageB5);
        viewStub1 = (ViewStub) view.findViewById(R.id.guide_incorrect2);
        viewStub2 = (ViewStub) view.findViewById(R.id.guide_correct2);
        radioB1 = (RadioButton) view.findViewById(R.id.radioButton4);
        radioB2 = (RadioButton) view.findViewById(R.id.radioButton5);
        radioB3 = (RadioButton) view.findViewById(R.id.radioButton6);
        radioB4 = (RadioButton) view.findViewById(R.id.radioButton7);


        radioAnswerGroup = (RadioGroup) view.findViewById(R.id.radiogroup2);

        imageButton1 = (ImageButton) view.findViewById((R.id.test2_button));


        imageButton1.setOnClickListener(this);


        switch (CHOOSEN_WOMBAT) {
            case "wombat1":
                switch (CURRENT_TEST) {

                    case 2:
                        if (PAGE_NUMBER == 2) {
                            textView.setText(R.string.wombat1C_quiz2_Q1);
                            imageView1.setImageResource(R.drawable.c1_1);
                            imageView2.setImageResource(R.drawable.c1_2);
                            imageView3.setImageResource(R.drawable.c1_3);
                            imageView4.setImageResource(R.drawable.c1_4);
                            radioB2.setText(R.string.button2);



                        }
                        if (PAGE_NUMBER == 3) {
                            textView.setText(R.string.wombat1C_quiz2_Q2);
                            imageView1.setImageResource(R.drawable.c2_1);
                            imageView2.setImageResource(R.drawable.c2_4);
                            imageView3.setImageResource(R.drawable.c2_3);
                            imageView4.setImageResource(R.drawable.c2_2);
                            radioB2.setText(R.string.button2);

                        }
                        break;
                }
                break;

            case "wombat2":
                switch (CURRENT_TEST) {
                    case 2:
                        if (PAGE_NUMBER == 2) {
                            textView.setText(R.string.wombat2S_quiz2_Q1);
                            imageView1.setImageResource(R.drawable.s1_1);
                            imageView2.setImageResource(R.drawable.s1_3);
                            imageView3.setImageResource(R.drawable.s1_2);
                            imageView4.setImageResource(R.drawable.s1_4);
                            radioB2.setText(R.string.button2);
                        }
                        if (PAGE_NUMBER == 3) {
                            textView.setText(R.string.wombat2S_quiz2_Q2);
                            imageView1.setImageResource(R.drawable.s2_2);
                            imageView2.setImageResource(R.drawable.s2_1);
                            imageView3.setImageResource(R.drawable.s2_3);
                            imageView4.setImageResource(R.drawable.s2_4);
                            radioB2.setText(R.string.button2);
                        }
                        break;

                }
                break;

            case "wombat3":
                switch (CURRENT_TEST) {
                    case 2:
                        if (PAGE_NUMBER == 2) {
                            textView.setText(R.string.wombat3N_quiz2_Q1);
                            imageView1.setImageResource(R.drawable.n1_1);
                            imageView2.setImageResource(R.drawable.n1_2);
                            imageView3.setImageResource(R.drawable.n1_3);
                            imageView4.setImageResource(R.drawable.n1_4);
                            radioB2.setText(R.string.button2);
                        }
                        if (PAGE_NUMBER == 3) {
                            textView.setText(R.string.wombat3N_quiz2_Q2);
                            imageView1.setImageResource(R.drawable.n2_2);
                            imageView2.setImageResource(R.drawable.n2_4);
                            imageView3.setImageResource(R.drawable.n2_3);
                            imageView4.setImageResource(R.drawable.n2_1);
                            radioB2.setText(R.string.button2);
                        }
                        break;

                }
                break;

        }






        float factor = view.getContext().getResources().getDisplayMetrics().density;
        linearLayout.removeAllViews();
        for (int i = 0; i < PAGE_SIZE; i++) {
            ImageView imageView = new ImageView(view.getContext());
            if (PAGE_NUMBER == i+1){
                imageView.setImageResource(R.drawable.hint);
                int height = (int)(30*factor);
                int width = (int)(50*factor);
                imageView.setLayoutParams(new ViewGroup.LayoutParams(height,width));
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

    @Override
    public void onClick(View v) {
        selectedId = radioAnswerGroup.getCheckedRadioButtonId();

        id = PAGE_NUMBER;


        if (selectedId == -1) {
            isQuizSelected1 = false;
            isQuizSelected2 = false;
            Toast.makeText(this.getContext(), "please pick one answer", Toast.LENGTH_LONG).show();
        } else {
            getActivity().findViewById(R.id.radioButton4).setEnabled(false);
            getActivity().findViewById(R.id.radioButton5).setEnabled(false);
            getActivity().findViewById(R.id.radioButton6).setEnabled(false);
            getActivity().findViewById(R.id.radioButton7).setEnabled(false);


            if (id == 2) {
                if (!(selectedId == radioB2.getId())) {
                    radioB1.setEnabled(false);
                    radioB2.setEnabled(false);
                    radioB3.setEnabled(false);
                    radioB4.setEnabled(false);
                    isQuizSelected1 = false;

                    if (viewStub1.getParent() != null) {
                        guideSlideView = viewStub1.inflate();
                    } else {
                        viewStub1.setVisibility(v.VISIBLE);
                    }
                    ImageButton imageButton = (ImageButton) guideSlideView.findViewById(R.id.guide_test_incorrect_button);
                    imageButton.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View view) {
                            viewStub1.setVisibility(view.GONE);
                            radioB1.setEnabled(true);
                            radioB2.setEnabled(true);
                            radioB3.setEnabled(true);
                            radioB4.setEnabled(true);

                        }
                    });
                } else {

                    radioB1.setEnabled(false);
                    radioB2.setEnabled(false);
                    radioB3.setEnabled(false);
                    radioB4.setEnabled(false);
                    isQuizSelected1 = true;

                    if (viewStub2.getParent() != null) {
                        guideSlideView = viewStub2.inflate();
                    } else {
                        viewStub2.setVisibility(v.VISIBLE);
                    }
                    ImageButton imageButton = (ImageButton) guideSlideView.findViewById(R.id.guide_test_correct_button);
                    imageButton.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View view) {
                            guideSlideView.setVisibility(View.GONE);
                            imageButton1.setEnabled(false);


                        }
                    });
                }
            }


            if (id == 3) {
                if (!(selectedId == radioB2.getId())) {
                    radioB1.setEnabled(false);
                    radioB2.setEnabled(false);
                    radioB3.setEnabled(false);
                    radioB4.setEnabled(false);
                    isQuizSelected2 = false;
                    if (viewStub1.getParent() != null) {
                        guideSlideView = viewStub1.inflate();
                    } else {
                        viewStub1.setVisibility(v.VISIBLE);
                    }
                    ImageButton imageButton = (ImageButton) guideSlideView.findViewById(R.id.guide_test_incorrect_button);
                    imageButton.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View view) {
                            viewStub1.setVisibility(view.GONE);
                            radioB1.setEnabled(true);
                            radioB2.setEnabled(true);
                            radioB3.setEnabled(true);
                            radioB4.setEnabled(true);

                        }
                    });
                } else {

                    radioB1.setEnabled(false);
                    radioB2.setEnabled(false);
                    radioB3.setEnabled(false);
                    radioB4.setEnabled(false);
                    isQuizSelected2 = true;
                    testCompleted++;
                    if (viewStub2.getParent() != null) {
                        guideSlideView = viewStub2.inflate();
                    } else {
                        viewStub2.setVisibility(v.VISIBLE);
                    }
                    ImageButton imageButton = (ImageButton) guideSlideView.findViewById(R.id.guide_test_correct_button);
                    imageButton.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View view) {
                            guideSlideView.setVisibility(View.GONE);
                            imageButton1.setEnabled(false);
                            ViewPager viewPager = (ViewPager) getActivity().findViewById(R.id.pager);
                            viewPager.setCurrentItem(viewPager.getCurrentItem()+1);

                        }
                    });
                }
            }
        }

    }
}
