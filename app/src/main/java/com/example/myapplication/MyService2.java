package com.example.myapplication;

import android.app.Service;
import android.content.Intent;
import android.media.MediaPlayer;
import android.os.IBinder;

public class MyService2 extends Service {
    public MyService2() {
    }
    MediaPlayer music;

    @Override
    public void onCreate() {
       music= MediaPlayer.create(this,R.raw.music);
        super.onCreate();
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        if(!music.isPlaying())
            music.start();
        return START_STICKY;

    }

    @Override
    public void onDestroy() {
        if(music.isPlaying())
        {
            music.stop();
            music.release();
        }
        super.onDestroy();
    }

    @Override
    public IBinder onBind(Intent intent) {
        // TODO: Return the communication channel to the service.
        throw new UnsupportedOperationException("Not yet implemented");
    }
}