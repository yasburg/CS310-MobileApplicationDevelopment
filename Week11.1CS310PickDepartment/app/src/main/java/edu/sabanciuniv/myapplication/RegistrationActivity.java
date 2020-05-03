package edu.sabanciuniv.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class RegistrationActivity extends AppCompatActivity {
    EditText txtName;
    EditText txtLastname;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registration);

        txtName = findViewById(R.id.txtName);
        txtLastname = findViewById(R.id.txtLastName);

    }


    public void toResultClicked(View v){

        Client client = new Client(txtName.getText().toString(),txtLastname.getText().toString());

        Intent i = new Intent(this, ResultActivity.class);
        i.putExtra("client",client);
        startActivity(i);


    }
}
