package com.example.hp.formulario;

import android.app.DatePickerDialog;
import android.content.Intent;
import android.icu.util.Calendar;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.Toast;

import com.example.hp.formulario.BD.OperacionesBD;

import java.sql.SQLException;
import java.util.Date;

public class MainActivity extends AppCompatActivity {

    EditText edNombre,edApellidos,edCorreo,edTelefono,edFechaNaciomiento;
    Button btnEnviar;
    String nombre,apellidos,correo,fechaNac;
    int telefono;
    Persona persona;
    private OperacionesBD objetoPersona;
    private Calendar calendar= Calendar.getInstance();

    public MainActivity() {
        objetoPersona = new OperacionesBD(this);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        edNombre = (EditText)findViewById(R.id.txtNombre);
        edApellidos = (EditText)findViewById(R.id.txtApellidos);
        edCorreo = (EditText)findViewById(R.id.txtCorreo);
        edTelefono = (EditText)findViewById(R.id.txtTelefono);
        edFechaNaciomiento = (EditText)findViewById(R.id.txtFechaNacimiento);
        btnEnviar = (Button)findViewById(R.id.btnEnviar);

        btnEnviar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //Aqui se implementara el registro de los datos
                try{
                    long i = 0;
                    objetoPersona.open();
                    i = objetoPersona.insertar( obtenerDatos());
                    if (i==0){
                        Toast.makeText(getApplicationContext(),"Registro No Insertado",
                                Toast.LENGTH_SHORT).show();
                    }else{
                        Toast.makeText(getApplicationContext(),"Registro Insertado",
                                Toast.LENGTH_SHORT).show();
                        Intent intent = new Intent(MainActivity.this,MostrarDatos.class);
                        intent.putExtra("Persona",persona);
                        startActivity(intent);
                    }
                }catch (SQLException e){
                    e.printStackTrace();
                }
            }
        });

        //accion de la caja de texto telefon
        edFechaNaciomiento.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Date fecha = new Date();
                calendar.setTime(fecha);
                int anio = calendar.get(Calendar.YEAR);
                int mes = calendar.get(Calendar.MONTH);
                int dia = calendar.get(Calendar.DAY_OF_MONTH);

               DatePickerDialog f =
                 new DatePickerDialog(MainActivity.this,
                         new DatePickerDialog.OnDateSetListener() {
                    @Override
                    public void onDateSet(DatePicker datePicker,
                                          int year, int month, int day) {
                        edFechaNaciomiento.setText(""+day+"/"+(month+1)+"/"+year);
                    }
                },anio,mes,dia);
                f.show();

            }
        });
    }

    public Persona obtenerDatos (){
        nombre = edNombre.getText().toString();
        apellidos = edApellidos.getText().toString();
        correo = edCorreo.getText().toString();
        telefono = Integer.parseInt(edTelefono.getText().toString());
        fechaNac = edFechaNaciomiento.getText().toString();
        persona = new Persona(nombre,apellidos,correo,telefono,fechaNac);
        return persona;
    }
}
