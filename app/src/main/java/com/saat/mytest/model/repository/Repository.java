package com.saat.mytest.model.repository;

import android.os.AsyncTask;

import androidx.lifecycle.LiveData;
import com.saat.mytest.model.DataModel;
import com.saat.mytest.model.repository.retrofit.ApiService;

import java.io.IOException;
import java.lang.ref.WeakReference;
import java.util.List;

import javax.inject.Inject;

import okhttp3.HttpUrl;
import retrofit2.Response;

public class Repository {

    private DataModelDao dao;
    private ApiService service;

    @Inject
    public Repository(DataModelDao dao , ApiService service) {

        this.service = service;
        this.dao = dao;
    }

    public LiveData<List<DataModel>> getLiveData(){
        return dao.getAllDataModelLiveData();
    }
    

    public void delete(DataModel model){
        //dao.delete(model);
        DeleteAsyncTask task = new DeleteAsyncTask(this);
        task.execute(model);
    }

    public void deleteAll(){
        //dao.deleteAll();
        DeleteAllAsyncTask task = new DeleteAllAsyncTask(this);
        task.execute();
    }

    public void refresh(){
        RefreshAsyncTask task = new RefreshAsyncTask(service, dao);
        task.execute();
    }

    public static class RefreshAsyncTask extends AsyncTask<Void,Void,Void> {
        private WeakReference<ApiService> reference;
        private WeakReference<DataModelDao> dao;

        public RefreshAsyncTask(ApiService service , DataModelDao dao) {
            this.dao = new WeakReference<>(dao);
            this.reference = new WeakReference<>(service);
        }

        @Override
        protected Void doInBackground(Void... voids) {
            try {
                HttpUrl url =  reference.get()
                        .get("date","list")
                        .request()
                        .url();

                Response<DataModel> response = reference.get().get("date","list")
                        .execute();

                if(response.isSuccessful()){
                    dao.get()
                            .insert(response.body());
                }

            } catch (IOException e) {
                e.printStackTrace();
            }

            return null;
        }
    }

    public static class DeleteAsyncTask extends android.os.AsyncTask<DataModel,Void,Void>{

        WeakReference<Repository> reference;

        public DeleteAsyncTask(Repository repository) {
            this.reference = new WeakReference<>(repository);
        }

        @Override
        protected Void doInBackground(DataModel... dataModels) {

            try {
                if(reference.get() != null){
                    reference.get().delete(dataModels[0]);
                }
            } catch (Exception e) {
                e.printStackTrace();
            }

            return null;
        }
    }

    public static class DeleteAllAsyncTask extends AsyncTask<Void,Void,Void>{

        private WeakReference<Repository> reference;

        public DeleteAllAsyncTask(Repository repository) {
            reference = new WeakReference<>(repository);
        }

        @Override
        protected Void doInBackground(Void... voids) {
            try {
                if(reference.get() != null){
                    reference.get().deleteAll();
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
            return null;
        }
    }
}
