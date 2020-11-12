package com.example.bigproject.ui.main;

import android.app.Dialog;
import android.os.Bundle;
import android.view.Window;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.ListAdapter;
import androidx.recyclerview.widget.RecyclerView;

import com.example.bigproject.R;
import com.example.bigproject.db.database.User;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class MainActivity extends AppCompatActivity {
    RecyclerView recyclerView;
    List<User> userList;
    MainAdapter mainAdapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().requestFeature(Window.FEATURE_ACTION_BAR);
        Objects.requireNonNull(getSupportActionBar()).hide();
        setContentView(R.layout.activity_main);
        database();
        //gán Id cho recyclerview
        recyclerView = findViewById(R.id.recyclerView);
        //Tối ưu hoá dữ liệu trong adapter
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new GridLayoutManager(this, 2));
        //gán dữ liệu cho contactAdapter
        mainAdapter = new MainAdapter(userList, this);
        //set Adapter cho Recycler View
        recyclerView.setAdapter(mainAdapter);
        mainAdapter.notifyDataSetChanged();
    }

    private void database(){
        userList = new ArrayList<>();
        User user = new User("01","name 1", "https://i.pinimg.com/236x/9b/f0/9c/9bf09c596a26e92400d24aba35bbbcb5--detective-conan.jpg", "createAt");
        userList.add(user);
        user = new User("02","name 2", "https://i.pinimg.com/236x/1f/a4/2e/1fa42e08f7fb44d97b07cfebaf0894c4.jpg", "createAt");
        userList.add(user);
        user = new User("03","name 3", "https://images6.fanpop.com/image/photos/39800000/Conan-conan-edogawa-39864107-300-460.jpg", "createAt");
        userList.add(user);
        user = new User("04","name 4", "avatar", "createAt");
        userList.add(user);
    }
}