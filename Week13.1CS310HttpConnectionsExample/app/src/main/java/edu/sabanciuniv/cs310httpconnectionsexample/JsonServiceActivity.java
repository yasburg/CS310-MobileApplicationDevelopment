package edu.sabanciuniv.cs310httpconnectionsexample;

import androidx.appcompat.app.AppCompatActivity;

import android.os.AsyncTask;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

public class JsonServiceActivity extends AppCompatActivity {

    EditText txtnameinput;
    EditText txtlnameinput;
    TextView txtfullout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_json_service);


        txtnameinput = findViewById(R.id.txtjsonname);
        txtlnameinput = findViewById(R.id.txtjsonlastname);
        txtfullout = findViewById(R.id.txtjsonout);
    }

    public void taskCallClicked(View v){

            JsonTask tsk = new JsonTask();
            tsk.execute("http://94.138.207.51:8080/WelcomeService/rest/hello/sayhellojson",
                    txtnameinput.getText().toString(),
                    txtlnameinput.getText().toString());


    }



    class JsonTask extends AsyncTask<String,Void,String>{


        @Override
        protected String doInBackground(String... strings) {

            StringBuilder strBuilder = new StringBuilder();
            String urlStr = strings[0];
            String name = strings[1];
            String lastname = strings[2];

            JSONObject obj = new JSONObject();
            try {
                obj.put("name",name);
                obj.put("lastname",lastname);
            } catch (JSONException e) {
                e.printStackTrace();
            }


            try {
                URL url = new URL(urlStr);
                HttpURLConnection conn = (HttpURLConnection)url.openConnection();
                conn.setDoInput(true);
                conn.setDoOutput(true);
                conn.setRequestMethod("POST");
                conn.setRequestProperty("Content-Type","application/json");
                conn.connect();

                DataOutputStream out = new DataOutputStream(conn.getOutputStream());
                out.writeBytes(obj.toString());


                if(conn.getResponseCode()==HttpURLConnection.HTTP_OK){
                    BufferedReader reader = new BufferedReader(new InputStreamReader(conn.getInputStream()));
                    String line ="";

                    while((line = reader.readLine())!=null){
                        strBuilder.append(line);
                    }

                }

            } catch (MalformedURLException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }
            return strBuilder.toString();
        }

        @Override
        protected void onPostExecute(String s) {

            try {
                JSONObject inputObj = new JSONObject(s);

                String date = inputObj.getString("date");
                String fullname = inputObj.getString("fullname");

                txtfullout.setText(date + " --- " + fullname);




            } catch (JSONException e) {
                e.printStackTrace();
            }


        }
    }

}
