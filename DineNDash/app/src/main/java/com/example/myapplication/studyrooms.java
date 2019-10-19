package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.os.Handler;
import android.widget.ProgressBar;

public class studyrooms extends AppCompatActivity {

    private ProgressBar mprogressbar;
    private int mprogressbarStat =0;

    private Handler handler = new Handler();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_studyrooms2);

        mprogressbar = (ProgressBar) findViewById(R.id.progressBar);

    new Thread(new Runnable() {
        @Override
        public void run() {
            while(mprogressbarStat < 100){
                mprogressbarStat++;
                android.os.SystemClock.sleep(50);
                handler.post(new Runnable() {
                    @Override
                    public void run() {
                        mprogressbar.setProgress(mprogressbarStat);
                    }
                });
            }
            handler.post(new Runnable() {
                @Override
                public void run() {

                }
            });
        }
    }).start();

    }


}
