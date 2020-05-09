package edu.sabanciuniv.operatingsystemslibrary;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.reflect.Array;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.nio.Buffer;
import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    RecyclerView recView;
    ProgressDialog prgDialog;
    List<OperatingSystem> data;
    OperatingSystemsAdapter adp;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        recView = findViewById(R.id.recview);
        recView.setLayoutManager(new LinearLayoutManager(this));
        data = new ArrayList<>();

        adp = new OperatingSystemsAdapter(this, data, new OperatingSystemsAdapter.OperatingSystemAdapterListener() {
            @Override
            public void opsSysClicked(OperatingSystem opsys) {
                //Toast.makeText(MainActivity.this,opsys.getName(),Toast.LENGTH_SHORT).show();

                Intent i = new Intent(MainActivity.this,DetailActivity.class);
                i.putExtra("select_opsys",opsys);
                startActivity(i);

            }
        });

        recView.setAdapter(adp);

        OperatingSystemsTask tsk = new OperatingSystemsTask();
        tsk.execute("http://94.138.207.51:8080/OperatingSystemsService/rest/service/getall");

    }


    class OperatingSystemsTask extends AsyncTask<String,Void,String>{

        @Override
        protected void onPreExecute() {
            prgDialog = new ProgressDialog(MainActivity.this);
            prgDialog.setTitle("Loading");
            prgDialog.setMessage("Please wait...");
            prgDialog.setProgressStyle(ProgressDialog.STYLE_SPINNER);
            prgDialog.show();
        }

        @Override
        protected String doInBackground(String... strings) {
            String urlStr = strings[0];
            HttpURLConnection conn = null;
            StringBuilder buffer = new StringBuilder();
            try {
                URL url = new URL(urlStr);
                conn = (HttpURLConnection)url.openConnection();

                BufferedReader reader= new BufferedReader(new InputStreamReader(conn.getInputStream()));

                String line ="";

                while((line=reader.readLine())!=null){
                    buffer.append(line);
                }



            } catch (MalformedURLException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }finally {
                if(conn!=null) conn.disconnect();
            }

            return buffer.toString();
        }

        @Override
        protected void onPostExecute(String s) {

            //Create Json Array from String s
            //Initialize a List of OperatingSystems
            //Refresh the recycler view
            // dismiss progress dialog

            try {
                JSONArray arr = new JSONArray(s);

                for (int i = 0; i<arr.length();i++){

                    JSONObject obj = (JSONObject) arr.get(i);

                    data.add(new OperatingSystem(obj.getInt("id"),
                            obj.getString("name"),
                            obj.getString("history"),
                            obj.getString("imagepath")));

                }


            } catch (JSONException e) {
                e.printStackTrace();
            }
            Log.i("DEV",String.valueOf(data.size()));

            adp.notifyDataSetChanged();

            prgDialog.dismiss();
        }
    }
}
