package com.saat.mytest.view;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.View;

import com.saat.mytest.App;
import com.saat.mytest.databinding.ActivityMainBinding;
import com.saat.mytest.model.DataModel;
import com.saat.mytest.viewModel.MainActivityViewModel;

import javax.inject.Inject;

public class MainActivity extends AppCompatActivity
        implements View.OnClickListener, CustomAdapter.OnItemClickListener {

    private MainActivityViewModel viewModel;
    private ActivityMainBinding binding;

    @Inject
    public CustomAdapter adapter;
    @Inject
    public RecyclerView.LayoutManager layoutManager;

    @Inject
     ViewModelProvider.Factory factory;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ((App)getApplication())
                .getApplicationComponent()
                .inject(this);

        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());


        viewModel = factory.create(MainActivityViewModel.class);

        binding.buttonRefresh.setOnClickListener(this);

        binding.recyclerView.setLayoutManager(layoutManager);
        adapter.setItemListener(this);
        binding.recyclerView.setAdapter(adapter);

        viewModel.getLiveData()
                .observe(this,dataModels -> {
                    adapter.changeList(dataModels);
                });

    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        binding = null;
    }

    @Override
    public void onClick(View view) {
        if(view == binding.buttonRefresh)
            viewModel.refresh();
        else if (view == binding.buttonDelete)
            viewModel.deleteAll();
    }

    @Override
    public void onClick(DataModel model) {

        CustomDialog dialog = new CustomDialog(model);
        dialog.show(getSupportFragmentManager(),"custom dialog");
    }
}