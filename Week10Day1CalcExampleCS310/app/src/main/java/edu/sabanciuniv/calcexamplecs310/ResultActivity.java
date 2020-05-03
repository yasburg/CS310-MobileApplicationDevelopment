package edu.sabanciuniv.calcexamplecs310;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

public class ResultActivity extends AppCompatActivity {

    TextView txtactresult;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result);


        txtactresult = findViewById(R.id.txtactresult);

        double result = getIntent().getExtras().getDouble("result");

        txtactresult.setText(String.valueOf(result));

    }
}
