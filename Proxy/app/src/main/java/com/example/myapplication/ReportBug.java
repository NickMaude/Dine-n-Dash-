package com.example.myapplication;

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
 * Class to allow user to create an error report
 *
 * @author x
 */
public class ReportBug extends AppCompatActivity {

    private EditText mEditTextBug;

    /**
     * Method to create report
     * @param savedInstanceState
     */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_report_bug);

        mEditTextBug = findViewById(R.id.edit_text_bug);

        Button buttonSend = findViewById(R.id.button_send);
        buttonSend.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                sendMail();
            }
        });
    }

    /**
     * Method to send report
     */
    private void sendMail() {
        double random = Math.random();
        String recipient = "proxycreators@gmail.com";
        String recipients[] = {""};
        recipients[0] = recipient;
        String subject = "Bug " + random;
        String bug = mEditTextBug.getText().toString();

        Intent intent = new Intent(Intent.ACTION_SEND);

        intent.putExtra(Intent.EXTRA_EMAIL, recipients);
        intent.putExtra(Intent.EXTRA_SUBJECT, subject);
        intent.putExtra(Intent.EXTRA_TEXT, bug);

        intent.setType("message/rfc822");
        startActivity(Intent.createChooser(intent, "Choose an email client."));
    }

}
