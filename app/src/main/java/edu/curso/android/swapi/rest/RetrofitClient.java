package edu.curso.android.swapi.rest;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class RetrofitClient {
    private static Retrofit retrofit;
    private static final String URL_BASE = "https://swapi.co/api/";

    public static Retrofit getRetrofit() {
        if(retrofit==null) {
            retrofit = new retrofit2.Retrofit.Builder()
                    .baseUrl(URL_BASE)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();
        }
        return retrofit;
    }
}
