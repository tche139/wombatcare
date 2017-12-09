package com.example.fistinbone.myapplication;

import android.content.Intent;
import android.media.MediaPlayer;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.VideoView;

import com.example.fistinbone.myapplication.Fragment.MusicService;

/**
 * Created by fistinbone on 8/31/2017.
 */

public class WombatMovie extends AppCompatActivity {

    VideoView videoView;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.wombatmovie);

        videoView = (VideoView) findViewById(R.id.videoView);
        String uriPath = "android.resource://" + getPackageName() + "/" +R.raw.wombatmovie;
        Uri uri = Uri.parse(uriPath);
        videoView.setVideoURI(uri);
        videoView.requestFocus();
        videoView.start();
        //set wombat movie listener
        videoView.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
            public void onCompletion(MediaPlayer mp) {
                WombatMovie.this.runOnUiThread(new Runnable() {
                    //run wombat movie
                    @Override
                    public void run() {
                        Intent main = new Intent(WombatMovie.this, WomCare.class);
                        WombatMovie.this.startActivity(main);
                        WombatMovie.this.finish();
                    }
                });
            }
        });
    }

    //skip button
    public void skip(View v){
        Intent intent = new Intent(this, WomCare.class);
        startActivity(intent);
    }

}
