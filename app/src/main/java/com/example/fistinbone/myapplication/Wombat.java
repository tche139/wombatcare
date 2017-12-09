package com.example.fistinbone.myapplication;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageView;
import android.widget.ScrollView;

import static com.example.fistinbone.myapplication.WomCare.CHOOSEN_WOMBAT;
import static com.example.fistinbone.myapplication.WomCare.CURRENT_LEARN;
import static com.example.fistinbone.myapplication.WomCare.CURRENT_LESSON;
import static com.example.fistinbone.myapplication.WomCare.CURRENT_TEST;
import static com.example.fistinbone.myapplication.WomCare.flag_wombat1;
import static com.example.fistinbone.myapplication.WomCare.flag_wombat2;
import static com.example.fistinbone.myapplication.WomCare.flag_wombat3;
import static com.example.fistinbone.myapplication.WomCare.wombat1_quiz;
import static com.example.fistinbone.myapplication.WomCare.wombat1_stage;
import static com.example.fistinbone.myapplication.WomCare.wombat2_quiz;
import static com.example.fistinbone.myapplication.WomCare.wombat2_stage;
import static com.example.fistinbone.myapplication.WomCare.wombat3_quiz;
import static com.example.fistinbone.myapplication.WomCare.wombat3_stage;


public class Wombat extends AppCompatActivity {

