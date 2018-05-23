package mx.edu.itsmt.angelus.ejemplo_fragments.Fragments;


import android.graphics.Color;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import mx.edu.itsmt.angelus.ejemplo_fragments.R;

public class DetailsFragment extends Fragment {

    private TextView details;

    public DetailsFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_details,container,false);
        details = (TextView) view.findViewById(R.id.texviewDetails);

        return view;
    }

    public  void renderText(String text) {
        details.setTextColor(Color.argb(255,33,177,8));
        details.setText(text);
    }

}
