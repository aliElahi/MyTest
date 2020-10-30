package com.saat.mytest.model.repository.worker;

import android.content.Context;

import androidx.annotation.NonNull;
import androidx.work.Worker;
import androidx.work.WorkerParameters;

public class DeleteDataModelWorker extends Worker {

    public static final String DATA_MODEL_ID = "id";

    public DeleteDataModelWorker(@NonNull Context context, @NonNull WorkerParameters workerParams) {
        super(context, workerParams);
    }

    @NonNull
    @Override
    public Result doWork() {
        return null;
    }
}
