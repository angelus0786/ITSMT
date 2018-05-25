package mx.edu.itsmt.angelus.encuesta;

import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import java.io.Serializable;
import java.util.ArrayList;

import mx.edu.itsmt.angelus.encuesta.Modelo.Pregunta;
import mx.edu.itsmt.angelus.encuesta.Sqlite.OperacionesBD;

public class MainActivity extends AppCompatActivity {

    ListView datos;
    ArrayList<Pregunta> lista;
    private OperacionesBD operacion;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        operacion = new OperacionesBD(this);
        datos = (ListView) findViewById(R.id.LSTDatos);
        cargarTabla();


        datos.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Pregunta obj = (Pregunta)parent.getItemAtPosition(position);
                Intent paso = new Intent(getApplicationContext(),Detalle.class);
                paso.putExtra("objeto",(Serializable)obj);
                startActivity(paso);
            }
        });
    }


    public void cargarTabla(){
        operacion = new OperacionesBD(this);
        Cursor c =operacion.ListaPregunta();
        lista = new ArrayList<Pregunta>();
        String pregunta="";int id=0;
        String tipo="";
        if (c.moveToFirst()){
            do {
                id=c.getInt(0);
                pregunta=c.getString(1);
                tipo = c.getString(2);
                //linea utilizada para obtener el id de la imagen
                int resID = getResources().getIdentifier(tipo, "drawable", "package.name");
                lista.add(new Pregunta(id,pregunta,tipo));
            }while (c.moveToNext());
        }
        Adaptador adaptador = new Adaptador(getApplicationContext(),lista);
        datos.setAdapter(adaptador);

    }
}
