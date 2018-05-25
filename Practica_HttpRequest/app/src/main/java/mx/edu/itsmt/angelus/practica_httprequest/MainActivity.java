package mx.edu.itsmt.angelus.practica_httprequest;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Toast;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import org.json.JSONException;
import org.json.JSONObject;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("http://api.openweathermap.org/data/2.5/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        //crear una instancia del servicio
        WheatherService service = retrofit.create(WheatherService.class);
       //preparar pasando parametros
       Call<City> cityCall= service.getCity("London,UK","153e97adcfb8508c735cd07a3b193c12");
       cityCall.enqueue(new Callback<City>() {
           @Override
           public void onResponse(Call<City> call, Response<City> response) {
               City city = response.body();
           }

           @Override
           public void onFailure(Call<City> call, Throwable t) {
            Toast.makeText(MainActivity.this,"Error",Toast.LENGTH_LONG).show();
           }
       });


    }
}
