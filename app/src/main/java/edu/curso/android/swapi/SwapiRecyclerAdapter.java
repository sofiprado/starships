package edu.curso.android.swapi;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

import edu.curso.android.swapi.rest.Starship;

public class SwapiRecyclerAdapter extends  RecyclerView.Adapter<SwapiRecyclerAdapter.SwapiViewHolder> {


    private Context context;
    private List<Starship> starshipList;
    private StarshipClickListener mStarshipClickListener;

    public SwapiRecyclerAdapter(Context context, List<Starship> starshipsList, StarshipClickListener starshipClickListener) {
        this.context = context;
        this.starshipList=starshipsList;
        this.mStarshipClickListener = starshipClickListener;
    }

    @Override
    public SwapiRecyclerAdapter.SwapiViewHolder onCreateViewHolder(ViewGroup parent, int Viewtype) {
        View view = LayoutInflater.from(context).inflate(R.layout.starships_list_view, parent,false);
       // View detailView = LayoutInflater.from(context).inflate(R.layout.activity_starship_detail, parent,false)
        return new SwapiViewHolder(view, mStarshipClickListener);
    }

    @Override
    public void onBindViewHolder(SwapiRecyclerAdapter.SwapiViewHolder holder, int position) {
        holder.textViewName.setText( starshipList.get(position).getName().toUpperCase());
        holder.textViewModel.setText("Modelo: " + starshipList.get(position).getModel());



       // holder.textViewCrew.setText(starshipList.get(position).getCrew());
    }

    @Override
    public int getItemCount() {
        if(starshipList != null) {
            return starshipList.size();
        }
        return 0;
    }

    public interface StarshipClickListener {
        void onStarshipClick(int position);
    }

    public class SwapiViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        TextView textViewName;
        TextView textViewModel;

        StarshipClickListener starshipClickListener;

        public SwapiViewHolder(View itemView, StarshipClickListener starshipClickListener) {
            super(itemView);
            textViewName = (TextView) itemView.findViewById(R.id.textViewName);
            textViewModel = (TextView)itemView.findViewById(R.id.textViewModel);

            this.starshipClickListener = starshipClickListener;

            itemView.setOnClickListener(this);
        }

        @Override
        public void onClick(View v) {
            starshipClickListener.onStarshipClick(getAdapterPosition());
        }
    }
}
