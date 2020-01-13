package edu.curso.android.swapi.rest;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class StarshipsResponse {


        @SerializedName("results")
        private List<Starship> result;

        public List<Starship> getResult() {
            return result;
        }

}

