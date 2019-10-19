package com.example.myapplication;

import android.content.Intent;
import android.os.Bundle;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.os.Handler;
import android.view.View;
import android.widget.ProgressBar;
import android.widget.TextView;

public class ARCdata extends AppCompatActivity {
    private ProgressBar mprogressbar;
    private int mprogressbarStat =0;

    private Handler handler = new Handler();
    private TextView full;
    private TextView notbusy;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_arcdata);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });


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
                       // full.setVisibility(View.VISIBLE);
                       // notbusy.setVisibility(View.INVISIBLE);
                    }
                });
            }
        }).start();



    }
    public void back(View view) {
        Intent intent =new Intent(this,second.class);
        startActivity(intent);
    }

}
