package mx.edu.itsmt.angelus.audiolibros1;

import android.app.Activity;
import android.graphics.drawable.Drawable;
import android.media.Image;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

public class MostrarLibro extends Activity {

    ImageView image;
    TextView titulo;
    TextView autor;
    TextView genero;
    TextView audio;
    Libro libro;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mostrar_libro);

        image = (ImageView)findViewById(R.id.imagen);
        titulo = (TextView)findViewById(R.id.titulo);
        autor = (TextView)findViewById(R.id.autor);
        genero = (TextView)findViewById(R.id.genero);
        audio = (TextView)findViewById(R.id.audio);

        libro = (Libro) getIntent().getSerializableExtra("libro");
        image.setImageResource(libro.recursoImagen);
        titulo.setText(libro.titulo.toString());
        autor.setText(libro.autor.toString());
        autor.setText(libro.autor.toString());
        genero.setText(libro.genero.toString());
        audio.setText(libro.urlAudio.toString());
    }
}
