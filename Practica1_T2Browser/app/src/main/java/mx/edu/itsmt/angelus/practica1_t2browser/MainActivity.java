package mx.edu.itsmt.angelus.practica1_t2browser;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    EditText eText1;
    Button button1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        eText1 = findViewById(R.id.editText1);

    }

    public void ejecutar(View view) {
      Intent intencion =
         new Intent(MainActivity.this,Activity2.class);
        intencion.putExtra("direccion",eText1.getText().toString());
        startActivity(intencion);
    }
}
