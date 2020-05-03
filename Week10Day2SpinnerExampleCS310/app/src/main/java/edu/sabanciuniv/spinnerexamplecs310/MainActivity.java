package edu.sabanciuniv.spinnerexamplecs310;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    Spinner spcities1;
    Spinner spcities2;
    TextView txtcity1;
    TextView txtcity2;
    Button btncity1;
    Spinner spDepartments;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Boiler plate code: the same code you have write all the time
        spcities1 = findViewById(R.id.spcities);
        txtcity1 = findViewById(R.id.txtcity1);
        txtcity2 = findViewById(R.id.txtcity2);
        btncity1 = findViewById(R.id.btncity1);
        spDepartments = findViewById(R.id.spdepartments);
        //Spinner extends from AdapterView
        //AdapderView -> Any Vİew that can hold multiple information:
            //like spinners, lists, radio button lists, etc.

        //To fill adapter view types we need to create an adapter object
        //adapters carry the information to display in the spinner or similar objects

        spcities2 = findViewById(R.id.spcities2);

        //context -> running activity

        String[] cities = getResources().getStringArray(R.array.cities);

        ArrayAdapter<String> adp =
                new ArrayAdapter<>(this, android.R.layout.simple_spinner_item,cities);

        spcities2.setAdapter(adp);


        spcities2.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {

                String selectCity = spcities2.getSelectedItem().toString();
                txtcity2.setText(selectCity);

            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

        ArrayAdapter<Department> adp2
                = new ArrayAdapter<>(
                        this,
                        R.layout.dept_spinner_layout,
                        R.id.txtitem,
                        Department.getAllDepartments()
        );

        spDepartments.setAdapter(adp2);

        spDepartments.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {

               String name = ((Department)spDepartments.getSelectedItem()).getName();

               Toast.makeText(MainActivity.this, name, Toast.LENGTH_SHORT).show();

            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });


        btncity1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String selectedText = spcities1.getSelectedItem().toString();
                txtcity1.setText(selectedText);
                Toast.makeText(MainActivity.this,selectedText,Toast.LENGTH_SHORT).show();
                //Toast Messages:
                //Short notification on screen

            }
        });



    }
}
