package edu.sabanciuniv.introtoactivitycs310;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity2 extends AppCompatActivity {

    TextView txtClientOut;
    EditText txtInput;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        txtClientOut = findViewById(R.id.txtclientout);
        txtInput = findViewById(R.id.txtin);

    }

    //Event handler
    public void btnOkClicked(View v){

        txtClientOut.setText(txtInput.getText().toString());

    }
}
