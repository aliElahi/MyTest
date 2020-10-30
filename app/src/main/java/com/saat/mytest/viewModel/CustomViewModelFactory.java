package com.saat.mytest.viewModel;

import androidx.annotation.NonNull;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;

import com.saat.mytest.model.repository.Repository;

public class CustomViewModelFactory implements ViewModelProvider.Factory {

    private final Repository repository;

    public CustomViewModelFactory(Repository repository) {
        this.repository = repository;
    }

    @NonNull
    @Override
    public <T extends ViewModel> T create(@NonNull Class<T> aClass) {
        if(aClass.isAssignableFrom(MainActivityViewModel.class))
            return (T) new MainActivityViewModel(repository);
        else{
            throw new IllegalArgumentException("this type view model not supported in CustomViewModelFactory");
        }
    }
}
