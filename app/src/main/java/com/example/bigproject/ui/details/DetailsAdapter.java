package com.example.bigproject.ui.details;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.bigproject.R;
import com.example.bigproject.db.database.ImageDetailData;

import java.util.List;

public class DetailsAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    List<ImageDetailData> imageDetailData;
    Context context;

    public DetailsAdapter(List<ImageDetailData> imageDetailData, Context context) {
        this.imageDetailData = imageDetailData;
        this.context = context;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new ViewHolder(LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_details, parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        if (holder instanceof DetailsAdapter.ViewHolder) {
            final DetailsAdapter.ViewHolder viewHolder = (DetailsAdapter.ViewHolder) holder;
            final String avatar = imageDetailData.get(position).getAvatar();
            final String id = imageDetailData.get(position).getId();
            String date = imageDetailData.get(position).getDate();
            Log.i("DetailsAdapter", " " + imageDetailData.size() + id);
            Glide.with(context.getApplicationContext()).load(avatar)
                    .placeholder(R.drawable.logo).into(viewHolder.imageView);
        }
    }

    @Override
    public int getItemCount() {
        return imageDetailData.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        ImageView imageView;

        public ViewHolder(View itemView) {
            super(itemView);
            imageView = itemView.findViewById(R.id.image_details);
        }

    }
}