    ImageView image;
    ImageView lesson1,lesson2,lesson3,lesson4,lesson5,lesson6,lesson7;
    ImageView lesson1_left,lesson2_left,lesson3_left,lesson4_left,lesson5_left,lesson6_left,lesson7_left;
    ImageView lesson1_right,lesson2_right,lesson3_right,lesson4_right,lesson5_right,lesson6_right,lesson7_right;
    ScrollView scroller;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_wombat);
        scroller = (ScrollView) findViewById(R.id.Wombat1ScrollView);


        image = (ImageView) findViewById(R.id.wombat) ;
        lesson1 = (ImageView) findViewById(R.id.lesson1);
        lesson1_left = (ImageView) findViewById(R.id.lesson1_learn);
        lesson1_right = (ImageView) findViewById(R.id.lesson1_quiz);
        lesson2 = (ImageView) findViewById(R.id.lesson2);
        lesson2_left = (ImageView) findViewById(R.id.lesson2_learn);
        lesson2_right = (ImageView) findViewById(R.id.lesson2_quiz);
        lesson3 = (ImageView) findViewById(R.id.lesson3);
        lesson3_left = (ImageView) findViewById(R.id.lesson3_learn);
        lesson3_right = (ImageView) findViewById(R.id.lesson3_quiz);
        lesson4 = (ImageView) findViewById(R.id.lesson4);
        lesson4_left = (ImageView) findViewById(R.id.lesson4_learn);
        lesson4_right = (ImageView) findViewById(R.id.lesson4_quiz);
        lesson5 = (ImageView) findViewById(R.id.lesson5);
        lesson5_left = (ImageView) findViewById(R.id.lesson5_learn);
        lesson5_right = (ImageView) findViewById(R.id.lesson5_quiz);
        lesson6 = (ImageView) findViewById(R.id.lesson6);
        lesson6_left = (ImageView) findViewById(R.id.lesson6_learn);
        lesson6_right = (ImageView) findViewById(R.id.lesson6_quiz);
        lesson7 = (ImageView) findViewById(R.id.lesson7);
        lesson7_left = (ImageView) findViewById(R.id.lesson7_learn);
        lesson7_right = (ImageView) findViewById(R.id.lesson7_quiz);

        lesson1_right.setEnabled(false);
        lesson2_left.setEnabled(false);
        lesson2_right.setEnabled(false);
        lesson3_left.setEnabled(false);
        lesson3_right.setEnabled(false);
        lesson4_left.setEnabled(false);
        lesson4_right.setEnabled(false);
        lesson5_left.setEnabled(false);
        lesson5_right.setEnabled(false);
        lesson6_left.setEnabled(false);
        lesson6_right.setEnabled(false);
        lesson7_left.setEnabled(false);
        lesson7_right.setEnabled(false);


        setImage(CHOOSEN_WOMBAT);
        setEnable(CHOOSEN_WOMBAT);

        //set scroll view for wombat pages
        switch (CHOOSEN_WOMBAT) {
            case "wombat1":
                Handler h1 = new Handler();

                h1.postDelayed(new Runnable() {

                    @Override
                    public void run() {

                        if (flag_wombat1 == 1) {
                            scroller.scrollTo(0, 0);
                        }
                        if (flag_wombat1 == 2) {
                            scroller.scrollTo(0, 1000);
                        }
                        if (flag_wombat1 == 3) {
                            scroller.scrollTo(0, 2000);
                        }
                        if (flag_wombat1 == 4) {
                            scroller.scrollTo(0, 3000);
                        }
                        if (flag_wombat1 == 5) {
                            scroller.scrollTo(0, 4000);
                        }
                        if (flag_wombat1 == 6) {
                            scroller.scrollTo(0, 5000);
                        }
                        if (flag_wombat1 == 7) {
                            scroller.scrollTo(0, 6000);
                        }

                    }
                }, 100);
                break;


            case "wombat2":
                Handler h2 = new Handler();

                h2.postDelayed(new Runnable() {

                    @Override
                    public void run() {

                        if (flag_wombat2 == 1) {
                            scroller.scrollTo(0, 0);
                        }
                        if (flag_wombat2 == 2) {
                            scroller.scrollTo(0, 1000);
                        }
                        if (flag_wombat2 == 3) {
                            scroller.scrollTo(0, 2000);
                        }
                        if (flag_wombat2 == 4) {
                            scroller.scrollTo(0, 3000);
                        }
                        if (flag_wombat2 == 5) {
                            scroller.scrollTo(0, 4000);
                        }
                        if (flag_wombat2 == 6) {
                            scroller.scrollTo(0, 5000);
                        }
                        if (flag_wombat2 == 7) {
                            scroller.scrollTo(0, 6000);
                        }

                    }
                }, 100);
                break;


            case "wombat3":
                Handler h3 = new Handler();

                h3.postDelayed(new Runnable() {

                    @Override
                    public void run() {


                        if (flag_wombat3 == 1) {
                            scroller.scrollTo(0, 0);
                        }
                        if (flag_wombat3 == 2) {
                            scroller.scrollTo(0, 1000);
                        }
                        if (flag_wombat3 == 3) {
                            scroller.scrollTo(0, 2000);
                        }
                        if (flag_wombat3 == 4) {
                            scroller.scrollTo(0, 3000);
                        }
                        if (flag_wombat3 == 5) {
                            scroller.scrollTo(0, 4000);
                        }
                        if (flag_wombat3 == 6) {
                            scroller.scrollTo(0, 5000);
                        }
                        if (flag_wombat3 == 7) {
                            scroller.scrollTo(0, 6000);
                        }


                    }
                }, 100);
                break;
        }
    }

    //set wombat image
    public void setImage(String wombat) {
        switch (wombat) {
            case "wombat1":
                image.setImageResource(R.drawable.wombat_1);
                break;
            case "wombat2":
                image.setImageResource(R.drawable.s_wombat);
                break;
            case "wombat3":
                image.setImageResource(R.drawable.n_wombat);
                break;
        }
    }

    //set lesson number and test number
    public void setEnable(String wombat){
        int x = 0;
        int y = 0;
        if (wombat.equals("wombat1")){x = wombat1_stage; y = wombat1_quiz;}
        if (wombat.equals("wombat2")){x = wombat2_stage; y = wombat2_quiz;}
        if (wombat.equals("wombat3")){x = wombat3_stage; y = wombat3_quiz;}

        //set quiz number
        if (y >= 1){
            lesson1_right.setEnabled(true);
        }
        if (y >= 2){
            lesson2_right.setEnabled(true);
        }
        if (y >= 3){
            lesson3_right.setEnabled(true);
        }
        if (y >= 4){
            lesson4_right.setEnabled(true);
        }
        if (y >= 5){
            lesson5_right.setEnabled(true);
        }
        if (y >= 6){
            lesson6_right.setEnabled(true);
        }
        if (y >= 7){
            lesson7_right.setEnabled(true);
        }
        //set lesson number
        if (x>=1){
            lesson1_left.setEnabled(true);
        }
        if (x>=2){
            lesson2.setImageResource(R.drawable.card2);
            lesson2_left.setEnabled(true);
            lesson1_right.setEnabled(true);
        }
        if (x>=3){
            lesson3.setImageResource(R.drawable.card3);
            lesson3_left.setEnabled(true);
            lesson2_right.setEnabled(true);
        }
        if (x>=4){
            lesson4.setImageResource(R.drawable.card4);
            lesson4_left.setEnabled(true);
            lesson3_right.setEnabled(true);
        }
        if (x>=5){
            lesson5.setImageResource(R.drawable.card5);
            lesson5_left.setEnabled(true);
            lesson4_right.setEnabled(true);
        }
        if (x>=6) {
            lesson6.setImageResource(R.drawable.card7);
            lesson6_left.setEnabled(true);
            lesson5_right.setEnabled(true);
        }
        if (x>=7) {
            lesson7.setImageResource(R.drawable.card8);
            lesson7_left.setEnabled(true);
            lesson6_right.setEnabled(true);
        }
    }

    //set which page in learn1 to go
    public void learnPage1(View view){
        Intent intent = new Intent(this,Learning1.class);
        CURRENT_LESSON = 1;
        CURRENT_LEARN = 1;
//        switch (CHOOSEN_WOMBAT) {
//            case "wombat1":
//                flag_learn_wombat1 = 1;
//                break;
//            case "wombat2":
//                flag_learn_wombat2 = 1;
//                break;
//            case "wombat3":
//                flag_learn_wombat3 = 1;
//                break;
//        }
        switch (CHOOSEN_WOMBAT) {
            case "wombat1":
                flag_wombat1 = 1;
                break;
            case "wombat2":
                flag_wombat2 = 1;
                break;
            case "wombat3":
                flag_wombat3 = 1;
                break;
        }
        startActivity(intent);
    }
    //set which page in learn2 to go
    public void learnPage2(View view){
        Intent intent = new Intent(this,Learning2.class);
        CURRENT_LESSON = 2;
        CURRENT_LEARN = 2;
//        switch (CHOOSEN_WOMBAT) {
//            case "wombat1":
//                flag_learn_wombat1 = 2;
//                break;
//            case "wombat2":
//                flag_learn_wombat2 = 2;
//                break;
//            case "wombat3":
//                flag_learn_wombat3 = 2;
//                break;
//        }
        switch (CHOOSEN_WOMBAT) {
            case "wombat1":
                flag_wombat1 = 2;
                break;
            case "wombat2":
                flag_wombat2 = 2;
                break;
            case "wombat3":
                flag_wombat3 = 2;
                break;
        }
        startActivity(intent);
    }

    //set which page in learn3 to go
    public void learnPage3(View view){
        Intent intent = new Intent(this,Learning3.class);
        CURRENT_LESSON = 3;
        CURRENT_LEARN = 3;
//        switch (CHOOSEN_WOMBAT) {
//            case "wombat1":
//                flag_learn_wombat1 = 3;
//                break;
//            case "wombat2":
//                flag_learn_wombat2 = 3;
//                break;
//            case "wombat3":
//                flag_learn_wombat3 = 3;
//                break;
//        }
        switch (CHOOSEN_WOMBAT) {
            case "wombat1":
                flag_wombat1 = 3;
                break;
            case "wombat2":
                flag_wombat2 = 3;
                break;
            case "wombat3":
                flag_wombat3 = 3;
                break;
        }
        startActivity(intent);
    }

    //set which page in learn4 to go
    public void learnPage4(View view){
        Intent intent = new Intent(this,Learning4.class);
        CURRENT_LESSON = 4;
        CURRENT_LEARN = 4;
//        switch (CHOOSEN_WOMBAT) {
//            case "wombat1":
//                flag_learn_wombat1 = 4;
//                break;
//            case "wombat2":
//                flag_learn_wombat2 = 4;
//                break;
//            case "wombat3":
//                flag_learn_wombat3 = 4;
//                break;
//        }
        switch (CHOOSEN_WOMBAT) {
            case "wombat1":
                flag_wombat1 = 4;
                break;
            case "wombat2":
                flag_wombat2 = 4;
                break;
            case "wombat3":
                flag_wombat3 = 4;
                break;
        }
        startActivity(intent);
    }

    //set which page in learn5 to go
    public void learnPage5(View view){
        Intent intent = new Intent(this,Learning5.class);
        CURRENT_LESSON = 5;
        CURRENT_LEARN = 5;
//        switch (CHOOSEN_WOMBAT) {
//            case "wombat1":
//                flag_learn_wombat1 = 5;
//                break;
//            case "wombat2":
//                flag_learn_wombat2 = 5;
//                break;
//            case "wombat3":
//                flag_learn_wombat3 = 5;
//                break;
//        }
        switch (CHOOSEN_WOMBAT) {
            case "wombat1":
                flag_wombat1 = 5;
                break;
            case "wombat2":
                flag_wombat2 = 5;
                break;
            case "wombat3":
                flag_wombat3 = 5;
                break;
        }
        startActivity(intent);
    }

    //set which page in learn6 to go
    public void learnPage6(View view){
        Intent intent = new Intent(this,Learning6.class);
        CURRENT_LESSON = 6;
        CURRENT_LEARN = 6;
//        switch (CHOOSEN_WOMBAT) {
//            case "wombat1":
//                flag_learn_wombat1 = 6;
//                break;
//            case "wombat2":
//                flag_learn_wombat2 = 6;
//                break;
//            case "wombat3":
//                flag_learn_wombat3 = 6;
//                break;
//        }
        switch (CHOOSEN_WOMBAT) {
            case "wombat1":
                flag_wombat1 = 6;
                break;
            case "wombat2":
                flag_wombat2 = 6;
                break;
            case "wombat3":
                flag_wombat3 = 6;
                break;
        }
        startActivity(intent);
    }

    //set which page in learn7 to go
    public void learnPage7(View view){
        Intent intent = new Intent(this,Learning6.class);
        CURRENT_LESSON = 7;
        CURRENT_LEARN = 7;
//        switch (CHOOSEN_WOMBAT) {
//            case "wombat1":
//                flag_learn_wombat1 = 7;
//                break;
//            case "wombat2":
//                flag_learn_wombat2 = 7;
//                break;
//            case "wombat3":
//                flag_learn_wombat3 = 7;
//                break;
//        }
        switch (CHOOSEN_WOMBAT) {
            case "wombat1":
                flag_wombat1 = 7;
                break;
            case "wombat2":
                flag_wombat2 = 7;
                break;
            case "wombat3":
                flag_wombat3 = 7;
                break;
        }
        startActivity(intent);
    }

    //set which page in test1 to go
    public void testPage1(View view){
        CURRENT_LESSON = 1;
        CURRENT_TEST = 1;
//        switch (CHOOSEN_WOMBAT) {
//            case "wombat1":
//                flag_test_wombat1 = 1;
//                break;
//            case "wombat2":
//                flag_test_wombat2 = 1;
//                break;
//            case "wombat3":
//                flag_test_wombat3 = 1;
//                break;
//        }
        switch (CHOOSEN_WOMBAT) {
            case "wombat1":
                flag_wombat1 = 2;
                break;
            case "wombat2":
                flag_wombat2 = 2;
                break;
            case "wombat3":
                flag_wombat3 = 2;
                break;
        }
        Intent intent = new Intent(this,Testing1.class);
        startActivity(intent);
    }

    //set which page in test2 to go
    public void testPage2(View view){
        CURRENT_LESSON = 2;
        CURRENT_TEST = 2;
//        switch (CHOOSEN_WOMBAT) {
//            case "wombat1":
//                flag_test_wombat1 = 2;
//                break;
//            case "wombat2":
//                flag_test_wombat2 = 2;
//                break;
//            case "wombat3":
//                flag_test_wombat3 = 2;
//                break;
//        }

        switch (CHOOSEN_WOMBAT) {
            case "wombat1":
                flag_wombat1 = 3;
                break;
            case "wombat2":
                flag_wombat2 = 3;
                break;
            case "wombat3":
                flag_wombat3 = 3;
                break;
        }
        Intent intent = new Intent(this,Testing2.class);
        startActivity(intent);
    }

    //set which page in test3 to go
    public void testPage3(View view){
        CURRENT_LESSON = 3;
        CURRENT_TEST = 3;
//        switch (CHOOSEN_WOMBAT) {
//            case "wombat1":
//                flag_test_wombat1 = 3;
//                break;
//            case "wombat2":
//                flag_test_wombat2 = 3;
//                break;
//            case "wombat3":
//                flag_test_wombat3 = 3;
//                break;
//        }

        switch (CHOOSEN_WOMBAT) {
            case "wombat1":
                flag_wombat1 = 4;
                break;
            case "wombat2":
                flag_wombat2 = 4;
                break;
            case "wombat3":
                flag_wombat3 = 4;
                break;
        }
        Intent intent = new Intent(this,Testing1.class);
        startActivity(intent);
    }

    //set which page in test4 to go
    public void testPage4(View view){
        CURRENT_LESSON = 4;
        CURRENT_TEST = 4;
//        switch (CHOOSEN_WOMBAT) {
//            case "wombat1":
//                flag_test_wombat1 = 4;
//                break;
//            case "wombat2":
//                flag_test_wombat2 = 4;
//                break;
//            case "wombat3":
//                flag_test_wombat3 = 4;
//                break;
//        }
        switch (CHOOSEN_WOMBAT) {
            case "wombat1":
                flag_wombat1 = 5;
                break;
            case "wombat2":
                flag_wombat2 = 5;
                break;
            case "wombat3":
                flag_wombat3 = 5;
                break;
        }
        Intent intent = new Intent(this,Testing1.class);
        startActivity(intent);
    }

    //set which page in test5 to go
    public void testPage5(View view){
        CURRENT_LESSON = 5;
        CURRENT_TEST = 5;
//        switch (CHOOSEN_WOMBAT) {
//            case "wombat1":
//                flag_test_wombat1 = 5;
//                break;
//            case "wombat2":
//                flag_test_wombat2 = 5;
//                break;
//            case "wombat3":
//                flag_test_wombat3 = 5;
//                break;
//        }
        switch (CHOOSEN_WOMBAT) {
            case "wombat1":
                flag_wombat1 = 6;
                break;
            case "wombat2":
                flag_wombat2 = 6;
                break;
            case "wombat3":
                flag_wombat3 = 6;
                break;
        }
        Intent intent = new Intent(this,Testing1.class);
        startActivity(intent);
    }

    //set which page in test6 to go
    public void testPage6(View view){
        CURRENT_LESSON = 6;
        CURRENT_TEST = 6;
//        switch (CHOOSEN_WOMBAT) {
//            case "wombat1":
//                flag_test_wombat1 = 6;
//                break;
//            case "wombat2":
//                flag_test_wombat2 = 6;
//                break;
//            case "wombat3":
//                flag_test_wombat3 = 6;
//                break;
//        }
        switch (CHOOSEN_WOMBAT) {
            case "wombat1":
                flag_wombat1 = 7;
                break;
            case "wombat2":
                flag_wombat2 = 7;
                break;
            case "wombat3":
                flag_wombat3 = 7;
                break;
        }
        Intent intent = new Intent(this,Testing1.class);
        startActivity(intent);
    }

    //set which page in test7 to go
    public void testPage7(View view){
        CURRENT_LESSON = 7;
        CURRENT_TEST = 7;
//        switch (CHOOSEN_WOMBAT) {
//            case "wombat1":
//                flag_test_wombat1 = 7;
//                break;
//            case "wombat2":
//                flag_test_wombat2 = 7;
//                break;
//            case "wombat3":
//                flag_test_wombat3 = 7;
//                break;
//        }
        switch (CHOOSEN_WOMBAT) {
            case "wombat1":
                flag_wombat1 = 7;
                break;
            case "wombat2":
                flag_wombat2 = 7;
                break;
            case "wombat3":
                flag_wombat3 = 7;
                break;
        }
        Intent intent = new Intent(this,Testing1.class);
        startActivity(intent);
    }

}
