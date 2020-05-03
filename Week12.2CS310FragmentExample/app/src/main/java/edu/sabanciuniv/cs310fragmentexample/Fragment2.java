package edu.sabanciuniv.cs310fragmentexample;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

public class Fragment2 extends Fragment {

    //Apply Observer Pattern

    Button btnOk;
    EditText txtinput;
    Fragment1Listener listener;

    public Fragment2(Fragment1Listener listener) {
        this.listener = listener;
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {


        View v = inflater.inflate(R.layout.fragment2_layout, container,false);
        btnOk = v.findViewById(R.id.btnOk);
        txtinput = v.findViewById(R.id.txtinput);

        btnOk.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                listener.button_clicked(txtinput.getText().toString());
            }
        });



        return v;
    }

    public interface Fragment1Listener{
        public void button_clicked(String text);
    }
}
