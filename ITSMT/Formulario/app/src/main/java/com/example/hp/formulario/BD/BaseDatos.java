package com.example.hp.formulario.BD;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

/**
 * Created by angelus on 29/11/2017.
 */

public class BaseDatos extends SQLiteOpenHelper {

    final static String NOMBRE_BD ="practica.sqlite";
    final static String TB_PERSONA ="persona";
    final static int VERSION=1;
    final static String PERSONA="CREATE TABLE "+TB_PERSONA+
            "(codigo INTEGER PRIMARY KEY AUTOINCREMENT," +
            "nombre TEXT NOT NULL, apellido TEXT NOT NULL," +
            "correo TEXT NOT NULL, telefono TEXT NOT NULL," +
            "fechaNac TEXT NOT NULL);";

    public BaseDatos(Context context) {
        super(context, NOMBRE_BD, null, VERSION);
    }
    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(PERSONA);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        Log.w(BaseDatos.class.getName(),"Actualizando la base de datos "+
                oldVersion+" a "+newVersion);
        db.execSQL("DROP TABLE IF EXIST "+TB_PERSONA);
        onCreate(db);
    }
}
