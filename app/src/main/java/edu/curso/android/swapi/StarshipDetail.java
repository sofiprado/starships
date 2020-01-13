package edu.curso.android.swapi;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

public class StarshipDetail extends AppCompatActivity {

    TextView textViewNameDetail;
    TextView textViewModelDetail;
    TextView textViewCrewDetail;
    TextView textViewManufacturer;
    TextView textViewCost;
    TextView textViewLength;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_starship_detail);

        Bundle extras = getIntent().getExtras();


        String name = extras.getString("name");
        String model = extras.getString("model");
        String crew = extras.getString("crew");
        String manufacturer = extras.getString("manufacturer");
        String cost_in_credits = extras.getString("cost_in_credits");
        String length= extras.getString("length");


        textViewNameDetail = findViewById(R.id.textViewNameDetail);
        textViewNameDetail.setText(name.toUpperCase());

        textViewModelDetail = findViewById(R.id.textViewModelDetail);
        textViewModelDetail.setText("Modelo: " + model);

        textViewCrewDetail = findViewById(R.id.textViewCrewDetail);
        textViewCrewDetail.setText("Tripulación: " + crew);

        textViewManufacturer = findViewById(R.id.textViewManufacturer);
        textViewManufacturer.setText("Fabricante " + manufacturer);

        textViewCost = findViewById(R.id.textViewCost);
        textViewCost.setText("Créditos: " + cost_in_credits);

        textViewLength = findViewById(R.id.textViewLength);
        textViewLength.setText("Largo: " + length);
    }
}



