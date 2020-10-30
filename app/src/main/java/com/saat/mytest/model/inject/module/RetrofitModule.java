package com.saat.mytest.model.inject.module;


import com.saat.mytest.model.repository.retrofit.ApiClient;
import com.saat.mytest.model.repository.retrofit.ApiService;

import dagger.Module;
import dagger.Provides;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

@Module
public class RetrofitModule {

    private static String baseUrl = "https://api.nytimes.com/";

    @Provides
    public Retrofit  provideRetrofit(){
        return new Retrofit.Builder()
                .baseUrl(baseUrl)
                .addConverterFactory(GsonConverterFactory.create())
                .build();
    }


    @Provides
    public ApiService provideApiService(Retrofit retrofit){
        return new ApiService(retrofit.create(ApiClient.class));
    }
}
