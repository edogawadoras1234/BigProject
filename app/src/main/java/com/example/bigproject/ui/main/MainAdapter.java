package com.example.bigproject.ui.main;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.bigproject.R;
import com.example.bigproject.db.database.ImageDetailData;
import com.example.bigproject.db.database.ImageTotalData;
import com.example.bigproject.ui.details.DetailsActivity;

import java.util.List;

public class MainAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder>{
    List<ImageTotalData> imageTotalData;
    Context context;
    public MainAdapter(List<ImageTotalData> imageTotalData, Context context) {
        this.imageTotalData = imageTotalData;
        this.context = context;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new ViewHolder(LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_main, parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        if(holder instanceof ViewHolder) {
            final ViewHolder contactViewHolder = (ViewHolder) holder;
            contactViewHolder.name.setText(imageTotalData.get(position).getSeaGId());

            final String avatar = imageTotalData.get(position).getPicture();
            Glide.with(context.getApplicationContext()).load(avatar)
                    .placeholder(R.drawable.logo).into(contactViewHolder.imageView);

            holder.itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent intent = new Intent(context, DetailsActivity.class);
                    intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                    context.startActivity(intent);
                }
            });
        }
    }

    @Override
    public int getItemCount() {
        return imageTotalData.size();
    }
    public class ViewHolder extends RecyclerView.ViewHolder {

        private TextView name;
        private TextView date;
        ImageView imageView;

        public ViewHolder(View itemView) {
            super(itemView);
            name = itemView.findViewById(R.id.text_name);
            date = itemView.findViewById(R.id.text_date);
            imageView = itemView.findViewById(R.id.image_main);
        }

    }
}
