package com.emrekilic.whowantstobeamillionaire;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface DataAPI {
    @GET("questions")
    Call<List<DataMain>> getQuestion(@Query("limit") int limit, @Query("difficulty") String difficulty, @Query("apiKey") String apiKey);





}
