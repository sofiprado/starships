package edu.curso.android.swapi;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

import edu.curso.android.swapi.rest.Starship;

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

        Starship starship = getIntent().getExtras().getParcelable("starshipDetail");

        textViewNameDetail = findViewById(R.id.textViewNameDetail);
        textViewNameDetail.setText(starship.getName().toUpperCase());

        textViewModelDetail = findViewById(R.id.textViewModelDetail);
        textViewModelDetail.setText("Modelo: " + starship.getModel());

        textViewCrewDetail = findViewById(R.id.textViewCrewDetail);
        textViewCrewDetail.setText("Tripulación: " + starship.getCrew());

        textViewManufacturer = findViewById(R.id.textViewManufacturer);
        textViewManufacturer.setText("Fabricante " + starship.getManufacturer());

        textViewCost = findViewById(R.id.textViewCost);
        textViewCost.setText("Créditos: " + starship.getCost());

        textViewLength = findViewById(R.id.textViewLength);
        textViewLength.setText("Largo: " + starship.getLength());
    }
}



