package com.example.myapplication;

import android.content.Intent;
import android.os.Bundle;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.os.Handler;
import android.util.Log;
import android.view.View;
import android.widget.ProgressBar;
import android.widget.TextView;

public class ARCdata extends AppCompatActivity implements View.OnClickListener {
    private ProgressBar mprogressbar;
    private int mprogressbarStat =0;
    public int roomnum =0;
    private Handler handler = new Handler();
    private TextView full;
    private TextView notbusy;
    java.io.ByteArrayOutputStream out = new java.io.ByteArrayOutputStream();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        FirebaseDatabase database = FirebaseDatabase.getInstance();
        DatabaseReference myRef = database.getReference("message");
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_arcdata);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        setOnClickListener();
        mprogressbar = findViewById(R.id.progressBar);
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

    public void readData(){


    }


    @Override
    public void onClick(View view) {

        FirebaseDatabase database = FirebaseDatabase.getInstance();
        final DatabaseReference myRef = database.getReference("message");
        final DataSnapshot dataSnapshot;
        Integer value = 0;

        myRef.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                // This method is called once with the initial value and again
                // whenever data at this location is updated.
                out = dataSnapshot.getValue(java.io.ByteArrayOutputStream.class);
                System.setOut(new java.io.PrintStream(out));
            }

            @Override
            public void onCancelled(DatabaseError error) {
                // Failed to read value
                Log.w("room number " + roomnum, "Failed to read value.", error.toException());
            }
        });

        switch (view.getId()) {
            case R.id.r110:
                /*if (out.toString() == "1") {
                    value = 0;
                } else {
                    value = 1;
                }*/
                
                myRef.child("110").child("isOccupied").setValue(value);
                break;
            case R.id.r112:
                if (out.toString() == "1") {
                    value = 0;
                } else {
                    value = 1;
                }
                myRef.child("112").child("isOccupied").setValue(value);
                break;
        }
    }
    private void setOnClickListener(){
        findViewById(R.id.r110).setOnClickListener(this);
        findViewById(R.id.r112).setOnClickListener(this);
        findViewById(R.id.r131).setOnClickListener(this);
        findViewById(R.id.r147).setOnClickListener(this);
        findViewById(R.id.r149).setOnClickListener(this);
        findViewById(R.id.r151).setOnClickListener(this);
        findViewById(R.id.r153).setOnClickListener(this);
        findViewById(R.id.r214).setOnClickListener(this);
        findViewById(R.id.r216).setOnClickListener(this);
        findViewById(R.id.r217).setOnClickListener(this);
        findViewById(R.id.r219).setOnClickListener(this);



    }


}
