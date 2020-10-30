package com.saat.mytest.view;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.saat.mytest.databinding.SingleListItemBinding;
import com.saat.mytest.model.DataModel;

import java.util.List;

public class CustomAdapter extends RecyclerView.Adapter<CustomAdapter.ViewHolder> {


    private OnItemClickListener listener;
    private List<DataModel> list;

    public CustomAdapter(List<DataModel> list) {
        this.list = list;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        LayoutInflater inflater = LayoutInflater.from(viewGroup.getContext());
        SingleListItemBinding binding = SingleListItemBinding.inflate(inflater,viewGroup,false);
        return new ViewHolder(binding.getRoot(),binding);
        //return null;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder viewHolder, int i) {
        viewHolder.onBind(list.get(viewHolder.getAdapterPosition()),listener);
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public void setItemListener(OnItemClickListener listener){
        this.listener = listener;
    }

    public void changeList(List<DataModel> dataModels){
        list = dataModels;
        notifyDataSetChanged();
    }

    static class ViewHolder extends RecyclerView.ViewHolder {

        SingleListItemBinding binding;
        OnItemClickListener listener;

        public ViewHolder(@NonNull View itemView , SingleListItemBinding binding) {
            super(itemView);
            this.binding = binding;
        }

        void onBind(DataModel model , OnItemClickListener listener){
            binding.id.setText(String.valueOf(model.getId()));
            binding.text.setText(model.toString());
            this.listener = listener;

            binding.getRoot()
                    .setOnClickListener(view -> {
                        if(listener != null){
                            listener.onClick(model);
                        }
                    });
        }
    }

    public interface OnItemClickListener{
        void onClick(DataModel model);
    }
}
