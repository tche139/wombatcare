package com.example.fistinbone.myapplication.Fragment;

/**
 * Created by fistinbone on 9/11/2017.
 */
import java.io.IOException;

import android.app.Service;
import android.content.Intent;
import android.media.MediaPlayer;
import android.media.MediaPlayer.OnCompletionListener;
import android.media.MediaPlayer.OnErrorListener;
import android.os.IBinder;

import com.example.fistinbone.myapplication.R;

public class MusicService extends Service {
    private MediaPlayer mp;

    @Override
    public void onCreate() {
        // 初始化音乐资源
        try {
            mp = MediaPlayer.create(this, R.raw.backsound_cute);
            mp.prepare();
        } catch (IllegalStateException e) {
            // TODO 自动生成的 catch 块
            e.printStackTrace();
        } catch (IOException e) {
            // TODO 自动生成的 catch 块
            e.printStackTrace();
        }
        super.onCreate();

    }

    @Override
    public void onStart(Intent intent, int startId) {
        // TODO 自动生成的方法存根
        //开始播放音乐
        if(mp != null) {
            mp.start();
            //注册回调函数，音乐播放完毕之后，音乐播放完毕的事件处理
            mp.setOnCompletionListener(new OnCompletionListener() {

                public void onCompletion(MediaPlayer mp) {
                    try {
                        mp.start();
                    } catch (IllegalStateException e) {
                        // TODO 自动生成的 catch 块
                        e.printStackTrace();
                    }

                }
            });

            mp.setOnErrorListener(new OnErrorListener() {

                public boolean onError(MediaPlayer mp, int what, int extra) {
                    try {
                        mp.release();
                    } catch (Exception e) {
                        // TODO 自动生成的 catch 块
                        e.printStackTrace();
                    }
                    return false;
                }
            });

        }

        super.onStart(intent, startId);
    }


    @Override
    public void onDestroy() {
        // 服务停止时停止播放器并且释放资源
        if (mp != null) {
            mp.stop();
            mp.release();
        }
        super.onDestroy();
    }

    @Override
    public IBinder onBind(Intent intent) {
        // TODO 自动生成的方法存根
        return null;
    }

}