package edu.sabanciuniv.planetsapp;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.opengl.EGLExt;
import android.os.Bundle;
import android.view.MenuItem;
import android.widget.ImageView;
import android.widget.TextView;

import edu.sabanciuniv.planetsapp.model.Planet;

public class PlanetDetailActivity extends AppCompatActivity {

    ImageView imgPlanet;
    TextView txtDescription;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_planet_detail);
        imgPlanet = findViewById(R.id.imgplanetdetail);
        txtDescription = findViewById(R.id.txtplanetdesc);
        //Selected planet object will be sent to this activity
               Planet selected = (Planet)getIntent().getSerializableExtra("selectedplanet");

        imgPlanet.setImageResource(selected.getImg());
        txtDescription.setText(selected.getDescription());


        getSupportActionBar().setTitle(selected.getName());
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setHomeButtonEnabled(true);

        getSupportActionBar().setHomeAsUpIndicator(R.drawable.ic_back_18dp);

    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {

        if(item.getItemId() == android.R.id.home){
            //finish();
            onBackPressed();
        }
        return true;
    }
}
