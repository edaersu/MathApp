package com.example.mathapp.pages.SplashActivity;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.example.mathapp.R;

public class SplashActivity extends AppCompatActivity implements  SplashActivityContract.View{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);


    }


}