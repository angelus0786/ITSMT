package mx.edu.itsmt.angelus.practica_shared_preference;

import android.content.Context;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    EditText ed1,ed2,ed3;
    Button b1;

    public static final String MyPREFERENCES = "MyPrefs" ;
    public static final String Name = "nameKey";
    public static final String Phone = "phoneKey";
    public static final String Email = "emailKey";

    SharedPreferences sharedpreferences;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ed1=(EditText)findViewById(R.id.editText);
        ed2=(EditText)findViewById(R.id.editText2);
        ed3=(EditText)findViewById(R.id.editText3);

        b1=(Button)findViewById(R.id.button);

        sharedpreferences = getSharedPreferences(MyPREFERENCES, Context.MODE_PRIVATE);

        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String nombre   = ed1.getText().toString();
                String telefono  = ed2.getText().toString();
                String correo   = ed3.getText().toString();

                //almacenar datos en sharedPreference
                SharedPreferences.Editor editor = sharedpreferences.edit();
                    editor.putString(Name, nombre);
                    editor.putString(Phone, telefono);
                    editor.putString(Email, correo);
                    editor.apply();
                Toast.makeText(MainActivity.this,"Gracias: " + nombre,Toast.LENGTH_LONG).show();
                String nom  = sharedpreferences.getString("nameKey","");
                Toast.makeText(MainActivity.this,"Gracias: " + nom,Toast.LENGTH_LONG).show();
            }
        });
    }

    public void loadPreferences(){

        sharedpreferences = getSharedPreferences(MyPREFERENCES, Context.MODE_PRIVATE);

        String nombre    = sharedpreferences.getString("nameKey","");
        String telefono  = sharedpreferences.getString("phoneKey","");
        String correo    = sharedpreferences.getString("emailKey","");

        ed1=(EditText)findViewById(R.id.editText);
        ed2=(EditText)findViewById(R.id.editText2);
        ed3=(EditText)findViewById(R.id.editText3);

        ed1.setText(nombre);
        ed2.setText(telefono);
        ed3.setText(correo);

        Toast.makeText(MainActivity.this,"Nombre: " + nombre, Toast.LENGTH_LONG).show();
    }

    @Override
    protected void onPostResume() {
        super.onPostResume();
        loadPreferences();
    }
}
