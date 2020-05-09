package edu.sabanciuniv.popquizapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.AsyncTask;
import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

public class MainActivity extends AppCompatActivity implements QuestionFragment.AnswerListener, ResultFragment.RestartListener {

    String questionid;
    int questioncount =1;
    int correctcount=0;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        QuestionTask tsk = new QuestionTask();
        tsk.execute("http://94.138.207.51:8080/AndroidQuizService/rest/quiz/question");

    }

    @Override
    public void questionAnswered(String answer) {
            AnswerTask tsk = new AnswerTask(answer);
            tsk.execute("http://94.138.207.51:8080/AndroidQuizService/rest/quiz/answer");
    }

    @Override
    public void restartClicked() {
        questioncount =1;
        correctcount = 0;
        QuestionTask tsk = new QuestionTask();
        tsk.execute("http://94.138.207.51:8080/AndroidQuizService/rest/quiz/question");

    }


    class AnswerTask extends  AsyncTask<String, Void, String>{

        String option;

        public AnswerTask(String option) {
            this.option = option;
        }

        @Override
        protected String doInBackground(String... strings) {
            String urlStr = strings[0];
            StringBuilder buffer = new StringBuilder();
            JSONObject obj = new JSONObject();
            try {
                obj.put("questionid",questionid);
                obj.put("option",option);

                URL url = new URL(urlStr);
                HttpURLConnection conn = (HttpURLConnection)url.openConnection();
                conn.setDoOutput(true);
                conn.setDoInput(true);
                conn.setRequestMethod("POST");
                conn.setRequestProperty("Content-Type","application/json");
                conn.connect();

                DataOutputStream writer = new DataOutputStream(conn.getOutputStream());
                writer.writeBytes(obj.toString());

                if(conn.getResponseCode()==HttpURLConnection.HTTP_OK){

                    BufferedReader reader = new BufferedReader(new InputStreamReader(conn.getInputStream()));

                    String line ="";

                    while ((line = reader.readLine())!=null){
                        buffer.append(line);
                    }


                }



            } catch (JSONException | MalformedURLException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }


            return buffer.toString();
        }

        @Override
        protected void onPostExecute(String s) {
            try {
                JSONObject obj = new JSONObject(s);
                String result = obj.getString("result");
                if(result.equals("correct")){
                    Toast.makeText(MainActivity.this,"Correct!", Toast.LENGTH_SHORT).show();
                    correctcount++;
                }else Toast.makeText(MainActivity.this,"Incorrect!", Toast.LENGTH_SHORT).show();


                if(questioncount<5){
                    questioncount++;
                    QuestionTask tsk = new QuestionTask();
                    tsk.execute("http://94.138.207.51:8080/AndroidQuizService/rest/quiz/question");

                }else{

                    ResultFragment fgr = new ResultFragment(MainActivity.this,correctcount);
                    getSupportFragmentManager().beginTransaction().replace(R.id.container,fgr).commit();

                }



            } catch (JSONException e) {
                e.printStackTrace();
            }

        }
    }


    class QuestionTask extends AsyncTask<String, Void, String>{


        @Override
        protected String doInBackground(String... strings) {

            String urlStr = strings[0];
            StringBuilder buffer = new StringBuilder();
            try {
                URL url = new URL(urlStr);

                HttpURLConnection conn = (HttpURLConnection)url.openConnection();

                BufferedReader reader = new BufferedReader(new InputStreamReader(conn.getInputStream()));

                String line ="";

                while ((line = reader.readLine())!=null){
                    buffer.append(line);
                }


            } catch (MalformedURLException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }


            return buffer.toString();
        }


        @Override
        protected void onPostExecute(String s) {

            try {
                JSONObject obj = new JSONObject(s);

                String question = obj.getString("question");
                String answers = obj.getString("answers");
                questionid = obj.getString("questionid");

                QuestionFragment frg = new QuestionFragment(MainActivity.this,questioncount,question,answers);

                getSupportFragmentManager().beginTransaction().replace(R.id.container,frg).commit();

            } catch (JSONException e) {
                Log.e("DEV",e.getMessage());

            }


        }
    }
}
