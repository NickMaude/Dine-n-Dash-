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

import android.os.Handler;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.TextClock;
import android.widget.TextView;

import java.util.Calendar;

public class ARCdata extends AppCompatActivity implements View.OnClickListener {
    private ProgressBar mprogressbar;
    private int mprogressbarStat =0;
    private Handler handler = new Handler();
    private TextView full;
    private TextView notbusy;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_arcdata);
        setOnClickListener();

        //finds if rooms are already occupied
        set_studyRooms();

        arcdata();


        //create progressbar object
        mprogressbar = (ProgressBar) findViewById(R.id.progressBar);

        new Thread(new Runnable() {
            @Override
            public void run() {
                while(mprogressbarStat < 100){
                    mprogressbarStat++;
                    android.os.SystemClock.sleep(100);
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

    //sets activity to selection page
    public void back(View view) {
        Intent intent =new Intent(this,second.class);
        startActivity(intent);
    }


    public void database(int roomnum, int isoccupied){
        FirebaseDatabase database = FirebaseDatabase.getInstance();
        DatabaseReference myRef = database.getReference(Integer.toString(roomnum));
        myRef.setValue(Integer.toString(isoccupied));
        //myRef.child("room number" + roomnum);


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

        switch (view.getId()) {
            case R.id.r110:
                Button r110 =  (Button)findViewById(R.id.r110);
                if(r110.getText()=="Occupy"){
                    r110.setText("Occupied");
                    database(110,1);

                } else{
                    r110.setText("Occupy");
                    database(110,0);

                }
                break;
            case R.id.r112:
                Button r112 =  (Button)findViewById(R.id.r112);
                if(r112.getText()=="Occupy"){
                    r112.setText("Occupied");
                    database(112,1);

                } else{
                    r112.setText("Occupy");
                    database(112,0);

                }
                break;
            case R.id.r131:
                database(131,1);
                Button r131 =  (Button)findViewById(R.id.r131);
                if(r131.getText()=="Occupy"){
                    r131.setText("Occupied");
                    database(131,1);

                } else{
                    r131.setText("Occupy");
                    database(131,0);

                }
                break;


            case R.id.r147:
                database(141,1);
                Button r147 =  (Button)findViewById(R.id.r147);
                if(r147.getText()=="Occupy"){
                    r147.setText("Occupied");
                    database(147,1);

                } else{
                    r147.setText("Occupy");
                    database(147,0);

                }
                break;


            case R.id.r149:
                Button r149 =  (Button)findViewById(R.id.r149);
                if(r149.getText()=="Occupy"){
                    r149.setText("Occupied");
                    database(149,1);

                } else{
                    r149.setText("Occupy");
                    database(149,0);

                }
                break;

            case R.id.r151:
                Button r151 =  (Button)findViewById(R.id.r151);
                if(r151.getText()=="Occupy"){
                    r151.setText("Occupied");
                    database(151,1);

                } else{
                    r151.setText("Occupy");
                    database(151,0);

                }
                break;
            case R.id.r153:
                Button r153 =  (Button)findViewById(R.id.r153);
                if(r153.getText()=="Occupy"){
                    r153.setText("Occupied");
                    database(153,1);

                } else{
                    r153.setText("Occupy");
                    database(153,0);
                }
                break;
            case R.id.r214:
                Button r214 =  (Button)findViewById(R.id.r214);
                if(r214.getText()=="Occupy"){
                    r214.setText("Occupied");
                    database(214,1);

                } else{
                    r214.setText("Occupy");
                    database(214,0);

                }
                break;

            case R.id.r216:
                Button r216 =  (Button)findViewById(R.id.r216);
                if(r216.getText()=="Occupy"){
                    r216.setText("Occupied");
                    database(216,1);

                } else{
                    r216.setText("Occupy");
                    database(216,0);

                }
                break;


            case R.id.r217:
                Button r217 =  (Button)findViewById(R.id.r217);
                if(r217.getText()=="Occupy"){
                    r217.setText("Occupied");
                    database(217,1);

                } else{
                    r217.setText("Occupy");
                    database(217,0);

                }
                break;


            case R.id.r219:
                Button r219 =  (Button)findViewById(R.id.r219);
                if(r219.getText()=="Occupy"){
                    r219.setText("Occupied");
                    database(219,1);


                } else{
                    r219.setText("Occupy");
                    database(219,0);

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

    //this function will be called OnCreate and will display whether a study room is occupied
    private void set_studyRooms(){
        final int roomnumbers[] = {110, 112,131,147,149,151,153,214,216,217,219}; // array of study room numbers

        //array of buttons used when setting their text value
        final Button studyRooms[] = new Button[11];
        studyRooms[0]= findViewById(R.id.r110);
        studyRooms[1]= findViewById(R.id.r112);
        studyRooms[2]= findViewById(R.id.r131);
        studyRooms[3]= findViewById(R.id.r147);
        studyRooms[4]= findViewById(R.id.r149);
        studyRooms[5]= findViewById(R.id.r151);
        studyRooms[6]= findViewById(R.id.r153);
        studyRooms[7]= findViewById(R.id.r214);
        studyRooms[8]= findViewById(R.id.r216);
        studyRooms[9]= findViewById(R.id.r217);
        studyRooms[10]=findViewById(R.id.r219);

        //create Firebase object
        FirebaseDatabase database = FirebaseDatabase.getInstance();

        for(int i =0; i< 11; i++){ //there are 11 study rooms
            final int j =i;

            //there is database reference for each room in freebase
            DatabaseReference myRef = database.getReference(Integer.toString(roomnumbers[i]));

            myRef.addValueEventListener(new ValueEventListener() {
                @Override
                public void onDataChange(DataSnapshot dataSnapshot) {
                    // This method is called once with the initial value and again
                    // whenever data at this location is updated.

                    //the isoccupied value is 1 or 0, 1 means the room is occupied,
                    String isoccupied = dataSnapshot.getValue(String.class);

                    //print to android studio to check value
                    Log.d("room number " , "Value is: " + isoccupied);

                    //if room is not occupied the button says occupy
                    if(isoccupied.equals("0")){
                        studyRooms[j].setText("Occupy");
                    }else{
                        studyRooms[j].setText("Occupied");

                    }
                }


                @Override
                public void onCancelled(DatabaseError error) {
                    // Failed to read value from real-time database
                    //in case everything breaks
                    Log.w("is occupied value " , "Failed to read value.", error.toException());
                }
            });

        }

    }

    private void arcdata(){
        TextClock clock = (TextClock) findViewById(R.id.clock);
        Calendar time = Calendar.getInstance();
        int hour = time.get(Calendar.HOUR_OF_DAY);
        Log.d("hour is " , "Value is: " + hour);


    }

}
