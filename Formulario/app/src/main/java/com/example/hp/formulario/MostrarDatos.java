package com.example.hp.formulario;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class MostrarDatos extends AppCompatActivity {

    TextView tvNombre,tvApellidos,tvCorreo,tvTelefono,tvfechaNaciomiento;
    Persona persona;
    Button btconsulta;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mostrar_datos);

        tvNombre = (TextView)findViewById(R.id.tvNombre);
        tvApellidos = (TextView)findViewById(R.id.tvApellidos);
        tvCorreo = (TextView)findViewById(R.id.tvCorreo);
        tvTelefono = (TextView)findViewById(R.id.tvTelefono);
        tvfechaNaciomiento = (TextView)findViewById(R.id.tvFechaNacimiento);
        btconsulta= (Button)findViewById(R.id.btConsultar);
        persona = (Persona) getIntent().getSerializableExtra("Persona");

        tvNombre.setText(persona.nombre.toString());
        tvApellidos.setText(persona.apellidos.toString());
        tvCorreo.setText(persona.correo.toString());
        tvTelefono.setText(String.valueOf(persona.telefono));
        tvfechaNaciomiento.setText(persona.fechaNac.toString());


        tvNombre.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                //inicia toas personalizado
                //toast personalizado
                Toast toasPersonalizado = new Toast(MostrarDatos.this);
                View vista = getLayoutInflater().inflate(R.layout.toaspersonalizado,
                        (ViewGroup)findViewById(R.id.linearlayout));
                TextView contenido = (TextView) vista.findViewById(R.id.textContenido);

                contenido.setText(persona.nombre.toString()+" su telefono es:"+persona.getTelefono());

                toasPersonalizado.setView(vista);
                toasPersonalizado.setGravity(Gravity.CENTER_VERTICAL,0,0);
                toasPersonalizado.setDuration(Toast.LENGTH_LONG);
                toasPersonalizado.show();
            }
        });

        btconsulta.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
            Intent intent =
                   new Intent(MostrarDatos.this,Activity_lista.class);
                startActivity(intent);
            }
        });

    }
}
