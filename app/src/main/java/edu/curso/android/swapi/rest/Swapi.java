package edu.curso.android.swapi.rest;

import edu.curso.android.swapi.MainActivity;
import retrofit2.Call;
import retrofit2.http.GET;

public interface Swapi {

    @GET("starships/")
    Call<StarshipsResponse> getStarships();
}
