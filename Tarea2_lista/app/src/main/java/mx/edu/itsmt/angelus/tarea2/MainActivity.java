package mx.edu.itsmt.angelus.tarea2;

import android.app.DatePickerDialog;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Calendar;

public class MainActivity extends AppCompatActivity {

    EditText etNombre,etApellidos,etCorreo,etFecha;
    Spinner spGenero;
    Button btEnviar;
    String[] generos={"Masculino","Femenino"};
    String genero;
    Calendar calendar = Calendar.getInstance();
    DatePickerDialog datePickerDialog;
    Persona persona=null;
    ArrayList<Persona> listaP= new ArrayList<>();;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        etNombre = findViewById(R.id.et_nombre);
        etApellidos = findViewById(R.id.et_apellidos);
        etCorreo = findViewById(R.id.et_correo);
        etFecha = findViewById(R.id.et_fecha_nac);
        spGenero = findViewById(R.id.sp_genero);

        spGenero.setAdapter(
                new ArrayAdapter<String>(
                        this,
                        R.layout.support_simple_spinner_dropdown_item,
                        generos));

        spGenero.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int posicion, long l) {
                genero = adapterView.getItemAtPosition(posicion).toString();
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });
        etFecha.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

          int anio = calendar.get(Calendar.YEAR);
          int mes = calendar.get(Calendar.MONTH);
          int dia = calendar.get(Calendar.DAY_OF_MONTH);

          datePickerDialog =
             new DatePickerDialog(
               MainActivity.this,
               new DatePickerDialog.OnDateSetListener() {
          @Override
          public void onDateSet(DatePicker datePicker, int year, int month, int day) {
             etFecha.setText(day+"/"+(month+1)+"/"+year);
                            }
          },anio,mes,dia);
                datePickerDialog.show();

            }
        });
    }//fin de metodo Oncreate

    public  Persona cargarDatos() {
        persona = new Persona(
                etNombre.getText().toString(),
                etApellidos.getText().toString(),
                etCorreo.getText().toString(),
                genero,
                etFecha.getText().toString());
        return persona;
    }

    public ArrayList personas(Persona p) {

        listaP.add(p);
        return listaP;
    }

    public  void enviar(View v) {

       // personas(cargarDatos());
        Intent intencion = new
        Intent(MainActivity.this,Activity2.class);
        intencion.putExtra("lista",personas(cargarDatos()));
        intencion.putExtra("objeto",(Serializable) cargarDatos());
        startActivity(intencion);

    }


}
