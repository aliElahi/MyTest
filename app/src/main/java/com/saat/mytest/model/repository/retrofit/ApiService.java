package com.saat.mytest.model.repository.retrofit;

import com.saat.mytest.model.DataModel;

import retrofit2.Call;

public class ApiService {

    ApiClient apiClient;

    public ApiService(ApiClient apiClient) {
        this.apiClient = apiClient;
    }

    public Call<DataModel> get(String date , String list){
        return apiClient.get(date,list);
    }
}
