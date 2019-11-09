package com.example.myapplication;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Patterns;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCanceledListener;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class CreateAccount extends AppCompatActivity implements View.OnClickListener {

    EditText editTextUsername, editTextPassword;
    private FirebaseAuth mAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create_account);
        editTextUsername = findViewById(R.id.editText4);
        editTextPassword = findViewById(R.id.editText);
        mAuth = FirebaseAuth.getInstance();
        findViewById(R.id.button7).setOnClickListener(this);


    }

    private void registerUser(){
        String username = editTextUsername.getText().toString().trim();
        String password = editTextPassword.getText().toString().trim();
        if(username.isEmpty()){
            editTextUsername.setError("Email is required");
            editTextUsername.requestFocus();
            return;
        }
        if(password.isEmpty()){
            editTextPassword.setError("password is required");
            editTextPassword.requestFocus();
            return;

        }
        if(!Patterns.EMAIL_ADDRESS.matcher(username).matches()){//if email is legit
            editTextUsername.setError("enter a real email");
            editTextUsername.requestFocus();
            return;
        }
        if(password.length()<6){
            editTextPassword.setError("password needs to be greater than 6");
            editTextPassword.requestFocus();
            return;
        }
        if(!username.contains("ohio.edu")){
            editTextPassword.setError("needs to be an ohio.edu email");
            editTextPassword.requestFocus();
            return;
        }

        mAuth.createUserWithEmailAndPassword(username,password).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
            @Override
            public void onComplete(@NonNull Task<AuthResult> task) {
                if(task.isSuccessful()){
                    Toast.makeText(getApplicationContext(), "User was registerd",Toast.LENGTH_SHORT).show();

                }
            }
        });
    }

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
