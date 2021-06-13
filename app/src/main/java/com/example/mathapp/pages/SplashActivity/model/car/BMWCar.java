package com.example.mathapp.pages.SplashActivity.model.car;

import android.util.Log;

import com.bumptech.glide.load.engine.Engine;
import com.example.mathapp.pages.SplashActivity.model.ICar;
import com.example.mathapp.pages.SplashActivity.model.IEngine;

import javax.inject.Inject;

public class BMWCar implements ICar {
    IEngine engine;

    @Inject
    public BMWCar(IEngine engine) {
        this.engine = engine;
    }

    @Override
    public void start() {
        Log.v("DaggerExample","BMW Car is about to start.");
        engine.turnOn();
    }

    @Override
    public void stop() {
        Log.v("DaggerExample","BMW Car is about to stop.");
        engine.turnOff();
    }
}
