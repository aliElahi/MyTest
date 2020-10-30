package com.saat.mytest;

import android.app.Application;
import android.text.PrecomputedText;

import com.saat.mytest.model.inject.ApplicationComponent;
import com.saat.mytest.model.inject.DaggerApplicationComponent;
import com.saat.mytest.model.inject.module.ApplicationModule;
import com.saat.mytest.model.inject.module.ContextModule;
import com.saat.mytest.model.inject.module.RetrofitModule;
import com.saat.mytest.model.inject.module.RoomModule;
import com.saat.mytest.model.inject.module.ViewModule;

public class App extends Application {

    private ApplicationComponent applicationComponent;

    @Override
    public void onCreate() {
        super.onCreate();

        applicationComponent = DaggerApplicationComponent
                .builder()
                .applicationModule(new ApplicationModule(this))
                .roomModule(new RoomModule(this))
                .viewModule(new ViewModule())
                .retrofitModule(new RetrofitModule())
                .build();


    }

    public ApplicationComponent getApplicationComponent(){
        return applicationComponent;
    }
}
