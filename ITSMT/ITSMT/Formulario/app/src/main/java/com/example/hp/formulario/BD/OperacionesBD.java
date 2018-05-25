package com.example.hp.formulario.BD;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import com.example.hp.formulario.Persona;

import java.sql.SQLException;
import java.util.ArrayList;

/**
 * Created by angelus on 29/11/2017.
 */

public class OperacionesBD {

    private SQLiteDatabase database;
    private SQLiteOpenHelper dbHelper;

    public OperacionesBD(Context context) {

        dbHelper = new BaseDatos(context);
    }
    public void open() throws SQLException{
        database = dbHelper.getWritableDatabase();
    }
    public void close(){
        dbHelper.close();
    }

    public long insertar(Persona p){
        long estado =0;
        try {
            ContentValues valores = new ContentValues();
            valores.put("nombre",p.getNombre());
            valores.put("apellido",p.getApellidos());
            valores.put("correo",p.getCorreo());
            valores.put("telefono",p.getTelefono());
            valores.put("fechaNac",p.getFechaNac());
            estado = database.insert(BaseDatos.TB_PERSONA,null,valores);
        }catch (Exception e){
            estado=0;
        }
        return estado;
    }
     //consultar
    public ArrayList<Persona> ListadoGeneral(){
        Cursor cursor;
        ArrayList<Persona> listado = new ArrayList<>();
        cursor = database.rawQuery("SELECT * FROM persona ",null);
      //  System.out.println("cursor"+cursor);
        while (cursor.moveToNext()){
            Persona objetoPersona = new Persona();
            objetoPersona.setNombre(cursor.getString(1));
            objetoPersona.setApellidos(cursor.getString(2));
            objetoPersona.setCorreo(cursor.getString(3));
            objetoPersona.setTelefono(cursor.getInt(4));
            objetoPersona.setFechaNac(cursor.getString(5));
            listado.add(objetoPersona);
        }
        cursor.close();
        return listado;
    }
}
