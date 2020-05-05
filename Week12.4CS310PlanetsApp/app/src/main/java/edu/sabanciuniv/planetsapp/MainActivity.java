package edu.sabanciuniv.planetsapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Toast;

import edu.sabanciuniv.planetsapp.model.Planet;

public class MainActivity extends AppCompatActivity implements PlanetsAdapter.PlanetsClickListener {

    RecyclerView recViewPlanets;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        recViewPlanets = findViewById(R.id.recplanets);
        recViewPlanets.setHasFixedSize(true);

        //Layout Managers: 1) LinearLayoutManaer, 2) GridLayoutManager
        recViewPlanets.setLayoutManager(new LinearLayoutManager(this));

        PlanetsAdapter adp = new PlanetsAdapter(Planet.getAllPlanets(),this,this);
        recViewPlanets.setAdapter(adp);



    }

    @Override
    public void planetClicked(Planet p) {
        //Toast.makeText(this,p.getName(),Toast.LENGTH_SHORT).show();

        Intent i = new Intent(this,PlanetDetailActivity.class);
        i.putExtra("selectedplanet", p);
        startActivity(i);

    }
}
