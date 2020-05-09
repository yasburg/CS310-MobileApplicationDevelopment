package edu.sabanciuniv.introtoweb;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.webkit.WebView;

public class StaticDataWebActivity extends AppCompatActivity {
    WebView webview;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        webview = findViewById(R.id.webview);
    }

    public void btnGoClicked(View v){

        String htmlStr = "<html><body><h2>Welcome to the web apps</h2></body></html>";
        webview.loadData(htmlStr,"text/html","utf-8");


    }
}
