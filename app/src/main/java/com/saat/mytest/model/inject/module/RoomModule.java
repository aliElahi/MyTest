package com.saat.mytest.model.inject.module;

import android.app.Application;

import androidx.lifecycle.ViewModelProvider;

import com.saat.mytest.model.repository.DataModelDao;
import com.saat.mytest.model.repository.Database;
import com.saat.mytest.model.repository.Repository;
import com.saat.mytest.model.repository.retrofit.ApiClient;
import com.saat.mytest.model.repository.retrofit.ApiService;
import com.saat.mytest.viewModel.CustomViewModelFactory;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

@Module(includes = RetrofitModule.class)
public class RoomModule {

    private final Database database;


    public RoomModule(Application application) {
        this.database = Database.getDatabase(application);
    }

    @Singleton
    @Provides
    public Repository providesRepository(DataModelDao dao , ApiService service){
        return new Repository(dao,service);
    }

    @Singleton
    @Provides
    public DataModelDao providesModelDao(Database database){
        return database.getDataModelDao();
    }

    @Singleton
    @Provides
    public Database providesDatabase(Application application){
        return database;
    }

    @Singleton
    @Provides
    public ViewModelProvider.Factory provideViewModelFactory(Repository repository){
        return new CustomViewModelFactory(repository);
    }
}
