package com.saat.mytest.model.repository;

import android.content.Context;

import androidx.room.Room;
import androidx.room.RoomDatabase;
import androidx.room.TypeConverters;

import com.saat.mytest.model.DataModel;

@androidx.room.Database(entities = DataModel.class, version = 1 , exportSchema = false)
@TypeConverters({DatabaseTypeConverter.class})
public abstract class Database extends RoomDatabase {

    private static volatile Database INSTANCE;

    public abstract DataModelDao getDataModelDao();

    public static synchronized Database getDatabase(Context context) {


        if (INSTANCE == null) {
            INSTANCE = Room
                    .databaseBuilder(context.getApplicationContext(), Database.class, "database")
                    .build();
        }

        return INSTANCE;

    }
}
