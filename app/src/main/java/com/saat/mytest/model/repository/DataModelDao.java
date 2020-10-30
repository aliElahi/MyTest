package com.saat.mytest.model.repository;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import com.saat.mytest.model.DataModel;

import java.util.List;

@Dao
public interface DataModelDao {

    @Insert
    long insert(DataModel model);

    @Update
    int update(DataModel model);

    @Delete
    void delete(DataModel model);

    @Query("DELETE FROM DataModel")
    void deleteAll();

    @Query("SELECT * FROM DataModel")
    LiveData<List<DataModel>> getAllDataModelLiveData();


}
