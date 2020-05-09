package edu.sabanciuniv.navigationwithcomponentexample;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.navigation.Navigation;
import androidx.navigation.fragment.NavHostFragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;


public class HomeFragment extends Fragment {


    Button btnabout;
    Button btnhelp;
    Button btnprod;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v = inflater.inflate(R.layout.fragment_home, container, false);

        btnabout = v.findViewById(R.id.btnabout);

        btnabout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Navigation.findNavController(v).navigate(R.id.action_homeFragment_to_aboutFragment);
            }
        });


        btnhelp = v.findViewById(R.id.btnhelp);
        btnhelp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Bundle bundle = new Bundle();
                bundle.putString("testdata","test test test");

                Navigation.findNavController(v).navigate(R.id.action_homeFragment_to_helpFragment,bundle);
            }
        });


        btnprod = v.findViewById(R.id.btnprod);
        btnprod.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Navigation.findNavController(v).navigate(R.id.productsFragment);


            }
        });

        return v;
    }
}
