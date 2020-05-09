package edu.sabanciuniv.operatingsystemslibrary;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.AsyncTask;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import java.io.BufferedInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.net.URL;

public class DetailActivity extends AppCompatActivity {

    TextView txtdetail;
    ImageView imgDetail;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);
        txtdetail = findViewById(R.id.txtdetail);
        imgDetail = findViewById(R.id.imgdetail);

        OperatingSystem opsys= (OperatingSystem)getIntent().getSerializableExtra("select_opsys");

        txtdetail.setText(opsys.getHistory());

        getSupportActionBar().setTitle(opsys.getName());

        ImageDownloadTask tsk = new ImageDownloadTask(imgDetail);
        tsk.execute(opsys);

    }

    class ImageDownloadTask extends AsyncTask<OperatingSystem,Void, Bitmap> {
        ImageView imgView;

        public ImageDownloadTask(ImageView imgView) {
            this.imgView = imgView;
        }

        @Override
        protected Bitmap doInBackground(OperatingSystem... operatingSystems) {

            OperatingSystem current = operatingSystems[0];
            Bitmap bitmap = null;

            try {
                URL url = new URL(current.getImagePath());

                InputStream is = new BufferedInputStream(url.openStream());

                bitmap = BitmapFactory.decodeStream(is);
                current.setBitmap(bitmap);

            } catch (MalformedURLException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }


            return bitmap;
        }

        @Override
        protected void onPostExecute(Bitmap bitmap) {

            imgView.setImageBitmap(bitmap);


        }
    }

}
