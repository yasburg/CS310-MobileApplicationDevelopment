package edu.sabanciuniv.cs310introtothreads;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.app.ProgressDialog;
import android.os.AsyncTask;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.view.View;
import android.widget.ProgressBar;

public class MainActivity extends AppCompatActivity {

    ProgressDialog prgDialog;
    ProgressBar progressBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        progressBar = findViewById(R.id.progressBar);
    }


    public void startAsyncClicked(View v){

        //SampleTask tsk = new SampleTask();
        //tsk.execute("one","two","three");

        CountTask tsk = new CountTask();
        tsk.execute();




    }

    class CountTask extends AsyncTask<Void,Integer,Void>{

        //Void is null

        @Override
        protected void onPreExecute() {
            //Display Progress Dilaog
           progressBar.setProgress(0);
        }

        @Override
        protected Void doInBackground(Void... voids) {

            int count =0;
            while(count<=101){
                count++;
                try {
                    Thread.sleep(100);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                publishProgress(count);
            }


            return null;
        }


        @Override
        protected void onProgressUpdate(Integer... values) {

            progressBar.setProgress(values[0]);



        }

        @Override
        protected void onPostExecute(Void aVoid) {
            //Dismiss progress dialog
            progressBar.setProgress(100);
        }
    }


    /*
    // Params, progress and update
    class SampleTask extends AsyncTask<String,Integer,Double >{

        //First method called
        @Override
        protected void onPreExecute() {
            super.onPreExecute();
        }

        //Second method called
        @Override
        protected Double doInBackground(String... strings) {

            //String... strings -> variable length argument list
            // first elements: strings[0]

            //Thread of the async task
            publishProgress(2);

            return null;
        }

        //called when publishProgress() is called
        @Override
        protected void onProgressUpdate(Integer... values) {

        }

        //Last method invoked
        @Override
        protected void onPostExecute(Double aDouble) {
            super.onPostExecute(aDouble);
        }
    }

*/




    public void startHandlerClicked(View v){

        prgDialog = new ProgressDialog(this);
        prgDialog.setProgressStyle(ProgressDialog.STYLE_HORIZONTAL);
        prgDialog.setTitle("Loading");
        prgDialog.setMessage("Please wait..");

        prgDialog.show();

        CountThread countThread = new CountThread();
        countThread.start();


    }


    Handler countHandler = new Handler(){

        @Override
        public void handleMessage(@NonNull Message msg) {

            //Bundle bundle = msg.getData();

            int progressVal =  msg.what;

            if(progressVal<101){
                prgDialog.setProgress(progressVal);
            }else{
                prgDialog.dismiss();
            }


        }
    };


    //Creating Java Threads: extend from Thread class and override run() method

    class CountThread extends Thread{

        @Override
        public void run() {

            int count = 0;

            while(count<=101){

                count++;

                //Bundle bundle = new Bundle();
                //bundle.putInt("count",count);
                //Message msg = new Message();
                //msg.setData(bundle);
                //countHandler.sendMessage(msg);

                countHandler.sendEmptyMessage(count);
                try {
                    Thread.sleep(100);

                } catch (InterruptedException e) {
                    e.printStackTrace();
                }


            }

        }
    }


}
