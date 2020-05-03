package edu.sabanciuniv.cs310dialogexample;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    TextView txtnameinput;
    TextView txtdate;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        txtnameinput = findViewById(R.id.txtnameinput);
        txtdate = findViewById(R.id.txtselecteddate);
    }

    public void showDateDialog(View v){
        FragmentManager fm = getSupportFragmentManager();
        SelectDateDialog dialog = new SelectDateDialog(new SelectDateDialog.SelectDateListener() {
            @Override
            public void dateSelected(int day, int month, int year) {

                String dt = day + "/" + month + "/" + year;
                txtdate.setText(dt);
            }
        });

        dialog.show(fm,"");


    }


    public void showNameInputDialog(View v){
        FragmentManager fm = getSupportFragmentManager();
        NameInputDialog dialog = new NameInputDialog(new NameInputDialog.NameInputDialogListener() {
           @Override
           public void nameEntered(String name) {
                txtnameinput.setText(name);

           }
       });

        dialog.show(fm,"");
    }

    public void showAlertDialog(View v){

        FragmentManager fm = getSupportFragmentManager();
        YesyNoDialog dialog = new YesyNoDialog();
        dialog.show(fm,"");


    }
}
