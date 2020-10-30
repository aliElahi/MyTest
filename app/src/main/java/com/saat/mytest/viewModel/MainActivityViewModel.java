package com.saat.mytest.viewModel;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.ViewModel;

import com.saat.mytest.model.DataModel;
import com.saat.mytest.model.repository.Repository;

import java.util.List;

import javax.inject.Inject;

public class MainActivityViewModel extends ViewModel {

    private Repository repository;

    @Inject
    public MainActivityViewModel(Repository repository) {
        this.repository = repository;
    }

    public LiveData<List<DataModel>> getLiveData(){
        return repository.getLiveData();
    }

    public void delete(DataModel model){
        repository.delete(model);
    }
    
    public void deleteAll(){
        repository.deleteAll();
    }

    public void refresh(){
        repository.refresh();
    }

}
