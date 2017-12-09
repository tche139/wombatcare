package com.example.fistinbone.myapplication.Fragment;


import android.graphics.Typeface;
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

import java.util.Arrays;

import static com.example.fistinbone.myapplication.WomCare.CHOOSEN_WOMBAT;
import static com.example.fistinbone.myapplication.WomCare.CURRENT_LESSON;
import static com.example.fistinbone.myapplication.WomCare.PAGE_NUMBER;
import static com.example.fistinbone.myapplication.WomCare.PAGE_SIZE;
import static com.example.fistinbone.myapplication.WomCare.isQuizSelected1;
import static com.example.fistinbone.myapplication.WomCare.isQuizSelected2;
import static com.example.fistinbone.myapplication.WomCare.testCompleted;

/**
 * Created by fistinbone on 8/24/2017.
 */

public class TestFragment1 extends Fragment implements View.OnClickListener {
    static int id;
    ViewStub viewStub1, viewStub2;
    View guideSlideView;
    RadioButton radioButton1,radioButton2,radioButton3;
    TextView textView;
    RadioGroup radioAnswerGroup;
    int selectedId;
    ImageButton imageButton1;



    String [] rightAnswer = {"Small eyes","Bright Yellow","Large naked","Red","Night","Native grasses","1,000 ~ 5,000","Less and less","South-east Australia",
            "Western","Their habitat become field.","Nope, but we need to protect them.","Victoria","They destroy fences.",
            "Southern-hairy wombat","Grey","Narrow pointy","Yellow","Grasses","Burrows","They are nearly endangered.","Around 180000",
    "North-Western","Western Australia","Droughts","Invasive animals","Land/Water protection","Education.",
    "Dig a burrow","Burrows","Yes","Grasses","Dig a burrow","Around 200","They are critically endangered.",
            "Queensland","Gold Coast","Air pollution","Yes, it is critically endangered.","Plant trees","Queensland"
    };



