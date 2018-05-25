package mx.edu.itsmt.angelus.encuesta;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.Switch;
import android.widget.TextView;

import mx.edu.itsmt.angelus.encuesta.Modelo.Pregunta;

public class Detalle extends AppCompatActivity {

    TextView titulo,detalle;
    Switch respuesta;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detalle);
        titulo = (TextView)findViewById(R.id.txtTitulo);
        detalle = (TextView)findViewById(R.id.txtDetalle);
        respuesta = (Switch) findViewById(R.id.swRespuesta);

        Pregunta obj = (Pregunta) getIntent().getExtras().getSerializable("objeto");
        detalle.setText(obj.getPregunta());


    }
}
