package edu.sabanciuniv.navigationwithcomponentexample;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;


public class HelpFragment extends Fragment {



    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        Log.i("DEV",getArguments().getString("testdata"));
        return inflater.inflate(R.layout.fragment_help, container, false);
    }
}
