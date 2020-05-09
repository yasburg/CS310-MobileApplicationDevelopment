package edu.sabanciuniv.popquizapp;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import org.w3c.dom.Text;


public class ResultFragment extends Fragment {

    RestartListener listener;
    int numcorrectanswers;
    TextView txtcorrect;
    TextView txtwrong;
    TextView txtscore;
    Button btnrestart;

    public ResultFragment(RestartListener listener, int numcorrectanswers) {
        this.listener = listener;
        this.numcorrectanswers = numcorrectanswers;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v =  inflater.inflate(R.layout.fragment_result, container, false);
        txtcorrect = v.findViewById(R.id.txtcorrect);
        txtwrong = v.findViewById(R.id.txtwrong);
        txtscore = v.findViewById(R.id.txtscore);
        btnrestart = v.findViewById(R.id.btnresyart);

        txtcorrect.setText("Correct : " + String.valueOf(numcorrectanswers));

        txtwrong.setText("Wrong : " + String.valueOf(5-numcorrectanswers));

        double score = Double.valueOf(numcorrectanswers) / 5.0 * 100;

        txtscore.setText("Score : " + String.valueOf(score));

        btnrestart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                listener.restartClicked();
            }
        });

        return v;
    }

    public interface RestartListener{
        public void restartClicked();
    }
}
