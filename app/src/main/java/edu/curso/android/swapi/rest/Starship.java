package edu.curso.android.swapi.rest;

import com.google.gson.annotations.SerializedName;

public class Starship {


        @SerializedName("name")
        private String name;
        @SerializedName("model")
        private String model;
        @SerializedName ("crew")
        private String crew;
        @SerializedName("manufacturer")
        private String manufacturer;
        @SerializedName("cost_in_credits")
        private String cost;
        @SerializedName("length")
        private String length;

    public Starship() { }

    public Starship(String name, String model, String crew,String manufacturer, String cost, String length) {
        this.name = name;
        this.model = model;
        this.crew = crew;
        this.manufacturer = manufacturer ;
        this.cost = cost;
        this.length = length;
    }

        public String getName() {
            return name;
        }
        public String getModel() {
            return model;
        }
        public String getCrew() {
            return crew;
        }
        public String getManufacturer() { return manufacturer; }
        public String getCost() { return cost; }
        public String getLength() { return length; }
    }

