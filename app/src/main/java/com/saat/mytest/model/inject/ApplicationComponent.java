package com.saat.mytest.model.inject;

import android.app.Application;

import com.saat.mytest.model.inject.module.ApplicationModule;
import com.saat.mytest.model.inject.module.RoomModule;
import com.saat.mytest.model.inject.module.ViewModule;
import com.saat.mytest.view.MainActivity;

import javax.inject.Singleton;

import dagger.Component;

@Singleton
@Component(modules = {ApplicationModule.class, RoomModule.class ,ViewModule.class})
public interface ApplicationComponent
{

    void inject(MainActivity mainActivity);

    Application application();

}
