package mx.edu.itsmt.angelus.audiolibros1;

import java.io.Serializable;
import java.util.Vector;

/**
 * Created by angelus on 14/02/2017.
 */
public class Libro implements Serializable {

    public String titulo;
    public String autor;
    public int recursoImagen;
    public String urlAudio;
    public String genero;
    public Boolean novedad;
    public Boolean leido;
    public final static String G_TODOS="Todos los generos";
    public final static String G_EPICOS="Poema épico";
    public final static String G_S_XIX="Literatura siglo XIX";
    public final static String G_SUSPENSE="Suspenso";
    public final static String[] G_ARRAY = new String[]{G_TODOS,G_EPICOS,G_S_XIX,G_SUSPENSE};

    public Libro(String titulo, String autor, int recursoImagen, String urlAudio, String genero, Boolean novedad, Boolean leido) {
        this.titulo = titulo;
        this.autor = autor;
        this.recursoImagen = recursoImagen;
        this.urlAudio = urlAudio;
        this.genero = genero;
        this.novedad = novedad;
        this.leido = leido;
    }
    public static Vector<Libro> ejemploLibros(){
        final String SERVIDOR = "http://www.dcomg.upv.es/~jtomas/android/audiolibros/";
        Vector<Libro> libros = new Vector<Libro>();
        libros.add(new Libro("Kappa","Akutagawa",R.drawable.kappa,SERVIDOR+"kappa.mp3",Libro.G_S_XIX,false,false));
        libros.add(new Libro("Avecilla","Alas Clarin, Leopoldo",R.drawable.avecilla,SERVIDOR+"avecilla.mp3",
                Libro.G_S_XIX,false,false));
        libros.add(new Libro("Divina Comedia","Dante",R.drawable.divinacomedia,SERVIDOR+"divina_comedia.mp3",
                Libro.G_EPICOS,false,false));
        libros.add(new Libro("Viejo Pancho, El","Alonso y trelles, josé",R.drawable.viejo_pancho,SERVIDOR+"Viejo_Pancho.mp3",
                Libro.G_S_XIX,false,false));
        libros.add(new Libro("Cancion de Rolando","Akutagawa",R.drawable.cancion_rolando,SERVIDOR+"cancion_rolando.mp3",
                Libro.G_EPICOS,false,false));
        libros.add(new Libro("Matrimonio de Sabuesos","Agata Christie",R.drawable.matrimonio_sabuesos,SERVIDOR+"matrim_sabuesos.mp3",
                Libro.G_SUSPENSE,false,false));
        libros.add(new Libro("Iliada","Homero",R.drawable.iliada,SERVIDOR+"la_iliada.mp3",Libro.G_EPICOS,false,false));
        return libros;
    }
}
