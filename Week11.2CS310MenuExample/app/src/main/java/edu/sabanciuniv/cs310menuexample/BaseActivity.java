package edu.sabanciuniv.cs310menuexample;

import android.content.Intent;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

public class BaseActivity extends AppCompatActivity {



    @Override
    public boolean onCreateOptionsMenu(Menu menu) {

        getMenuInflater().inflate(R.menu.main_menu,menu);

        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {

        if(item.getItemId()== R.id.mn_help){
            Toast.makeText(this,"Help clicked",Toast.LENGTH_SHORT).show();
        }else if(item.getItemId()== R.id.mn_contact){
            Toast.makeText(this,"Contact clicked",Toast.LENGTH_SHORT).show();
        }else if(item.getItemId()== R.id.mn_about){

            Intent i = new Intent(this, AboutActivity.class);
            startActivity(i);

        }

        return true;

    }

}
