package edu.sabanciuniv.planetsapp;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

import edu.sabanciuniv.planetsapp.model.Planet;

public class PlanetsAdapter extends RecyclerView.Adapter<PlanetsAdapter.PlanetsViewHolder> {

    List<Planet> planetsData;
    Context context;
    PlanetsClickListener listener;

    public PlanetsAdapter(List<Planet> planetsData, Context context, PlanetsClickListener listener) {
        this.planetsData = planetsData;
        this.context = context;
        this.listener = listener;
    }

    @NonNull
    @Override
    public PlanetsViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

       View v= LayoutInflater.from(context).inflate(R.layout.planets_row_layout,parent,false);

        return new PlanetsViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull PlanetsViewHolder holder, final int position) {

        holder.txtlistPlanetname.setText(planetsData.get(position).getName());
        holder.imglistPlanet.setImageResource(planetsData.get(position).getImg());
        holder.root.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                listener.planetClicked(planetsData.get(position));
            }
        });

    }

    @Override
    public int getItemCount() {

        return planetsData.size();
    }

    public interface PlanetsClickListener{

        public void planetClicked(Planet p);
    }

    class PlanetsViewHolder extends RecyclerView.ViewHolder{

        TextView txtlistPlanetname;
        ConstraintLayout root;
        ImageView imglistPlanet;

        public PlanetsViewHolder(@NonNull View itemView) {
            super(itemView);
            txtlistPlanetname = itemView.findViewById(R.id.txtlistplanetname);
            imglistPlanet = itemView.findViewById(R.id.imglistplanet);
            root = itemView.findViewById(R.id.container);


        }
    }

}
