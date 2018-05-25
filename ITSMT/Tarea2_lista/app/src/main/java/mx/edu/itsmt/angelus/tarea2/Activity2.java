package mx.edu.itsmt.angelus.tarea2;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListView;

import java.util.ArrayList;

public class Activity2 extends AppCompatActivity {

    ListView listViewDatos;
    Persona persona=null;
    ArrayList<Persona> listaPersona;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_2);

        listViewDatos =  findViewById(R.id.list_view);
       // persona = (Persona)getIntent().getSerializableExtra("objeto");
        listaPersona = (ArrayList<Persona>)getIntent().getSerializableExtra("lista");
       // listaPersona = new ArrayList<Persona>();
      //  listaPersona.add(persona);

        Adapter adapter =new Adapter(Activity2.this,listaPersona);
        listViewDatos.setAdapter(adapter);


    }
}
