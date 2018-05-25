package mx.edu.itsmt.angelus.encuesta;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

import mx.edu.itsmt.angelus.encuesta.Modelo.Pregunta;

/**
 * Created by angelus on 25/06/2017.
 */

public class Adaptador extends BaseAdapter {

    Context context;
    List<Pregunta> listaPregunta;


    public Adaptador(Context context, List<Pregunta> listaPregunta) {
        this.context = context;
        this.listaPregunta = listaPregunta;
    }

    @Override
    public int getCount() {
        return listaPregunta.size();
    }

    @Override
    public Object getItem(int position) {
        return listaPregunta.get(position);
    }

    @Override
    public long getItemId(int position) {
        return listaPregunta.get(position).getIdPregunta();
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View vista = convertView;
        LayoutInflater inflater = LayoutInflater.from(context);
        vista = inflater.inflate(R.layout.item_listview,null);
        ImageView imagen = (ImageView)vista.findViewById(R.id.imageView);
     //   TextView titulo = (TextView) vista.findViewById(R.id.txttitulo);
        TextView detalle = (TextView) vista.findViewById(R.id.txtDetalle);


        //obtener el elemento de la posicion actual
       // titulo.setText(listaPregunta.get(position).getIdPregunta());
        detalle.setText(listaPregunta.get(position).getPregunta().toString());
       //imagen estatica
        imagen.setImageResource(R.drawable.fisica);
        //imagen dinamica
        //imagen.setImageResource(listaPregunta.get(position).getImagen());
        return vista;
    }
}
