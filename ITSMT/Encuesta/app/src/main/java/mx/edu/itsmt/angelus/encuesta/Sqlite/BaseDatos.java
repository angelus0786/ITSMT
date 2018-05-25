package mx.edu.itsmt.angelus.encuesta.Sqlite;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

/**
 * Created by angelus on 24/06/2017.
 */

public class BaseDatos extends SQLiteOpenHelper{

    public static final String NOMBRE_BD = "MLiberate.db";
    public static final int VERSION = 1;
    public static final String TIPOPREGUNTA = "tipopregunta";
    public static final String PREGUNTA = "pregunta";
    public static final String RESPUESTA = "respuesta";
    public static final String TABLA_TIPOPREGUNTA =
            "CREATE TABLE "+TIPOPREGUNTA+" "+
            "(id_tipo INTEGER PRIMARY KEY AUTOINCREMENT, "+
            "tipo TEXT NOT NULL);" ;
    public static final String TABLA_PREGUNTA =
            "CREATE TABLE "+PREGUNTA+" "+
                    "(id_pregunta INTEGER PRIMARY KEY AUTOINCREMENT, "+
                    "pregunta TEXT NOT NULL, valor INTEGER NOT NULL," +
                    "id_tipo INTEGER NOT NULL);";
    public static final String TABLA_RESPUESTA =
            "CREATE TABLE "+RESPUESTA+" "+
                    "(id_respuesta INTEGER PRIMARY KEY AUTOINCREMENT, "+
                    "id_pregunta INTEGER NOT NULL,respuesta INTEGER NOT NULL);" ;

    public BaseDatos(Context context) {
        super(context, NOMBRE_BD, null, VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(TABLA_TIPOPREGUNTA);
        db.execSQL(TABLA_PREGUNTA);
        db.execSQL(TABLA_RESPUESTA);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        Log.w(BaseDatos.class.getName(), "Actualizando la Version de BD" +
                oldVersion + " a " + newVersion);
        db.execSQL("DROP TABLE IS EXISTS TIPOPREGUNTA");
        db.execSQL("DROP TABLE IS EXISTS PREGUNTA");
        db.execSQL("DROP TABLE IS EXISTS RESPUESTA");
        onCreate(db);
    }
}
