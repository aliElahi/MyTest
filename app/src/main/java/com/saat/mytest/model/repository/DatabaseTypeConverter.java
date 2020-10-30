package com.saat.mytest.model.repository;

import androidx.room.TypeConverter;

import com.google.gson.Gson;
import com.saat.mytest.model.DataModel;

public class DatabaseTypeConverter {

    @TypeConverter
    public static DataModel.FaultBean fromJsonString(String value){
        Gson gson = new Gson();
        return gson.fromJson(value, DataModel.FaultBean.class);
    }

    @TypeConverter
    public static String toJsonString(DataModel.FaultBean bean){
        Gson gson = new Gson();
        return gson.toJson(bean);
    }
}