    //String radiovalue = ((RadioButton)findViewById(radioAnswerGroup.getCheckedRadioButtonId())).getText().toString();

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.test_page1, container, false);

        id = PAGE_NUMBER;

        LinearLayout linearLayout = (LinearLayout) view.findViewById(R.id.test_page1_hint);
         imageButton1 = (ImageButton) view.findViewById((R.id.test1_button));
        viewStub1 = (ViewStub) view.findViewById(R.id.guide_incorrect);
        viewStub2 = (ViewStub) view.findViewById(R.id.guide_correct);
        radioButton1 = (RadioButton) view.findViewById(R.id.radioButton1);
        radioButton2 = (RadioButton) view.findViewById(R.id.radioButton2);
        radioButton3 = (RadioButton) view.findViewById(R.id.radioButton3);
        textView = (TextView) view.findViewById(R.id.test1_text);
        radioAnswerGroup = (RadioGroup) view.findViewById(R.id.radiogroup);

        //set font-style
        Typeface customFont = Typeface.createFromAsset(this.getContext().getAssets(), "fonts/fontStyle1.ttf");
        textView.setTypeface(customFont, Typeface.BOLD);
        radioButton1.setTypeface(customFont);
        radioButton2.setTypeface(customFont);
        radioButton3.setTypeface(customFont);


        imageButton1.setOnClickListener(this);


        float factor = view.getContext().getResources().getDisplayMetrics().density;
        linearLayout.removeAllViews();
        for (int i = 0; i < PAGE_SIZE; i++) {
            ImageView imageView = new ImageView(view.getContext());
            if (PAGE_NUMBER == i + 1) {
                imageView.setImageResource(R.drawable.hint);
                int height = (int) (30 * factor);
                int width = (int) (50 * factor);
                imageView.setLayoutParams(new ViewGroup.LayoutParams(height, width));
            } else {
                imageView.setImageResource(R.drawable.hint_shade);
                int height = (int) (20 * factor);
                int width = (int) (50 * factor);
                imageView.setLayoutParams(new ViewGroup.LayoutParams(height, width));//图片资源
            }
            imageView.setPadding(15, 0, 15, 0);
            linearLayout.addView(imageView); //动态添加图片
        }


        //set questions
        switch (CHOOSEN_WOMBAT) {
            case "wombat1":
                switch (CURRENT_LESSON) {
                    case 1:
                        if (PAGE_NUMBER == 2) {
                            textView.setText(R.string.wombat1C_lesson1_test_Q1);
                            radioButton1.setText(R.string.wombat1C_lesson1_test_A1_1);
                            radioButton2.setText(R.string.wombat1C_lesson1_test_A1_2); //Y
                            radioButton3.setText(R.string.wombat1C_lesson1_test_A1_3);
                        }
                        if (PAGE_NUMBER == 3) {
                            textView.setText(R.string.wombat1C_lesson1_test_Q2);
                            radioButton1.setText(R.string.wombat1C_lesson1_test_A2_1);
                            radioButton2.setText(R.string.wombat1C_lesson1_test_A2_2);
                            radioButton3.setText(R.string.wombat1C_lesson1_test_A2_3); //Y
                        }

                        break;

//                    case 2:
//                        if (PAGE_NUMBER == 2) {
//                            textView.setText(R.string.wombat1C_lesson2_test_Q1);
//                            radioButton1.setText(R.string.wombat1C_lesson2_test_A1_1);
//                            radioButton2.setText(R.string.wombat1C_lesson2_test_A1_2); //Y
//                            radioButton3.setText(R.string.wombat1C_lesson2_test_A1_3);
//                        }
//                        if (PAGE_NUMBER == 3) {
//                            textView.setText(R.string.wombat1C_lesson2_test_Q2);
//                            radioButton1.setText(R.string.wombat1C_lesson2_test_A2_1);
//                            radioButton2.setText(R.string.wombat1C_lesson2_test_A2_2);
//                            radioButton3.setText(R.string.wombat1C_lesson2_test_A2_3); //Y
//                        }
//
//                        break;

                    case 3:
                        if (PAGE_NUMBER == 2) {
                            textView.setText(R.string.wombat1C_lesson3_test_Q1);
                            radioButton1.setText(R.string.wombat1C_lesson3_test_A1_1);
                            radioButton2.setText(R.string.wombat1C_lesson3_test_A1_2);
                            radioButton3.setText(R.string.wombat1C_lesson3_test_A1_3); //Y
                        }
                        if (PAGE_NUMBER == 3) {
                            textView.setText(R.string.wombat1C_lesson3_test_Q2);
                            radioButton1.setText(R.string.wombat1C_lesson3_test_A2_1); //Y
                                                        radioButton2.setText(R.string.wombat1C_lesson3_test_A2_2);
                            radioButton3.setText(R.string.wombat1C_lesson3_test_A2_3);
                        }

                        break;

                    case 4:
                        if (PAGE_NUMBER == 2) {
                            textView.setText(R.string.wombat1C_lesson4_test_Q1);
                            radioButton1.setText(R.string.wombat1C_lesson4_test_A1_1); //Y
                            radioButton2.setText(R.string.wombat1C_lesson4_test_A1_2);
                            radioButton3.setText(R.string.wombat1C_lesson4_test_A1_3);
                        }
                        if (PAGE_NUMBER == 3) {
                            textView.setText(R.string.wombat1C_lesson4_test_Q2);
                            radioButton1.setText(R.string.wombat1C_lesson4_test_A2_1);
                            radioButton2.setText(R.string.wombat1C_lesson4_test_A2_2); //Y
                            radioButton3.setText(R.string.wombat1C_lesson4_test_A2_3);
                        }

                        break;

                    case 5:
                        if (PAGE_NUMBER == 2) {
                            radioButton1.setText(R.string.wombat1C_lesson5_test_A1_1);
                            radioButton2.setText(R.string.wombat1C_lesson5_test_A1_2);
                            radioButton3.setText(R.string.wombat1C_lesson5_test_A1_3); //Y
                            textView.setText(R.string.wombat1C_lesson5_test_Q1);
                        }
                        if (PAGE_NUMBER == 3) {
                            radioButton1.setText(R.string.wombat1C_lesson5_test_A2_1);
                            radioButton2.setText(R.string.wombat1C_lesson5_test_A2_2);
                            radioButton3.setText(R.string.wombat1C_lesson5_test_A2_3); //Y
                            textView.setText(R.string.wombat1C_lesson5_test_Q2);
                        }

                        break;

                    case 6:
                        if (PAGE_NUMBER == 2) {
                            textView.setText(R.string.wombat1C_lesson6_test_Q1);
                            radioButton1.setText(R.string.wombat1C_lesson6_test_A1_1);
                            radioButton2.setText(R.string.wombat1C_lesson6_test_A1_2); //Y
                            radioButton3.setText(R.string.wombat1C_lesson6_test_A1_3);
                        }
                        if (PAGE_NUMBER == 3) {
                            textView.setText(R.string.wombat1C_lesson6_test_Q2);
                            radioButton1.setText(R.string.wombat1C_lesson6_test_A2_1);
                            radioButton2.setText(R.string.wombat1C_lesson6_test_A2_2);
                            radioButton3.setText(R.string.wombat1C_lesson6_test_A2_3); //Y
                        }

                        break;

                    case 7:
                        if (PAGE_NUMBER == 2) {
                            textView.setText(R.string.wombat1C_lesson7_test_Q1);
                            radioButton1.setText(R.string.wombat1C_lesson7_test_A1_1);
                            radioButton2.setText(R.string.wombat1C_lesson7_test_A1_2); //Y
                            radioButton3.setText(R.string.wombat1C_lesson7_test_A1_3);
                        }
                        if (PAGE_NUMBER == 3) {
                            textView.setText(R.string.wombat1C_lesson7_test_Q2);
                            radioButton1.setText(R.string.wombat1C_lesson7_test_A2_1);
                            radioButton2.setText(R.string.wombat1C_lesson7_test_A2_2);
                            radioButton3.setText(R.string.wombat1C_lesson7_test_A2_3); //Y
                        }

                        break;
                }
                break;


            case "wombat2":
                switch (CURRENT_LESSON) {
                    case 1:
                        if (PAGE_NUMBER == 2) {
                            textView.setText(R.string.wombat2S_lesson1_test_Q1);
                            radioButton1.setText(R.string.wombat2S_lesson1_test_A1_1);
                            radioButton2.setText(R.string.wombat2S_lesson1_test_A1_2); //Y
                            radioButton3.setText(R.string.wombat2S_lesson1_test_A1_3);
                        }
                        if (PAGE_NUMBER == 3) {
                            textView.setText(R.string.wombat2S_lesson1_test_Q2);
                            radioButton1.setText(R.string.wombat2S_lesson1_test_A2_1);
                            radioButton2.setText(R.string.wombat2S_lesson1_test_A2_2); //Y
                            radioButton3.setText(R.string.wombat2S_lesson1_test_A2_3);
                        }

                        break;

//                    case 2:
//                        if (PAGE_NUMBER == 2) {
//                            textView.setText(R.string.wombat2S_lesson2_test_Q1);
//                            radioButton1.setText(R.string.wombat2S_lesson2_test_A1_1);
//                            radioButton2.setText(R.string.wombat2S_lesson2_test_A1_2); //Y
//                            radioButton3.setText(R.string.wombat2S_lesson2_test_A1_3);
//                        }
//                        if (PAGE_NUMBER == 3) {
//                            textView.setText(R.string.wombat2S_lesson2_test_Q2);
//                            radioButton1.setText(R.string.wombat2S_lesson2_test_A2_1);
//                            radioButton2.setText(R.string.wombat2S_lesson2_test_A2_2); //Y
//                            radioButton3.setText(R.string.wombat2S_lesson2_test_A2_3);
//                        }
//
//                        break;

                    case 3:
                        if (PAGE_NUMBER == 2) {
                            textView.setText(R.string.wombat2S_lesson3_test_Q1);
                            radioButton1.setText(R.string.wombat2S_lesson3_test_A1_1);
                            radioButton2.setText(R.string.wombat2S_lesson3_test_A1_2); //Y
                            radioButton3.setText(R.string.wombat2S_lesson3_test_A1_3);
                        }
                        if (PAGE_NUMBER == 3) {
                            textView.setText(R.string.wombat2S_lesson3_test_Q2);
                            radioButton1.setText(R.string.wombat2S_lesson3_test_A2_1);
                            radioButton2.setText(R.string.wombat2S_lesson3_test_A2_2);
                            radioButton3.setText(R.string.wombat2S_lesson3_test_A2_3); //Y
                        }

                        break;

                    case 4:
                        if (PAGE_NUMBER == 2) {
                            textView.setText(R.string.wombat2S_lesson4_test_Q1);
                            radioButton1.setText(R.string.wombat2S_lesson4_test_A1_1);
                            radioButton2.setText(R.string.wombat2S_lesson4_test_A1_2); //Y
                            radioButton3.setText(R.string.wombat2S_lesson4_test_A1_3);
                        }
                        if (PAGE_NUMBER == 3) {
                            textView.setText(R.string.wombat2S_lesson4_test_Q2);
                            radioButton1.setText(R.string.wombat2S_lesson4_test_A2_1);
                            radioButton2.setText(R.string.wombat2S_lesson4_test_A2_2);
                            radioButton3.setText(R.string.wombat2S_lesson4_test_A2_3); //Y
                        }

                        break;

                    case 5:
                        if (PAGE_NUMBER == 2) {
                            radioButton1.setText(R.string.wombat2S_lesson5_test_A1_1);
                            radioButton2.setText(R.string.wombat2S_lesson5_test_A1_2);
                            radioButton3.setText(R.string.wombat2S_lesson5_test_A1_3); //Y
                            textView.setText(R.string.wombat2S_lesson5_test_Q1);
                        }
                        if (PAGE_NUMBER == 3) {
                            radioButton1.setText(R.string.wombat2S_lesson5_test_A2_1);
                            radioButton2.setText(R.string.wombat2S_lesson5_test_A2_2);
                            radioButton3.setText(R.string.wombat2S_lesson5_test_A2_3); //Y
                            textView.setText(R.string.wombat2S_lesson5_test_Q2);
                        }

                        break;

                    case 6:
                        if (PAGE_NUMBER == 2) {
                            textView.setText(R.string.wombat2S_lesson6_test_Q1);
                            radioButton1.setText(R.string.wombat2S_lesson6_test_A1_1);//Y
                            radioButton2.setText(R.string.wombat2S_lesson6_test_A1_2);
                            radioButton3.setText(R.string.wombat2S_lesson6_test_A1_3);
                        }
                        if (PAGE_NUMBER == 3) {
                            textView.setText(R.string.wombat2S_lesson6_test_Q2);
                            radioButton1.setText(R.string.wombat2S_lesson6_test_A2_1);//Y
                            radioButton2.setText(R.string.wombat2S_lesson6_test_A2_2);
                            radioButton3.setText(R.string.wombat2S_lesson6_test_A2_3);
                        }

                        break;

                    case 7:
                        if (PAGE_NUMBER == 2) {
                            textView.setText(R.string.wombat2S_lesson7_test_Q1);
                            radioButton1.setText(R.string.wombat2S_lesson7_test_A1_1);//Y
                            radioButton2.setText(R.string.wombat2S_lesson7_test_A1_2);
                            radioButton3.setText(R.string.wombat2S_lesson7_test_A1_3);
                        }
                        if (PAGE_NUMBER == 3) {
                            textView.setText(R.string.wombat2S_lesson7_test_Q2);
                            radioButton1.setText(R.string.wombat2S_lesson7_test_A2_1);//Y
                            radioButton2.setText(R.string.wombat2S_lesson7_test_A2_2);
                            radioButton3.setText(R.string.wombat2S_lesson7_test_A2_3);
                        }

                        break;

                }
                break;


            case "wombat3":
                switch (CURRENT_LESSON) {
                    case 1:
                        if (PAGE_NUMBER == 2) {
                            textView.setText(R.string.wombat3N_lesson1_test_Q1);
                            radioButton1.setText(R.string.wombat3N_lesson1_test_A1_1); //Y
                            radioButton2.setText(R.string.wombat3N_lesson1_test_A1_2);
                            radioButton3.setText(R.string.wombat3N_lesson1_test_A1_3);
                        }
                        if (PAGE_NUMBER == 3) {
                            textView.setText(R.string.wombat3N_lesson1_test_Q2);
                            radioButton1.setText(R.string.wombat3N_lesson1_test_A2_1); //Y
                            radioButton2.setText(R.string.wombat3N_lesson1_test_A2_2);
                            radioButton3.setText(R.string.wombat3N_lesson1_test_A2_3);
                        }

                        break;

//                    case 2:
//                        if (PAGE_NUMBER == 2) {
//                            textView.setText(R.string.wombat3N_lesson2_test_Q1);
//                            radioButton1.setText(R.string.wombat3N_lesson2_test_A1_1); //Y
//                            radioButton2.setText(R.string.wombat3N_lesson2_test_A1_2);
//                            radioButton3.setText(R.string.wombat3N_lesson2_test_A1_3);
//                        }
//
//                        if (PAGE_NUMBER == 3) {
//                            textView.setText(R.string.wombat3N_lesson2_test_Q2);
//                            radioButton1.setText(R.string.wombat3N_lesson2_test_A2_1); //Y
//                            radioButton2.setText(R.string.wombat3N_lesson2_test_A2_2);
//                            radioButton3.setText(R.string.wombat3N_lesson2_test_A2_3);
//                        }
//
//                        break;

                    case 3:
                        if (PAGE_NUMBER == 2) {
                            textView.setText(R.string.wombat3N_lesson3_test_Q1);
                            radioButton1.setText(R.string.wombat3N_lesson3_test_A1_1);
                            radioButton2.setText(R.string.wombat3N_lesson3_test_A1_2); //Y
                            radioButton3.setText(R.string.wombat3N_lesson3_test_A1_3);
                        }
                        if (PAGE_NUMBER == 3) {
                            textView.setText(R.string.wombat3N_lesson3_test_Q2);
                            radioButton1.setText(R.string.wombat3N_lesson3_test_A2_1);
                            radioButton2.setText(R.string.wombat3N_lesson3_test_A2_2); //Y
                            radioButton3.setText(R.string.wombat3N_lesson3_test_A2_3);
                        }

                        break;

                    case 4:
                        if (PAGE_NUMBER == 2) {
                            textView.setText(R.string.wombat3N_lesson4_test_Q1);
                            radioButton1.setText(R.string.wombat3N_lesson4_test_A1_1);
                            radioButton2.setText(R.string.wombat3N_lesson4_test_A1_2); //Y
                            radioButton3.setText(R.string.wombat3N_lesson4_test_A1_3);
                        }
                        if (PAGE_NUMBER == 3) {
                            textView.setText(R.string.wombat3N_lesson4_test_Q2);
                            radioButton1.setText(R.string.wombat3N_lesson4_test_A2_1);
                            radioButton2.setText(R.string.wombat3N_lesson4_test_A2_2); //Y
                            radioButton3.setText(R.string.wombat3N_lesson4_test_A2_3);
                        }

                        break;

                    case 5:
                        if (PAGE_NUMBER == 2) {
                            radioButton1.setText(R.string.wombat3N_lesson5_test_A1_1);
                            radioButton2.setText(R.string.wombat3N_lesson5_test_A1_2); //Y
                            radioButton3.setText(R.string.wombat3N_lesson5_test_A1_3);
                            textView.setText(R.string.wombat3N_lesson5_test_Q1);
                        }
                        if (PAGE_NUMBER == 3) {
                            radioButton1.setText(R.string.wombat3N_lesson5_test_A2_1);
                            radioButton2.setText(R.string.wombat3N_lesson5_test_A2_2); //Y
                            radioButton3.setText(R.string.wombat3N_lesson5_test_A2_3);
                            textView.setText(R.string.wombat3N_lesson5_test_Q2);
                        }

                        break;

                    case 6:
                        if (PAGE_NUMBER == 2) {
                            textView.setText(R.string.wombat3N_lesson6_test_Q1);
                            radioButton1.setText(R.string.wombat3N_lesson6_test_A1_1);
                            radioButton2.setText(R.string.wombat3N_lesson6_test_A1_2);
                            radioButton3.setText(R.string.wombat3N_lesson6_test_A1_3); //Y
                        }
                        if (PAGE_NUMBER == 3) {
                            textView.setText(R.string.wombat3N_lesson6_test_Q2);
                            radioButton1.setText(R.string.wombat3N_lesson6_test_A2_1);
                            radioButton2.setText(R.string.wombat3N_lesson6_test_A2_2);
                            radioButton3.setText(R.string.wombat3N_lesson6_test_A2_3); //Y
                        }

                        break;

                    case 7:
                        if (PAGE_NUMBER == 2) {
                            textView.setText(R.string.wombat3N_lesson7_test_Q1);
                            radioButton1.setText(R.string.wombat3N_lesson7_test_A1_1);
                            radioButton2.setText(R.string.wombat3N_lesson7_test_A1_2);
                            radioButton3.setText(R.string.wombat3N_lesson7_test_A1_3); //Y
                        }
                        if (PAGE_NUMBER == 3) {
                            textView.setText(R.string.wombat3N_lesson7_test_Q2);
                            radioButton1.setText(R.string.wombat3N_lesson7_test_A2_1);
                            radioButton2.setText(R.string.wombat3N_lesson7_test_A2_2);
                            radioButton3.setText(R.string.wombat3N_lesson7_test_A2_3); //Y
                        }

                        break;
                }
                break;

            default:
                break;
        }
        return view;
    }

    @Override
    public void onClick(View v) {
        selectedId = radioAnswerGroup.getCheckedRadioButtonId();
        //picked
        String radiovalue = "";
        //boolean
        //switch
        if (selectedId == -1) {
            //isQuizSelected1 = false;
            //isQuizSelected2 = false;
            Toast.makeText(this.getContext(), "please pick one answer", Toast.LENGTH_LONG).show();
        } else {

            radiovalue = ((RadioButton) getActivity().findViewById(radioAnswerGroup.getCheckedRadioButtonId())).getText().toString();

            getActivity().findViewById(R.id.radioButton1).setEnabled(false);
            getActivity().findViewById(R.id.radioButton2).setEnabled(false);
            getActivity().findViewById(R.id.radioButton3).setEnabled(false);
//            if (!(selectedId == radioButton2.getId())) {

            if (id == 2) {
                if (!(Arrays.asList(rightAnswer).contains(radiovalue))) {

                    //if the choose the incorrect button
                    isQuizSelected1 = false;
                    radioButton1.setEnabled(false);
                    radioButton2.setEnabled(false);
                    radioButton3.setEnabled(false);
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
                            radioButton1.setEnabled(true);
                            radioButton2.setEnabled(true);
                            radioButton3.setEnabled(true);
                        }
                    });
                } else {
                    //if the choose the correct button
                    radioButton1.setEnabled(false);
                    radioButton2.setEnabled(false);
                    radioButton3.setEnabled(false);
                    isQuizSelected1 = true;
                    testCompleted++;
                    if (viewStub2.getParent() != null) {
                        guideSlideView = viewStub2.inflate();
                    } else {
                        viewStub2.setVisibility(v.VISIBLE);
                    }
                    final ImageButton imageButton = (ImageButton) guideSlideView.findViewById(R.id.guide_test_correct_button);
                    imageButton.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View view) {
                            guideSlideView.setVisibility(View.GONE);
                            radioButton1.setEnabled(false);
                            radioButton2.setEnabled(false);
                            radioButton3.setEnabled(false);
                            imageButton1.setEnabled(false);
                        }
                    });
                }
            }
        }

            if (id == 3) {
                if (!(Arrays.asList(rightAnswer).contains(radiovalue))) {
                    //if the choose the incorrect button
                    isQuizSelected2 = false;
                    radioButton1.setEnabled(false);
                    radioButton2.setEnabled(false);
                    radioButton3.setEnabled(false);


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
                            radioButton1.setEnabled(true);
                            radioButton2.setEnabled(true);
                            radioButton3.setEnabled(true);


                        }
                    });
                } else {
                    //if the choose the correct button
                    radioButton1.setEnabled(false);
                    radioButton2.setEnabled(false);
                    radioButton3.setEnabled(false);
                    isQuizSelected2 = true;
                    testCompleted++;

                    if (viewStub2.getParent() != null) {
                        guideSlideView = viewStub2.inflate();
                    } else {
                        viewStub2.setVisibility(v.VISIBLE);
                    }
                    final ImageButton imageButton = (ImageButton) guideSlideView.findViewById(R.id.guide_test_correct_button);
                    imageButton.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View view) {
                            guideSlideView.setVisibility(View.GONE);
                            imageButton1.setEnabled(false);
                            radioButton1.setEnabled(false);
                            radioButton2.setEnabled(false);
                            radioButton3.setEnabled(false);
                            ViewPager viewPager = (ViewPager) getActivity().findViewById(R.id.pager);
                            viewPager.setCurrentItem(viewPager.getCurrentItem()+1);
                        }
                    });
                }
            }
        }


    }



