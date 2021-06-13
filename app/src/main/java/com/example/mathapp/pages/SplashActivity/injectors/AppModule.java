package com.example.mathapp.pages.SplashActivity.injectors;

import com.example.mathapp.pages.SplashActivity.Dagger2Application;
import com.example.mathapp.pages.SplashActivity.SplashActivity;
import com.example.mathapp.pages.SplashActivity.model.ICar;
import com.example.mathapp.pages.SplashActivity.model.IEngine;
import com.example.mathapp.pages.SplashActivity.model.car.BMWCar;
import com.example.mathapp.pages.SplashActivity.model.engine.LPGEngine;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

@Module
public class AppModule {

    private final Dagger2Application dagger2Application;

    public AppModule(Dagger2Application dagger2Application) {
        this.dagger2Application = dagger2Application;
    }

    @Provides @Singleton
    Dagger2Application provideApp(){
        return dagger2Application;
    }

    @Provides @Singleton
    IEngine provideEngine(){
        return new LPGEngine();
    }

    @Provides @Singleton
    ICar provideCar(IEngine engine){
        return new BMWCar(engine);
    }
}