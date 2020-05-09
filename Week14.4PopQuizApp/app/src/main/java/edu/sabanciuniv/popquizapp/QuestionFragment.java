package edu.sabanciuniv.popquizapp;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

public class QuestionFragment extends Fragment {

    TextView txtquestion;
    TextView txtoptions;
    Spinner spanswers;
    Button btnnex;
    AnswerListener listener;
    private int questioncount;
    private String questionstring;
    private String questionoptions;


    public QuestionFragment(AnswerListener listener, int questioncount, String questionstring, String questionoptions) {
        this.listener = listener;
        this.questioncount = questioncount;
        this.questionstring = questionstring;
        this.questionoptions = questionoptions;
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {


        View v= LayoutInflater.from(getContext()).inflate(R.layout.question_fragment_layout,container,false);

        txtquestion =  v.findViewById(R.id.txtquestion);
        txtoptions =  v.findViewById(R.id.txtoptions);
        spanswers = v.findViewById(R.id.spanswers);
        btnnex = v.findViewById(R.id.btnnext);


        txtquestion.setText(String.valueOf(questioncount) + ") " +  questionstring);
        txtoptions.setText(questionoptions);


        btnnex.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                listener.questionAnswered(spanswers.getSelectedItem().toString());
            }
        });

        return v;
    }

    public interface AnswerListener{
        public void questionAnswered(String answer);
    }

}
