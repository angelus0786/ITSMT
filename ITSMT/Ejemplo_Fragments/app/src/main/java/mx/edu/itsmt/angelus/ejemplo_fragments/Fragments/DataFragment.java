package mx.edu.itsmt.angelus.ejemplo_fragments.Fragments;


import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import mx.edu.itsmt.angelus.ejemplo_fragments.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class DataFragment extends Fragment {

    private TextView textData;
    private Button btnEnviar;
    private DataListener callback;

    public DataFragment() {
        // Required empty public constructor
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);

        try {
            //para asegurar que llega
            callback = (DataListener) context;
        }catch (Exception e){
            throw new ClassCastException(context.toString()+"");

        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_data,container,false);

        textData = (TextView) view.findViewById(R.id.editTextData);
        btnEnviar = (Button)view.findViewById(R.id.buttonSend);

        btnEnviar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                sendText(textData.getText().toString());

            }
        });


        return view;
    }

    public  void sendText(String text) {
        callback.sendData(text);
    }

    public interface DataListener{
        void sendData(String data);
    }

}
