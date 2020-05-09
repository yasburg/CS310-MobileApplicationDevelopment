package edu.sabanciuniv.cs310httpconnectionsexample;

import androidx.appcompat.app.AppCompatActivity;

import android.os.AsyncTask;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

public class MainActivity extends AppCompatActivity {

    TextView txtplainhello;
    TextView txtnameout;
    EditText txtname;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        txtplainhello = findViewById(R.id.txtplainhello);
        txtnameout = findViewById(R.id.txtparamwelcome);
        txtname = findViewById(R.id.txtname);

    }


    public void plainServiceClicked(View v){

            BasicHelloTask tsk = new BasicHelloTask();
            tsk.execute("http://94.138.207.51:8080/WelcomeService/rest/hello/sayhello");



    }

    public void nameServiceClicked(View v){
        NameInputHelloTask tsk = new NameInputHelloTask();
        tsk.execute("http://94.138.207.51:8080/WelcomeService/rest/hello/sayhello",txtname.getText().toString());
    }

    class NameInputHelloTask extends AsyncTask<String, Void, String>{

        @Override
        protected String doInBackground(String... strings) {


            String name = strings[1];
            String urlStr =  strings[0] + "/" + name;
            StringBuilder strBuilder = new StringBuilder();

            try {
                URL url = new URL(urlStr);

                HttpURLConnection conn = (HttpURLConnection)url.openConnection();

                //Readers are for text reading
                //Streams are for binary data reading
                //Reader need streams to read characters

                BufferedReader reader = new BufferedReader(new InputStreamReader(conn.getInputStream()));

                String line ="";
                while((line=reader.readLine())!=null){
                    strBuilder.append(line);
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

            txtnameout.setText(s);


        }
    }

    class BasicHelloTask extends AsyncTask<String, Void, String>{

        @Override
        protected String doInBackground(String... strings) {

            String urlStr =  strings[0];
            StringBuilder strBuilder = new StringBuilder();

            try {
                URL url = new URL(urlStr);

                HttpURLConnection conn = (HttpURLConnection)url.openConnection();

                //Readers are for text reading
                //Streams are for binary data reading
                //Reader need streams to read characters

                BufferedReader reader = new BufferedReader(new InputStreamReader(conn.getInputStream()));

                String line ="";
                while((line=reader.readLine())!=null){
                    strBuilder.append(line);
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

            txtplainhello.setText(s);


        }
    }
}
