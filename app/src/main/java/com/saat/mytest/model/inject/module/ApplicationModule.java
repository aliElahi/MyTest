package com.saat.mytest.model.inject.module;

import android.app.Application;

import com.saat.mytest.App;

import dagger.Module;
import dagger.Provides;

@Module
public class ApplicationModule {

    private final Application application;


    public ApplicationModule(App app) {
        this.application = app;
    }

    @Provides
    public Application getApplication(){
        return application;
    }
}
