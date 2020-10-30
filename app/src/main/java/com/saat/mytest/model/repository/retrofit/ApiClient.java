package com.saat.mytest.model.repository.retrofit;


import com.saat.mytest.model.DataModel;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Headers;
import retrofit2.http.Path;

public interface ApiClient {

    @GET("svc/books/v3/lists/{date}/{list}")
    @Headers({ "Content-Type: application/json;charset=UTF-8"})
    Call<DataModel> get(@Path("date") String date , @Path("list") String list);
}
