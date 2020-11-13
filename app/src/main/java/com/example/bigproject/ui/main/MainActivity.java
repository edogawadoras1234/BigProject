package com.example.bigproject.ui.main;

import android.os.Bundle;
import android.util.Log;
import android.view.Window;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.bigproject.R;
import com.example.bigproject.db.database.ImageDetailData;
import com.example.bigproject.db.database.ImageTotalData;
import com.example.bigproject.db.network.ApiClient;
import com.example.bigproject.db.network.ApiInterface;
import com.example.bigproject.ui.details.DetailsActivity;
import com.example.bigproject.ui.details.DetailsAdapter;

import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;


public class MainActivity extends AppCompatActivity {
    String TAG = "Main Activity";
    RecyclerView recyclerView;
    List<ImageTotalData> imageTotalData;
    MainAdapter mainAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().requestFeature(Window.FEATURE_ACTION_BAR);
        Objects.requireNonNull(getSupportActionBar()).hide();
        setContentView(R.layout.activity_main);
        onLoadData();
        recyclerView = findViewById(R.id.recyclerView);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new GridLayoutManager(this, 2));
        Log.i(TAG, "onCreate");
    }

    public void onLoadData() {
        imageTotalData = new ArrayList<>();
        Retrofit retrofit = ApiClient.getApiClient();
        ApiInterface callApi = retrofit.create(ApiInterface.class);
        Call<List<ImageTotalData>> call = callApi.getTotalImage();
        call.enqueue(new Callback<List<ImageTotalData>>() {
            @Override
            public void onResponse(@NotNull Call<List<ImageTotalData>> call, @NotNull Response<List<ImageTotalData>> response) {
                List<ImageTotalData> imageTotalDataList = response.body();
                String id, seaGid, picture;
                int number_picture;
                for (int i = 0; i < imageTotalDataList.size(); i++) {
                    id = imageTotalDataList.get(i).getId();
                    seaGid = imageTotalDataList.get(i).getSeaGId();
                    picture = imageTotalDataList.get(i).getPicture();
                    number_picture = imageTotalDataList.get(i).getNumber_picture();
                    ImageTotalData imageTotalData = new ImageTotalData(id, seaGid,picture,number_picture);
                    MainActivity.this.imageTotalData.add(imageTotalData);
                    Log.i(TAG,"" + imageTotalDataList.toString() + number_picture);
                }
                mainAdapter = new MainAdapter(MainActivity.this.imageTotalData, getBaseContext());
                recyclerView.setAdapter(mainAdapter);
                mainAdapter.notifyDataSetChanged();
            }

            @Override
            public void onFailure(Call<List<ImageTotalData>> call, Throwable t) {
                Log.i(TAG, "onFailure" + t.toString());
            }
        });
    }
}