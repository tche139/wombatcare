package com.example.fistinbone.myapplication;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;

import com.varunest.sparkbutton.SparkButton;
import com.varunest.sparkbutton.SparkEventListener;

import static com.example.fistinbone.myapplication.WomCare.wombat1_quiz;
import static com.example.fistinbone.myapplication.WomCare.wombat1_stage;
import static com.example.fistinbone.myapplication.WomCare.wombat2_quiz;
import static com.example.fistinbone.myapplication.WomCare.wombat2_stage;
import static com.example.fistinbone.myapplication.WomCare.wombat3_quiz;
import static com.example.fistinbone.myapplication.WomCare.wombat3_stage;

/**
 * Created by fistinbone on 8/29/2017.
 */

public class Medal extends AppCompatActivity {
    Animation animation;
    ImageView medalDescription, closeButton;
    SparkButton sparkButton1,sparkButton2,sparkButton3,sparkButton4,sparkButton5,sparkButton6;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.medal);
        getSupportActionBar().setTitle("Medal");

        sparkButton1 = (SparkButton) findViewById(R.id.spark_button1);
        sparkButton2 = (SparkButton) findViewById(R.id.spark_button2);
        sparkButton3 = (SparkButton) findViewById(R.id.spark_button3);
        sparkButton4 = (SparkButton) findViewById(R.id.spark_button4);
        sparkButton5 = (SparkButton) findViewById(R.id.spark_button5);
        sparkButton6 = (SparkButton) findViewById(R.id.spark_button6);

        loadAnimation();

        medalDescription = (ImageView) findViewById(R.id.medal_popup);
        closeButton = (ImageView) findViewById(R.id.medal_closs_button);

        animation = AnimationUtils.loadAnimation(this, R.anim.gradually);
    }


    //set medal description
    public void medalClick(SparkButton sparkButton) {
        sparkButton1.setEnabled(false);
        sparkButton2.setEnabled(false);
        sparkButton3.setEnabled(false);
        sparkButton4.setEnabled(false);
        sparkButton5.setEnabled(false);
        sparkButton6.setEnabled(false);
        switch (sparkButton.getId()) {
            case R.id.spark_button1:
                medalDescription.setImageResource(R.drawable.newbie);
                break;
            case R.id.spark_button2:
                medalDescription.setImageResource(R.drawable.junior);
                break;
            case R.id.spark_button3:
                medalDescription.setImageResource(R.drawable.practitioner);
                break;
            case R.id.spark_button4:
                medalDescription.setImageResource(R.drawable.defender);
                break;
            case R.id.spark_button5:
                medalDescription.setImageResource(R.drawable.guardian);
                break;
            case R.id.spark_button6:
                medalDescription.setImageResource(R.drawable.master);
                break;
        }
        closeButton.startAnimation(animation);
        closeButton.setVisibility(View.VISIBLE);
        medalDescription.startAnimation(animation);
        medalDescription.setVisibility(View.VISIBLE);
    }

    //set close buttons for medal description
    public void close(View v){
        closeButton.setVisibility(View.GONE);
        medalDescription.setVisibility(View.GONE);
        sparkButton1.setEnabled(true);
        sparkButton2.setEnabled(true);
        sparkButton3.setEnabled(true);
        sparkButton4.setEnabled(true);
        sparkButton5.setEnabled(true);
        sparkButton6.setEnabled(true);
    }

    //spark button, Copyright 2017 varunest.
    //set up spark effect
    public void loadAnimation(){
        if(wombat1_quiz >= 1 || wombat2_quiz >= 1 || wombat3_quiz >= 1){
            sparkButton1.setAnimationSpeed((float) 0.2);
            sparkButton1.playAnimation();
            sparkButton1.setAnimationSpeed(999999999);
            sparkButton1.setInactiveImage(R.drawable.medal_color_1);
            sparkButton1.setActiveImage(R.drawable.medal_color_1);
        }

        if(wombat1_stage >= 2 || wombat2_stage >= 2 || wombat3_stage >= 2){
            sparkButton2.setAnimationSpeed((float) 0.2);
            sparkButton2.playAnimation();
            sparkButton2.setAnimationSpeed(999999999);
            sparkButton2.setInactiveImage(R.drawable.medal_color_2);
            sparkButton2.setActiveImage(R.drawable.medal_color_2);
        }


        if(wombat1_quiz >= 4 || wombat2_quiz >= 4 || wombat3_quiz >= 4){
            sparkButton3.setAnimationSpeed((float) 0.2);
            sparkButton3.playAnimation();
            sparkButton3.setAnimationSpeed(999999999);
            sparkButton3.setInactiveImage(R.drawable.medal_color_3);
            sparkButton3.setActiveImage(R.drawable.medal_color_3);
        }

        if(wombat1_quiz >= 8 || wombat2_quiz >= 8 || wombat3_quiz >= 8){
            sparkButton4.setAnimationSpeed((float) 0.2);
            sparkButton4.playAnimation();
            sparkButton4.setAnimationSpeed(999999999);
            sparkButton4.setInactiveImage(R.drawable.medal_color_4);
            sparkButton4.setActiveImage(R.drawable.medal_color_4);
        }

        if((wombat1_quiz >= 8 && wombat2_quiz >=8) || (wombat2_quiz >= 8 && wombat3_quiz >=8) ||
                (wombat1_quiz > 8 && wombat3_quiz >8)){
            sparkButton5.setAnimationSpeed((float) 0.2);
            sparkButton5.playAnimation();
            sparkButton5.setAnimationSpeed(999999999);
            sparkButton5.setInactiveImage(R.drawable.medal_color_5);
            sparkButton5.setActiveImage(R.drawable.medal_color_5);
        }

        if(wombat1_quiz>=8 && wombat2_quiz>=8 && wombat3_quiz>=8){
            sparkButton6.setAnimationSpeed((float) 0.2);
            sparkButton6.playAnimation();
            sparkButton6.setAnimationSpeed(999999999);
            sparkButton6.setInactiveImage(R.drawable.medal_color_6);
            sparkButton6.setActiveImage(R.drawable.medal_color_6);
        }

        //set listener for spark button
        sparkButton1.setEventListener(new SparkEventListener() {
            @Override
            public void onEvent(ImageView button, boolean buttonState) {
                medalClick(sparkButton1);
            }
            @Override
            public void onEventAnimationEnd(ImageView button, boolean buttonState) {

            }
            @Override
            public void onEventAnimationStart(ImageView button, boolean buttonState) {

            }
        });
        sparkButton2.setEventListener(new SparkEventListener() {
            @Override
            public void onEvent(ImageView button, boolean buttonState) {
                medalClick(sparkButton2);
            }
            @Override
            public void onEventAnimationEnd(ImageView button, boolean buttonState) {

            }
            @Override
            public void onEventAnimationStart(ImageView button, boolean buttonState) {

            }
        });
        sparkButton3.setEventListener(new SparkEventListener() {
            @Override
            public void onEvent(ImageView button, boolean buttonState) {
                medalClick(sparkButton3);
            }
            @Override
            public void onEventAnimationEnd(ImageView button, boolean buttonState) {

            }
            @Override
            public void onEventAnimationStart(ImageView button, boolean buttonState) {

            }
        });
        sparkButton4.setEventListener(new SparkEventListener() {
            @Override
            public void onEvent(ImageView button, boolean buttonState) {
                medalClick(sparkButton4);
            }
            @Override
            public void onEventAnimationEnd(ImageView button, boolean buttonState) {

            }
            @Override
            public void onEventAnimationStart(ImageView button, boolean buttonState) {

            }
        });
        sparkButton5.setEventListener(new SparkEventListener() {
            @Override
            public void onEvent(ImageView button, boolean buttonState) {
                medalClick(sparkButton5);
            }
            @Override
            public void onEventAnimationEnd(ImageView button, boolean buttonState) {

            }
            @Override
            public void onEventAnimationStart(ImageView button, boolean buttonState) {

            }
        });
        sparkButton6.setEventListener(new SparkEventListener() {
            @Override
            public void onEvent(ImageView button, boolean buttonState) {
                medalClick(sparkButton6);
            }
            @Override
            public void onEventAnimationEnd(ImageView button, boolean buttonState) {

            }
            @Override
            public void onEventAnimationStart(ImageView button, boolean buttonState) {

            }
        });
    }
}
