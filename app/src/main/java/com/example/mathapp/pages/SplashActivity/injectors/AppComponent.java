package com.example.mathapp.pages.SplashActivity.injectors;

import com.example.mathapp.pages.SplashActivity.SplashActivity;

import javax.inject.Singleton;

import dagger.Component;

@Singleton
@Component(modules = AppModule.class)
public interface AppComponent {
    void inject(SplashActivity carActivity);
}