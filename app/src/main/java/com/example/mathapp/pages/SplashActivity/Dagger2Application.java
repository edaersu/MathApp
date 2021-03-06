package com.example.mathapp.pages.SplashActivity;

import android.app.Application;

import com.example.mathapp.pages.SplashActivity.injectors.AppComponent;

import com.example.mathapp.pages.SplashActivity.injectors.AppComponent;
import com.example.mathapp.pages.SplashActivity.injectors.AppModule;
import com.example.mathapp.pages.SplashActivity.injectors.DaggerAppComponent;

public class Dagger2Application extends Application {

    private AppComponent appComponent;

    @Override
    public void onCreate() {
        super.onCreate();
        initializeInjector();

    }

    private void initializeInjector(){
        appComponent = DaggerAppComponent.builder()
                .appModule(new AppModule(this))
                .build();
    }

    public AppComponent getAppComponent(){
        return appComponent;
    }
}