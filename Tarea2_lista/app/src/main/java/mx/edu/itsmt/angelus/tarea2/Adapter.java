package mx.edu.itsmt.angelus.tarea2;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by Angelus on 27/02/2018.
 */

public class Adapter extends BaseAdapter {

    Context context;
    ArrayList<Persona> listaPersonas;

    public Adapter(Context context, ArrayList<Persona> listaPersonas) {
        this.context = context;
        this.listaPersonas = listaPersonas;
    }

    @Override
    public int getCount() {
        return listaPersonas.size();
    }

    @Override
    public Object getItem(int i) {
        return listaPersonas.get(i);
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        View vista = view;
        LayoutInflater layoutInflater =
                LayoutInflater.from(context);
        vista = layoutInflater.inflate(
                R.layout.datospersona,null);

        TextView tv_nombre = vista.findViewById(R.id.tv_nombre);
        TextView tv_correo = vista.findViewById(R.id.tv_correo);

        tv_nombre.setText(listaPersonas.get(i).getNombre().toString());
        tv_correo.setText(listaPersonas.get(i).getCorreo().toString());


        return vista;
    }
}
