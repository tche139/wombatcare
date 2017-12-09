package com.example.fistinbone.myapplication;

import android.content.ContentValues;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.media.MediaPlayer;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.constraint.ConstraintLayout;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.ViewStub;
import android.view.animation.Animation;
import android.view.animation.TranslateAnimation;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.fistinbone.myapplication.Fragment.MusicService;
import com.example.fistinbone.myapplication.SQLite.FeedReaderContract;
import com.example.fistinbone.myapplication.SQLite.FeedReaderDbHelper;

import java.util.Random;
import java.util.Timer;
import java.util.TimerTask;


public class WomCare extends AppCompatActivity {
    public static int wombat1_stage = 1;
    public static int wombat2_stage = 1;
    public static int wombat3_stage = 1;
    public static String CHOOSEN_WOMBAT = "";
    public static int CURRENT_LESSON = 0;
    public static int PAGE_NUMBER = 0;
    public static int PAGE_SIZE = 0;
    public static boolean GUIDE_STATE = false;
    public static int wombat1_quiz = 0;
    public static int wombat2_quiz = 0;
    public static int wombat3_quiz = 0;
    public static int CURRENT_TEST = 0;
    public static int CURRENT_LEARN = 0;
    public static int flag_learn_wombat1,flag_learn_wombat2,flag_learn_wombat3;
    public static int flag_test_wombat1,flag_test_wombat2,flag_test_wombat3;
    public static int flag_wombat1, flag_wombat2, flag_wombat3;
    public static String _name = "please pick a name";
    public static String _gender = "male";
    public static int testCompleted = 0;

    public static boolean isQuizSelected1 = false;
    public static boolean isQuizSelected2 = false;
    public static Intent intentMusic;


    int[] stage = new int[3];
    int[] quiz = new int[3];
    int[] id = new int[3];

    Boolean ifDataInitialized = false;

    Boolean translantion = false;
    ViewStub viewStub;
    View guideSlideView;
    ImageView setting, website, medal, event, translate, report;
    Float factor;
    MediaPlayer mediaPlayer;
    Random rand = new Random();

    ImageView dialog_1,dialog_2,dialog_3;
    TextView dialogTextView,dialogTextView_s;

    int[] c_dialog = {R.drawable.transparent1,R.drawable.c_dialogue1,R.drawable.c_dialogue2,
            R.drawable.c_dialogue3,R.drawable.c_dialogue4,R.drawable.c_dialogue5,R.drawable.transparent1};
    int[] s_dialog = {R.drawable.transparent2,R.drawable.s_dialogue1,R.drawable.s_dialogue2,
            R.drawable.s_dialogue3,R.drawable.s_dialogue4,R.drawable.s_dialogue5,R.drawable.s_dialogue6,R.drawable.transparent2};
    int[] n_dialog = {R.drawable.transparent1,R.drawable.n_dialogue1,R.drawable.n_dialogue2,
            R.drawable.n_dialogue3,R.drawable.n_dialogue4,R.drawable.n_dialogue5,R.drawable.transparent1};

    ImageView imageButton1;

