package mx.edu.itsmt.angelus.encuesta.Sqlite;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.ArrayList;

import mx.edu.itsmt.angelus.encuesta.Modelo.Pregunta;

/**
 * Created by angelus on 24/06/2017.
 */

public class OperacionesBD {

    private SQLiteDatabase database;
    private SQLiteOpenHelper dbHelper;

    public OperacionesBD(Context context) {
        dbHelper =  new BaseDatos(context);
    }

    public void open() throws SQLException {
        database = dbHelper.getWritableDatabase();
    }
    public void close(){
        dbHelper.close();
    }

    //[INSERTAR]
    public long insertarTipoPregunta(int id, String tipo){
        long estado =0;
        try {
            ContentValues valores = new ContentValues();
            valores.put("id_tipo",id);
            valores.put("tipo",tipo);
            estado = database.insert(BaseDatos.TIPOPREGUNTA,null,valores);
            System.out.println(estado);
        }catch (Exception e){
            estado=0;
            e.printStackTrace();
        }
        return estado;
    }
    public long insertarPregunta(int id, String pregunta,int valor,int idTipo){
        long estado =0;
        try {
            ContentValues valores = new ContentValues();
            valores.put("id_pregunta",id);
            valores.put("pregunta",pregunta);
            valores.put("valor",valor);
            valores.put("id_tipo",idTipo);
            estado = database.insert(BaseDatos.PREGUNTA,null,valores);
        }catch (Exception e){
            estado=0;
            e.printStackTrace();
        }
        return estado;
    }
    public long insertarRespuesta(int id, int idPregunta,int respuesta){
        long estado =0;
        try {
            ContentValues valores = new ContentValues();
            valores.put("id_respuesta",id);
            valores.put("id_pregunta",idPregunta);
            valores.put("respuesta",respuesta);
            estado = database.insert(BaseDatos.RESPUESTA,null,valores);
        }catch (Exception e){
            estado=0;
        }
        return estado;
    }

    public ArrayList<Pregunta> ListadoPreguntas(){
        Cursor cursor;
        ArrayList<Pregunta> listado = new ArrayList<>();
        open();
        cursor = database.rawQuery("select id_pregunta,pregunta,tipo from Pregunta natural join tipopregunta;",null);
        while (cursor.moveToNext()){
            Pregunta objetoPregunta = new Pregunta();
            objetoPregunta.setIdPregunta(cursor.getInt(0));
            objetoPregunta.setPregunta(cursor.getString(1));
            objetoPregunta.setImg(cursor.getString(2));
            listado.add(objetoPregunta);
        }
        cursor.close();
        return listado;
    }

    public Cursor ListaPregunta(){
       open();
       Cursor c = database.rawQuery("select id_pregunta,pregunta,id_tipo from Pregunta natural join tipopregunta",null);
        return c;
    }
}
