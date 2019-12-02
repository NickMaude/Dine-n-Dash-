package com.proxy.myapplication;

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
 * Class for users to create an account on the Proxy app
 *
 * @author x
 */
public class CreateAccount extends AppCompatActivity implements View.OnClickListener {

    /**
     * The Edit text username.
     */
    EditText editTextUsername, /**
     * The Edit text password.
     */
    editTextPassword;
    private FirebaseAuth mAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create_account);
        editTextUsername = findViewById(R.id.editText4);
        editTextPassword = findViewById(R.id.editText);
        mAuth = FirebaseAuth.getInstance();
        findViewById(R.id.button7).setOnClickListener(this);
        findViewById(R.id.button9).setOnClickListener(this);


    }

    /**
     * Method to make sure user meets all requirement for new account
     *
     * A valid email and password are required
     *  Email must be and @ohio.edu
     *  Password must be at least 6 char
     *
     */
    private void registerUser(){
        String username = editTextUsername.getText().toString().trim();
        String password = editTextPassword.getText().toString().trim();
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
        if(!username.contains("ohio.edu")){
            editTextPassword.setError("Needs to be an ohio.edu email address");
            editTextPassword.requestFocus();
            return;
        }

        mAuth.createUserWithEmailAndPassword(username,password).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
            @Override
            public void onComplete(@NonNull Task<AuthResult> task) {
                if(task.isSuccessful()){
                    Toast.makeText(getApplicationContext(), "User was registered",Toast.LENGTH_SHORT).show();

                }
            }
        });
    }
    /**
    * Will create account when registerUser() finishes
    * */
    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.button7: //sign up button (good name)
                registerUser();
                break;
            case R.id.button9: //Login Button
                startActivity(new Intent(this, MainActivity.class));
                break;

        }
    }
}
