package com.proxy.myapplication;

import android.content.Intent;
import android.os.Bundle;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.view.View;
import android.widget.Button;
import android.widget.EditText;
/**
 * Class to run and operate the menu screen that displays locations to users
 *
 * @author x
 */
public class second extends AppCompatActivity{
    EditText ARC;
    /**
     * Method to create buttons that link to the data pages for each location
     */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        Button arc = (Button) findViewById(R.id.ARC);

        arc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent1 =new Intent(second.this,ARCdata.class);
                startActivity(intent1);
            }
        });



        FloatingActionButton fab = findViewById(R.id.fab);

        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                /*Snackbar.make(view, "Would you like to report a bug?", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();*/
                Intent intent1 =new Intent(second.this, ReportBug.class);
                startActivity(intent1);
            }
        });

    }

    /**
     * Method to end session
     */
    public void logout(View view) {
        Intent intent =new Intent(this,MainActivity.class);
        startActivity(intent);
    }

}
