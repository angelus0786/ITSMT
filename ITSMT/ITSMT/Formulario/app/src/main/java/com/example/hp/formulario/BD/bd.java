package com.example.hp.formulario.BD;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

/**
 * Created by angelus on 30/11/2017.
 */

public class bd extends SQLiteOpenHelper {

    final static String NOMBREBD="PRACTICA.SQLITE";
    final static String TB_PERSONA="PERSONA";
    final static int VERSION=1;
    final static String SQL_PERSONA="CREATE TABLE "+TB_PERSONA+
            "(codigo INTEGER PRIMARY KEY AUTOINCREMENT," +
            "nombre TEXT NOT NULL, apellido TEXT NOT NULL," +
            "correo TEXT NOT NULL, telefono TEXT NOT NULL," +
            "fechaNac TEXT NOT NULL);";

    public bd(Context context) {
        super(context, NOMBREBD, null, VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(SQL_PERSONA);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

        Log.w(bd.class.getName(),"Actualizando la base de datos "+
                oldVersion+" a "+newVersion);
        db.execSQL("DROP TABLE IF EXIST "+TB_PERSONA);
        onCreate(db);
    }
}
