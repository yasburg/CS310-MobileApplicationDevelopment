package edu.sabanciuniv.cs310tasksandbackstack;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class ActivityX extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_x);
    }

    public void startY(View v){

        Intent i = new Intent(this,ActivityY.class);
        startActivity(i);


    }
}
