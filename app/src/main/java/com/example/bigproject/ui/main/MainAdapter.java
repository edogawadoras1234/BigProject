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
import com.example.bigproject.db.database.User;
import com.example.bigproject.ui.details.DetailsActivity;

import java.util.List;

public class MainAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder>{
    List<User> userList;
    Context context;
    public MainAdapter(List<User> userList, Context context) {
        this.userList = userList;
        this.context = context;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new ViewHolder(LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_recycler_view, parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        if(holder instanceof ViewHolder) {
            final ViewHolder contactViewHolder = (ViewHolder) holder;
            contactViewHolder.name.setText(userList.get(position).getName());
            contactViewHolder.date.setText(userList.get(position).getCreateAt());

            final String avatar = userList.get(position).getAvatar();
            Glide.with(context.getApplicationContext()).load(avatar)
                    .placeholder(R.drawable.logo).into(contactViewHolder.imageView);

            holder.itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent intent = new Intent(context, DetailsActivity.class);
                    context.startActivity(intent);
                }
            });
        }
    }

    @Override
    public int getItemCount() {
        return userList.size();
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
