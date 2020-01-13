package edu.curso.android.swapi;

import android.content.Intent;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

import edu.curso.android.swapi.rest.RetrofitClient;
import edu.curso.android.swapi.rest.Starship;
import edu.curso.android.swapi.rest.StarshipsResponse;
import edu.curso.android.swapi.rest.Swapi;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;


public class MainActivity extends AppCompatActivity implements SwapiRecyclerAdapter.StarshipClickListener {

    private RecyclerView recyclerView;
    private List<Starship> starshipList;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recyclerView = findViewById(R.id.recyclerView);
        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);

        DividerItemDecoration dividerItemDecoration =
                new DividerItemDecoration(this, layoutManager.getOrientation());
        recyclerView.addItemDecoration(dividerItemDecoration);

        passStarships();
        getStarships();
    }


    public void passStarships() {
        SwapiRecyclerAdapter swapiRecyclerAdapter = new SwapiRecyclerAdapter(this, starshipList, this
        );
        recyclerView.setAdapter(swapiRecyclerAdapter);
    }

    private void getStarships() {


        Swapi swapi = RetrofitClient.getRetrofit().create(Swapi.class);
        Call<StarshipsResponse> call = swapi.getStarships();
        call.enqueue(new Callback<StarshipsResponse>() {

            @Override
            public void onResponse(Call<StarshipsResponse> call, Response<StarshipsResponse> response) {

                starshipList = response.body().getResult();
                passStarships();

                for (Starship starships: starshipList
                ) {
                    System.out.println(starships);
                }
            }

            @Override
            public void onFailure(Call<StarshipsResponse> call, Throwable t) {
            }
        });

    }

    @Override
    public void onStarshipClick(int position) {
        Intent intent = new Intent(this, StarshipDetail.class);
        intent.putExtra("name", starshipList.get(position).getName());
        intent.putExtra("model", starshipList.get(position).getModel());
        intent.putExtra("crew", starshipList.get(position).getCrew());
        intent.putExtra("manufacturer", starshipList.get(position).getManufacturer());
        intent.putExtra("cost_in_credits", starshipList.get(position).getCost());
        intent.putExtra("length", starshipList.get(position).getLength());

        startActivity(intent);
    }
}

