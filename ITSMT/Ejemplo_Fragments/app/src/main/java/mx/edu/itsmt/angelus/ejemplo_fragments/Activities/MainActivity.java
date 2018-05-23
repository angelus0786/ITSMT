package mx.edu.itsmt.angelus.ejemplo_fragments.Activities;

import android.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import mx.edu.itsmt.angelus.ejemplo_fragments.Fragments.DataFragment;
import mx.edu.itsmt.angelus.ejemplo_fragments.Fragments.DetailsFragment;
import mx.edu.itsmt.angelus.ejemplo_fragments.R;

public class MainActivity extends FragmentActivity implements DataFragment.DataListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }


    @Override
    public void sendData(String data) {
     DetailsFragment detailsFragment =
     (DetailsFragment)getSupportFragmentManager().
             findFragmentById(R.id.detailsFragment);
     detailsFragment.renderText(data);
    }
}
