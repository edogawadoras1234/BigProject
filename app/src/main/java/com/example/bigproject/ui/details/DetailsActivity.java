package com.example.bigproject.ui.details;

import android.os.Bundle;
import android.util.Log;
import android.view.Window;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.bigproject.R;
import com.example.bigproject.db.database.ImageDetailData;
import com.example.bigproject.db.database.ImageTotalData;
import com.example.bigproject.db.network.ApiClient;
import com.example.bigproject.db.network.ApiInterface;
import com.example.bigproject.ui.main.MainActivity;
import com.example.bigproject.ui.main.MainAdapter;

import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;

public class DetailsActivity extends AppCompatActivity {
    String TAG = "Details Activity";
    RecyclerView recyclerView;
    List<ImageDetailData> imageDetailData;
    DetailsAdapter detailsAdapter;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().requestFeature(Window.FEATURE_ACTION_BAR);
        Objects.requireNonNull(getSupportActionBar()).hide();
        setContentView(R.layout.activity_details);
        onLoadData();
        recyclerView = findViewById(R.id.rvDetails);
        recyclerView.setHasFixedSize(true);
        LinearLayoutManager layoutManager = new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false);
        recyclerView.setLayoutManager(layoutManager);
    }
    public void onLoadData() {
        imageDetailData = new ArrayList<>();
        Retrofit retrofit = ApiClient.getApiClient();
        ApiInterface callApi = retrofit.create(ApiInterface.class);
        Call<List<ImageDetailData>> call = callApi.getImage();
        call.enqueue(new Callback<List<ImageDetailData>>() {
            @Override
            public void onResponse(@NotNull Call<List<ImageDetailData>> listCall, @NotNull Response<List<ImageDetailData>> response) {
                List<ImageDetailData> imageDetailDataList = response.body();
                String id, name, date, avatar;
                Log.i(TAG, "onRespone" + response.body().size() + imageDetailDataList.size());
                Log.i(TAG, "onRespone2" + imageDetailDataList.get(1).getDate());
                for (int i = 0; i < imageDetailDataList.size(); i++) {
                    id = imageDetailDataList.get(i).getId();
                    name = imageDetailDataList.get(i).getName();
                    date = imageDetailDataList.get(i).getDate();
                    avatar = imageDetailDataList.get(i).getAvatar();
                    ImageDetailData imageDetailData = new ImageDetailData(id, name, date, avatar);
                    DetailsActivity.this.imageDetailData.add(imageDetailData);
                }
                detailsAdapter = new DetailsAdapter(DetailsActivity.this.imageDetailData, getApplicationContext());
                recyclerView.setAdapter(detailsAdapter);
                detailsAdapter.notifyDataSetChanged();
            }

            @Override
            public void onFailure(@NotNull Call<List<ImageDetailData>> listCall, @NotNull Throwable t) {
                Log.i(TAG, "onFailure" + t.toString());
            }
        });
    }
}
