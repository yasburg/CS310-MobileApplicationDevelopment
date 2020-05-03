package edu.sabanciuniv.cs310fragmentexample;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    TextView txtoutput;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        txtoutput = findViewById(R.id.txtoutput);
    }

    public void frg2Clicked(View v){
        Fragment2 fr2 = new Fragment2(new Fragment2.Fragment1Listener() {
            @Override
            public void button_clicked(String text) {
                txtoutput.setText(text);
            }
        });
        FragmentManager fm= getSupportFragmentManager();

        FragmentTransaction transaction = fm.beginTransaction();
        transaction.replace(R.id.container,fr2);
        transaction.addToBackStack("");
        transaction.commit();

    }

    public void frg1Clicked(View v){

        Fragment1 fr1 = new Fragment1("altug tanaltay");
        FragmentManager fm= getSupportFragmentManager();

        FragmentTransaction transaction = fm.beginTransaction();
        transaction.replace(R.id.container,fr1);
        transaction.addToBackStack("");
        transaction.commit();



    }
}