    int button_status=1;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_wom_care);
        //setup sharedpreference
        SharedPreferences sharedPref = this.getPreferences(Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPref.edit();

        intentMusic = new Intent(this, MusicService.class);
        startService(intentMusic);

        //click he select
        mediaPlayer = MediaPlayer.create(this, R.raw.click);

        dialog_1 = (ImageView) findViewById(R.id.dialog1);
        dialog_2 = (ImageView) findViewById(R.id.dialog2);
        dialog_3 = (ImageView) findViewById(R.id.dialog3);
        dialogTextView = (TextView) findViewById(R.id.textView21);
        dialogTextView_s = (TextView) findViewById(R.id.textView22);
        imageButton1 = (ImageView) findViewById((R.id.buttonMute));

        setting = (ImageView) findViewById(R.id.setting);
        website = (ImageView) findViewById(R.id.websites);
        medal = (ImageView) findViewById(R.id.medal);
        event = (ImageView) findViewById(R.id.event);
        report = (ImageView) findViewById(R.id.report);


        translate = (ImageView) findViewById(R.id.button_translate);
        setting.setVisibility(View.GONE);
        website.setVisibility(View.GONE);
        medal.setVisibility(View.GONE);
        event.setVisibility(View.GONE);
        report.setVisibility(View.GONE);

        initialData();
        loadData();

        System.out.println(_name);
        System.out.println(_gender);

        factor = getResources().getDisplayMetrics().density;

        imageButton1.setImageResource(R.drawable.un_mute);
        imageButton1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (button_status == 1) {
                    imageButton1.setImageResource(R.drawable.mute);
                    button_status = 0;
                    stopService(intentMusic);
                } else {
                    imageButton1.setImageResource(R.drawable.un_mute);
                    button_status = 1;
                    startService(intentMusic);
                }
            }
        });


        Timer timer1 = new Timer();
        MyTimer1 myTimer1 = new MyTimer1();
        timer1.schedule(myTimer1, 1000, 3500);
        Timer timer2 = new Timer();
        MyTimer2 myTimer2 = new MyTimer2();
        timer2.schedule(myTimer2, 1500, 3500);
        Timer timer3 = new Timer();
        MyTimer3 myTimer3 = new MyTimer3();
        timer3.schedule(myTimer3, 500, 3000);




        if (!sharedPref.getBoolean(("hint showed"),false)) {
            //set view stub for the launch page
            viewStub = (ViewStub) findViewById(R.id.guide1);
            if (!GUIDE_STATE) {
                guideSlideView = viewStub.inflate();
                ConstraintLayout constraintLayout = (ConstraintLayout) guideSlideView.findViewById(R.id.guide1_root);
                if (constraintLayout != null) {
                    constraintLayout.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View view) {
                            guideSlideView.setVisibility(View.GONE);
                            GUIDE_STATE = true;

                        }
                    });
                }
            }


        }
        editor.putBoolean("hint showed", true);
        editor.commit();
    }

    //set movement of each wombat
    public void wombat1(View view) {
        mediaPlayer.start();
        Intent intent = new Intent(this, Wombat.class);
        CHOOSEN_WOMBAT = "wombat1";
        startActivity(intent);

    }

    public void wombat2(View view) {
        Intent intent = new Intent(this, Wombat.class);
        CHOOSEN_WOMBAT = "wombat2";
        startActivity(intent);
        mediaPlayer.start();
    }

    public void wombat3(View view) {
        Intent intent = new Intent(this, Wombat.class);
        CHOOSEN_WOMBAT = "wombat3";
        startActivity(intent);
        mediaPlayer.start();
    }

    //set movement of the website
    public void website(View view) {
        Intent intent = new Intent(this, Website.class);
        startActivity(intent);
        mediaPlayer.start();
    }

    //set movement of medal
    public void medal(View view) {
        Intent intent = new Intent(this, Medal.class);
        startActivity(intent);
        mediaPlayer.start();
    }

    //set movement of event
    public void event(View view) {
        Intent intent = new Intent(this, Event.class);
        startActivity(intent);
        mediaPlayer.start();
    }

    //set movement of setting
    public void setting(View view) {
        Intent intent = new Intent(this, Setting.class);
        startActivity(intent);
        mediaPlayer.start();
    }

    //set movement of report
    public void report(View view) {
        Intent intent = new Intent(this, Report.class);
        startActivity(intent);
        mediaPlayer.start();
    }

    //set movement of translating animation
    public void translate(View view, int x, int y, int z) {
        Animation animation = new TranslateAnimation(0, 0, x, y);
        animation.setDuration(z);
        view.startAnimation(animation);
    }

    //set the effect of translating animation
    public void translation(View view) {
        mediaPlayer.start();
        int x, y, z;
        y = (int) (48 * factor);
        z = (int) (16 * factor);
        if (!translantion) {
            translate.setImageResource(R.drawable.down);
            setting.setVisibility(View.VISIBLE);
            website.setVisibility(View.VISIBLE);
            medal.setVisibility(View.VISIBLE);
            event.setVisibility(View.VISIBLE);
            report.setVisibility(View.VISIBLE);
            x = (int) (-60 * factor);
            translate(setting, -x, 0, 175);
            x = (int) (-120 * factor);
            translate(medal, -x, 0, 225);
            x = (int) (-180 * factor);
            translate(event, -x, 0, 275);
            x = (int) (-240 * factor);
            translate(website, -x, 0, 325);
            x = (int) (-300 * factor);
            translate(report, -x, 0, 375);
        } else {
            translate.setImageResource(R.drawable.up);
            x = (int) (-60 * factor);
            x = (int) (-60 * factor);
            translate(setting, 0, -x, 250);
            x = (int) (-120 * factor);
            translate(medal, 0, -x, 250);
            x = (int) (-180 * factor);
            translate(event, 0, -x, 250);
            x = (int) (-240 * factor);
            translate(website, 0, -x, 250);
            x = (int) (-300 * factor);
            translate(report, 0, -x, 250);
            setting.setVisibility(View.GONE);
            website.setVisibility(View.GONE);
            medal.setVisibility(View.GONE);
            event.setVisibility(View.GONE);
            report.setVisibility(View.GONE);
        }
        translantion = !translantion;
    }


    //constructor of database
    public class backgroundTask extends AsyncTask<String,Void,Void> {
        Context context;
        int[] stage;
        int[] quiz;
        String name;
        String gender;
        backgroundTask(Context context,int[] stage,int[] quiz,String name,String gender){
            this.context = context;
            this.quiz = quiz;
            this.stage = stage;
            this.name = name;
            this.gender = gender;
        }




        @Override
        protected void onPreExecute() {
            super.onPreExecute();
        }

        @Override
        //add get values to the database
        protected Void doInBackground(String... params) {
            String method = params[0];
            if (method.equals("save")) {
                FeedReaderDbHelper feedReaderDbHelper = new FeedReaderDbHelper(context);
                SQLiteDatabase sqLiteDatabase = feedReaderDbHelper.getWritableDatabase();
                // test if table exist , if false create one, if true skip
//                //drop table, if necessary
//                sqLiteDatabase.execSQL(SQL_DELETE_ENTRIES);
//                //create table , only run once
                    feedReaderDbHelper.onCreate(sqLiteDatabase);
                    ContentValues values = new ContentValues();
                    for (int i = 0; i < 3; i++) {
                        values.put(FeedReaderContract.FeedEntry._ID, i);
                        values.put(FeedReaderContract.FeedEntry.COLUMN_NAME_STAGE, stage[i]);
                        values.put(FeedReaderContract.FeedEntry.COLUMN_NAME_QUIZ, quiz[i]);
                        values.put(FeedReaderContract.FeedEntry.NAME, name);
                        values.put(FeedReaderContract.FeedEntry.GENDER, gender);
                        sqLiteDatabase.insert(FeedReaderContract.FeedEntry.TABLE_NAME, null, values);
                        System.out.println("success input row" + i);
                    }
                    feedReaderDbHelper.close();
                }

            //load data from database
            if (method.equals("load")){
                FeedReaderDbHelper feedReaderDbHelper = new FeedReaderDbHelper(context);
                SQLiteDatabase sqLiteDatabase = feedReaderDbHelper.getReadableDatabase();
                String[] projections = {FeedReaderContract.FeedEntry._ID,
                        FeedReaderContract.FeedEntry.COLUMN_NAME_STAGE,
                        FeedReaderContract.FeedEntry.COLUMN_NAME_QUIZ,
                        FeedReaderContract.FeedEntry.NAME,
                        FeedReaderContract.FeedEntry.GENDER};
                Cursor cursor = sqLiteDatabase.query(FeedReaderContract.FeedEntry.TABLE_NAME,projections,
                        null,null,null,null,null);
                int i = 0;
                while (cursor.moveToNext()){
                    stage[i] = cursor.getInt(cursor.getColumnIndex(FeedReaderContract.FeedEntry.COLUMN_NAME_STAGE));
                    quiz[i] = cursor.getInt(cursor.getColumnIndex(FeedReaderContract.FeedEntry.COLUMN_NAME_QUIZ));
                    id[i] = cursor.getInt(cursor.getColumnIndex(FeedReaderContract.FeedEntry._ID));
                    name = cursor.getString(cursor.getColumnIndex(FeedReaderContract.FeedEntry.NAME));
                    gender = cursor.getString(cursor.getColumnIndex(FeedReaderContract.FeedEntry.GENDER));
                    i++;
                }
                cursor.close();
                wombat1_stage = stage[0];
                wombat2_stage = stage[1];
                wombat3_stage = stage[2];
                wombat1_quiz = quiz[0];
                wombat2_quiz = quiz[1];
                wombat3_quiz = quiz[2];
                _name = name;
                _gender = gender;
                feedReaderDbHelper.close();
            }

            //upload data from database
            if (method.equals("upload")) {
                FeedReaderDbHelper feedReaderDbHelper = new FeedReaderDbHelper(context);
                SQLiteDatabase sqLiteDatabase = feedReaderDbHelper.getWritableDatabase();
                ContentValues values = new ContentValues();
                for (int i = 0; i < 3; i++) {
                    String selection = FeedReaderContract.FeedEntry._ID + " = ?";
                    String[] selectionArgs = {i+""};
                    values.put(FeedReaderContract.FeedEntry._ID, i);
                    values.put(FeedReaderContract.FeedEntry.COLUMN_NAME_STAGE, stage[i]);
                    values.put(FeedReaderContract.FeedEntry.COLUMN_NAME_QUIZ, quiz[i]);
                    int count = sqLiteDatabase.update(
                            FeedReaderContract.FeedEntry.TABLE_NAME,
                            values,
                            selection,
                            selectionArgs
                    );
                    System.out.println("success input row" + i);
                }
                feedReaderDbHelper.close();
            }
            return null;
        }

        @Override
        protected void onProgressUpdate(Void... values) {
            super.onProgressUpdate(values);
        }

        @Override
        protected void onPostExecute(Void aVoid) {
            super.onPostExecute(aVoid);
        }
    }

    //save data to data base
    public void initialData(){
        if(!ifDataInitialized) {
            int[] stage = new int[3];
            int[] quiz = new int[3];
            stage[0] = wombat1_stage;
            stage[1] = wombat2_stage;
            stage[2] = wombat3_stage;
            quiz[0] = wombat1_quiz;
            quiz[1] = wombat2_quiz;
            quiz[2] = wombat3_quiz;
            //access sqlite
            System.out.println(stage[0]);
            System.out.println(quiz[0]);
            System.out.println(id[0]);
            backgroundTask backgroundTask = new backgroundTask(this, stage, quiz,_name,_gender);
            backgroundTask.execute("save");
            ifDataInitialized = true;
        }else{
            return;
        }
    }
    public void loadData(){
        backgroundTask backgroundTask = new backgroundTask(this,stage,quiz,_name,_gender);
        backgroundTask.execute("load");
    }



    class MyTimer1 extends TimerTask {
        public void run(){
            runOnUiThread(new Runnable() {
                @Override
                public void run() {
                    dialogTextView.setVisibility(View.INVISIBLE);

                    int rand = getRandomNumber();
                    dialog_1.setImageResource(c_dialog[rand]);
                    if(rand == 3){
                        dialogTextView.setVisibility(View.VISIBLE);
                        dialogTextView.setText(R.string.c_dialog);

                    }else{
                        dialogTextView.setVisibility(View.INVISIBLE);
                    }

                }
                private int getRandomNumber() {
                    return new Random().nextInt(7);
                }
            });
        }
    }

    //Timer for soutern hairy-nosed wombat dialog
    class MyTimer2 extends TimerTask {
        public void run(){
            runOnUiThread(new Runnable() {
                @Override
                public void run() {
                    dialogTextView_s.setVisibility(View.INVISIBLE);

                    int rand = getRandomNumber();
                    dialog_2.setImageResource(s_dialog[rand]);
                    if(rand == 4){
                        dialogTextView_s.setVisibility(View.VISIBLE);
                        dialogTextView_s.setText(R.string.s_dialog);

                    }else{
                        dialogTextView_s.setVisibility(View.INVISIBLE);
                    }
                }
                private int getRandomNumber() {
                    return new Random().nextInt(8);
                }
            });
        }
    }

    //Timer for northern hairy-nosed wombat dialog
    class MyTimer3 extends TimerTask {
        public void run(){
            runOnUiThread(new Runnable() {
                @Override
                public void run() {
                    int rand = getRandomNumber();
                    dialog_3.setImageResource(n_dialog[rand]);

                }
                private int getRandomNumber() {
                    return new Random().nextInt(7);
                }
            });
        }
    }



}
