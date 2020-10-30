package com.saat.mytest.view;

import android.app.AlertDialog;
import android.app.Dialog;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.DialogFragment;

import com.google.android.material.dialog.MaterialAlertDialogBuilder;
import com.saat.mytest.model.DataModel;

public class CustomDialog extends DialogFragment {
    private DataModel dataModel;

    public CustomDialog(DataModel model) {
        this.dataModel = model;
    }

    @NonNull
    @Override
    public Dialog onCreateDialog(@Nullable Bundle savedInstanceState) {

        MaterialAlertDialogBuilder builder = new MaterialAlertDialogBuilder(requireContext());
        builder.setTitle("Title");
        builder.setMessage(dataModel.toString());
        builder.setPositiveButton("Ok",(dialogInterface, i) -> dialogInterface.dismiss());
        return builder.create();
    }
}
