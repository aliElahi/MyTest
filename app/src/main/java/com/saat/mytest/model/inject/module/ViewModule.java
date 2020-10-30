package com.saat.mytest.model.inject.module;

import android.app.Application;
import android.content.Context;

import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.saat.mytest.view.CustomAdapter;

import java.util.ArrayList;

import dagger.Module;
import dagger.Provides;

@Module(includes = ApplicationModule.class)
public class ViewModule {


    @Provides
    public CustomAdapter provideCustomAdapter(){
        return new CustomAdapter(new ArrayList<>());
    }

    @Provides
    public RecyclerView.LayoutManager provideLayoutManager(Application application){
        return new LinearLayoutManager(application);
    }
}
