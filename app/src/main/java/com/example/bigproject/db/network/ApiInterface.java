package com.example.bigproject.db.network;

import com.example.bigproject.db.database.User;

import io.reactivex.Observable;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface ApiInterface {

    //Get bang RxAndroid
    @GET("top-headlines")
    Observable<User> getCountry2(
            @Query("country") String country,
            @Query("apiKey") String apiKey
    );
    @GET("everything")
    Observable<User> getQ2(
            @Query("q") String q,
            @Query("language") String language,
            @Query("sortBy") String sortBy,
            @Query("apiKey") String apiKey
    );
}
