package edu.sabanciuniv.cs310listexample;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    ListView listView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        listView = findViewById(R.id.lstplanet);


        ArrayAdapter<Planet> adp
                = new ArrayAdapter<>(this,
                android.R.layout.simple_list_item_1,
                Planet.getAllPlanets());

        listView.setAdapter(adp);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Toast.makeText(MainActivity.this,
                        Planet.getAllPlanets().get(position).getName(),
                        Toast.LENGTH_SHORT).show();
            }
        });

    }
}
