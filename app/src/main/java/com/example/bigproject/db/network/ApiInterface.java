package com.example.bigproject.db.network;

import com.example.bigproject.db.database.ImageDetailData;
import com.example.bigproject.db.database.ImageTotalData;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface ApiInterface {

    //Get bang RxAndroid
    @GET("seaG")
    Call<List<ImageDetailData>> getImage();
    @GET("seaG/2/pic")
    Call<List<ImageTotalData>> getTotalImage();
}
