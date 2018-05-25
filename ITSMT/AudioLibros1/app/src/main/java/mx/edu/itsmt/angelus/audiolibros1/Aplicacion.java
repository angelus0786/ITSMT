package mx.edu.itsmt.angelus.audiolibros1;
import android.app.Application;
import java.util.Vector;

/**
 * Created by angelus on 14/02/2017.
 */
public class Aplicacion extends Application {
    private Vector<Libro> vectorLibros;
    private AdaptadorLibros adaptador;

    @Override
    public void onCreate() {
        super.onCreate();
        vectorLibros = Libro.ejemploLibros();
        adaptador = new AdaptadorLibros(this, vectorLibros);
    }
    public AdaptadorLibros getAdaptador(){
        return adaptador;
    }

    public Vector<Libro> getVectorLibros() {
        return vectorLibros;
    }
}
