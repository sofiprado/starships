package edu.curso.android.swapi.rest;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.SerializedName;

public class Starship implements Parcelable {


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

    protected Starship(Parcel in) {
        name =in.readString();
        model = in.readString();
        crew = in.readString();
        manufacturer = in.readString();
        cost = in.readString();
        length = in.readString();

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

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(name);
        dest.writeString(model);
        dest.writeString(crew);
        dest.writeString(manufacturer);
        dest.writeString(cost);
        dest.writeString(length);
    }

    public static final Creator<Starship> CREATOR = new Creator<Starship>() {
        @Override
        public Starship createFromParcel(Parcel in) {
            return new Starship(in);
        }

        @Override
        public Starship[] newArray(int size) {
            return new Starship[size];
        }
    };
}

