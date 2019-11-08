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
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.TextView;

public class ARCdata extends AppCompatActivity implements View.OnClickListener {
    private ProgressBar mprogressbar;
    private int mprogressbarStat =0;
   // public int roomnum;
    private Handler handler = new Handler();
    private TextView full;
    private TextView notbusy;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_arcdata);

        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        setOnClickListener();
     /*
        FloatingActionButton fab = findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });

  */
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

    public void readData(){


    }


    public void database(int roomnum){
        FirebaseDatabase database = FirebaseDatabase.getInstance();
        DatabaseReference myRef = database.getReference("message");
        myRef.setValue("room number " + roomnum);
        //roomnum++;

        // Read from the database
        myRef.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                // This method is called once with the initial value and again
                // whenever data at this location is updated.
                String value = dataSnapshot.getValue(String.class);
                Log.d("room number " , "Value is: " + value);
            }

            @Override
            public void onCancelled(DatabaseError error) {
                // Failed to read value
                Log.w("room number " , "Failed to read value.", error.toException());
            }
        });


    }

    @Override
    public void onClick(View view) {
       // database();

        switch (view.getId()) {
            case R.id.r110:
                database(110);
                Button r110 =  (Button)findViewById(R.id.r110);
                if(r110.getText()=="Occupy"){
                    r110.setText("Occupied");
                } else{
                    r110.setText("Occupy");
                }
                break;
            case R.id.r112:
                database(112);
                Button r112 =  (Button)findViewById(R.id.r112);
                if(r112.getText()=="Occupy"){
                    r112.setText("Occupied");
                } else{
                    r112.setText("Occupy");
                }
                break;
            case R.id.r131:
                database(131);
                Button r131 =  (Button)findViewById(R.id.r131);
                if(r131.getText()=="Occupy"){
                    r131.setText("Occupied");
                } else{
                    r131.setText("Occupy");
                }
                break;

            case R.id.r147:
                database(141);
                Button r147 =  (Button)findViewById(R.id.r147);
                if(r147.getText()=="Occupy"){
                    r147.setText("Occupied");
                } else{
                    r147.setText("Occupy");
                }
                break;


            case R.id.r149:
                database(149);
                Button r149 =  (Button)findViewById(R.id.r149);
                if(r149.getText()=="Occupy"){
                    r149.setText("Occupied");
                } else{
                    r149.setText("Occupy");
                }
                break;

            case R.id.r151:
                database(151);
                Button r151 =  (Button)findViewById(R.id.r151);
                if(r151.getText()=="Occupy"){
                    r151.setText("Occupied");
                } else{
                    r151.setText("Occupy");
                }
                break;


            case R.id.r214:
                database(214);
                Button r214 =  (Button)findViewById(R.id.r214);
                if(r214.getText()=="Occupy"){
                    r214.setText("Occupied");
                } else{
                    r214.setText("Occupy");
                }
                break;

            case R.id.r216:
                database(216);
                Button r216 =  (Button)findViewById(R.id.r216);
                if(r216.getText()=="Occupy"){
                    r216.setText("Occupied");
                } else{
                    r216.setText("Occupy");
                }
                break;


            case R.id.r217:
                database(217);
                Button r217 =  (Button)findViewById(R.id.r217);
                if(r217.getText()=="Occupy"){
                    r217.setText("Occupied");
                } else{
                    r217.setText("Occupy");
                }
                break;


            case R.id.r219:
                //database(219);
                Button r219 =  (Button)findViewById(R.id.r219);
                if(r219.getText()=="Occupy"){
                    r219.setText("Occupied");
                } else{
                    r219.setText("Occupy");
                }
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
