package edu.sabanciuniv.operatingsystemslibrary;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.media.Image;
import android.os.AsyncTask;
import android.text.Layout;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;

import java.io.BufferedInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.net.URL;
import java.nio.channels.AsynchronousChannelGroup;
import java.util.List;


public class OperatingSystemsAdapter extends RecyclerView.Adapter<OperatingSystemsAdapter.OprSysViewHolder> {

    Context context;
    List<OperatingSystem> data;
    OperatingSystemAdapterListener listener;

    public OperatingSystemsAdapter(Context context, List<OperatingSystem> data, OperatingSystemAdapterListener listener) {
        this.context = context;
        this.data = data;
        this.listener = listener;
    }

    @NonNull
    @Override
    public OprSysViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View v= LayoutInflater.from(context).inflate(R.layout.oprsys_row_layout,parent,false);


        return new OprSysViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull OprSysViewHolder holder, final int position) {


        holder.txtname.setText(data.get(position).getName());
        holder.root.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                listener.opsSysClicked(data.get(position));
            }
        });
        //TODO: loading image
        //check if it is downloaded before
            //if not, download adn cache (OperatingSystemClass)
            // if yes, just get the bitmap from OperatingSystem and set image of imageview

        if(data.get(position).getBitmap()==null){
            new ImageDownloadTask(holder.imgOpSys).execute(data.get(position));
        }else{
            holder.imgOpSys.setImageBitmap(data.get(position).getBitmap());
        }

    }

    @Override
    public int getItemCount() {
        return data.size();
    }

    class ImageDownloadTask extends  AsyncTask<OperatingSystem,Void, Bitmap>{
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

    class OprSysViewHolder extends RecyclerView.ViewHolder{

        TextView txtname;
        ImageView imgOpSys;
        ConstraintLayout root;



        public OprSysViewHolder(@NonNull View itemView) {
            super(itemView);
            txtname = itemView.findViewById(R.id.txtoprsysname);
            imgOpSys = itemView.findViewById(R.id.imgopsys);
            root = itemView.findViewById(R.id.container);
        }
    }

    interface OperatingSystemAdapterListener{
        public void opsSysClicked(OperatingSystem opsys);
    }


}
