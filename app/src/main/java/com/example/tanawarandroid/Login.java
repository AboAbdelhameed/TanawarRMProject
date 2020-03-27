package com.example.tanawarandroid;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

import interfaces.InitializeComponents;

public class Login extends AppCompatActivity implements InitializeComponents {
    private Button btnRegister;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.login);
        initializeActivityComponents();
        initializeComponentsListeners();
    }

    private void startRegisterActivity() {
        Intent i = new Intent(this, Register.class);
        startActivity(i);
    }


    @Override
    public void initializeComponentsListeners() {
        this.btnRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startRegisterActivity();
            }
        });
    }

    @Override
    public void initializeActivityComponents() {
        this.btnRegister = findViewById(R.id.btnRegister);
    }
}
