package edu.sabanciuniv.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

public class ResultActivity extends AppCompatActivity {

    TextView txtResultName;
    TextView txtResultLastName;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result);

        txtResultLastName = findViewById(R.id.txtResultLastName);
        txtResultName = findViewById(R.id.txtResultName);


        Client client =  (Client)getIntent().getSerializableExtra("client");
        txtResultName.setText(client.getName());
        txtResultLastName.setText(client.getLastname());

    }
}
