package com.example.mathapp.pages.SplashActivity.model.engine;

import android.util.Log;

import com.example.mathapp.pages.SplashActivity.model.IEngine;

public class LPGEngine implements IEngine {

    @Override
    public void turnOn() {
        Log.v("DaggerExample", "LPG Engine turned on");
    }

    @Override
    public void turnOff() {
        Log.v("DaggerExample", "LPG Engine turned off.");
    }
}
