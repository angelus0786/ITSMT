package com.example.hp.formulario;

import android.graphics.Color;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.hp.formulario.BD.OperacionesBD;

import java.sql.SQLException;
import java.util.ArrayList;

public class Activity_lista extends AppCompatActivity {

    OperacionesBD operacionesBD;
    ArrayList<Persona> lista;
    LinearLayout linear;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lista);
        try{
            lista = new ArrayList<>();
            operacionesBD = new OperacionesBD(this);
            operacionesBD.open();
            lista = operacionesBD.ListadoGeneral();
            linear = (LinearLayout)findViewById(R.id.mylinear);
            String cadena="";
            for (Persona personas: lista) {
                cadena=personas.nombre+" "+personas.apellidos;
                imprime(linear,cadena);
            }
            operacionesBD.close();
        }catch (SQLException e){
            e.printStackTrace();
        }


    }

    public  void imprime(LinearLayout linear,String texto) {
        TextView txtPersona = new TextView(this);
        txtPersona.setTextColor(Color.rgb(0,0,255));
        txtPersona.setTextSize(18);
        txtPersona.setText(texto);
        linear.addView(txtPersona);
    }
}
