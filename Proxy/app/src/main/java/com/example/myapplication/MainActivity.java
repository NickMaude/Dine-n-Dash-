package com.example.myapplication;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Patterns;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

/**
 * Class to create and operate the login page of the proxy app
 *
 * @author x
 */
public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    FirebaseAuth mAuth;
    EditText editTextUsername, editTextPassword;
    /**
     * Method to add user data to firebase
     *
     * @param savedInstanceState
     */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        findViewById(R.id.button6).setOnClickListener(this);
        findViewById(R.id.login).setOnClickListener(this);
        mAuth=FirebaseAuth.getInstance();
        editTextUsername = findViewById(R.id.editText2);
        editTextPassword = findViewById(R.id.editText3);
    }

    /**
     * Method to check if username and password match an existing user
     *  Username must be a valid Ohio University email
     *  Password must be at least 6 characters long
     *
     *
     */
    public void login() {
        String username = editTextUsername.getText().toString().trim();
        String password = editTextPassword.getText().toString().trim();
        //authentication cases
        if(username.isEmpty()){
            editTextUsername.setError("Email is required");
            editTextUsername.requestFocus();
            return;
        }
        if(password.isEmpty()){
            editTextPassword.setError("Password is required");
            editTextPassword.requestFocus();
            return;

        }
        if(!Patterns.EMAIL_ADDRESS.matcher(username).matches()){//if email is legit
            editTextUsername.setError("Enter a real email address");
            editTextUsername.requestFocus();
            return;
        }
        if(password.length()<6){
            editTextPassword.setError("Password has to be more than 6 characters long");
            editTextPassword.requestFocus();
            return;
        }

        mAuth.signInWithEmailAndPassword(username,password).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
            @Override
            public void onComplete(@NonNull Task<AuthResult> task) {
                if(task.isSuccessful()){
                    Intent intent1 = new Intent(MainActivity.this, second.class);
                    intent1.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                    startActivity(intent1);

                }else{
                    Toast.makeText(getApplicationContext(),task.getException().getMessage(), Toast.LENGTH_SHORT).show();
                }
            }
        });
    }

    /**
     * Trigger login and start activity when button is pressed by user
     *
     * @param view
     */
    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.button6:
                Intent intent = new Intent(this, CreateAccount.class);
                startActivity(intent);
                break;
            case R.id.login:
                login();
                break;

        }
    }
}