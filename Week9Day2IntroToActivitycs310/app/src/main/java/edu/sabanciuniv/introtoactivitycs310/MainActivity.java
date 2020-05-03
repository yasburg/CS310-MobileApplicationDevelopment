package edu.sabanciuniv.introtoactivitycs310;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

import androidx.annotation.Nullable;

import java.util.Date;

public class MainActivity extends Activity {

//Entrance point

    // res -> all the file names are put inside the R file automatically.

    // Inside R file:
    // //public static final int main_activity_layout = -133455;

    TextView txtout;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        //Loading a layout
        setContentView(R.layout.mainactivity_layout);

        //search for the textview

        txtout = findViewById(R.id.txtout);

        txtout.setText("Text added by activity at " + new Date());
        Log.i("DEV","-------onCreate() called");
    }

    @Override
    protected void onStart() {
        super.onStart();
        //Write out "onStart is called"
        //We'll use LogCat for logging

        Log.i("DEV","-------onStart() called");

    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.i("DEV","-------onResume() called");
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.i("DEV","-------onPause() called");
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.i("DEV","-------onStop() called");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.i("DEV","-------onDestroy() called");
    }
}
