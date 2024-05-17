package com.emrekilic.whowantstobeamillionaire;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public final class Config {

    //değişmesini hiç istemediğimiz yerlerde.

    public static String API_KEY="hOhBL8UpJrMD9biXmvDhf1tOzmdbsUUFOO8TnX9O";

    private static Retrofit retrofit;



    //new lemeyi engelliyor.
    private Config (){

    }



    public static Retrofit getRetrofit() {
        if (retrofit==null){
            retrofit=new Retrofit.Builder().baseUrl("https://quizapi.io/api/v1/").addConverterFactory(GsonConverterFactory.create()).build();
        }

        return retrofit;
    }
}
