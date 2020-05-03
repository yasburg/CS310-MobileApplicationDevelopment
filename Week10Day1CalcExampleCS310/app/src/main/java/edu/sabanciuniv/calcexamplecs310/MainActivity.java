package edu.sabanciuniv.calcexamplecs310;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    EditText txtnum1;
    EditText txtnum2;
    Button btn;
    TextView txtresult;
    Spinner spOperation;
    double result =0;
    double num1 =0;
    double num2 = 0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        txtnum1 = findViewById(R.id.txtnum1);
        txtnum2 = findViewById(R.id.txtnum2);
        btn = findViewById(R.id.btnok);
        txtresult = findViewById(R.id.txtresult);

        spOperation = findViewById(R.id.spoperation);


        //adding click event at runtime
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //casting: use wrapper object valueOf methods for casting

                num1 = Double.valueOf(txtnum1.getText().toString());
                num2 = Double.valueOf(txtnum2.getText().toString());
                makeCalculation();


            }
        });


    }


    private void makeCalculation(){

        String selectedOperation = spOperation.getSelectedItem().toString();

        // Don't write the code below, you will have problems
        //if(selectedOperation==  "SUM"){
        //
        //}

        if(selectedOperation.equals("SUM")){
            result = num1+num2;
        }else if(selectedOperation.equals("DIVIDE")){
            result = num1/num2;
        }else if(selectedOperation.equals("MULTIPLY")){
            result = num1*num2;
        }else{
            result = num1-num2;
        }

        txtresult.setText(String.valueOf(result));

    }


    public  void switchActivity(View v){

        Intent i = new Intent(this,ResultActivity.class);

        i.putExtra("result",result);

        startActivity(i);


    }

}
