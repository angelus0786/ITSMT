package mx.edu.itsmt.angelus.practica_httprequest2.Activities;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Toast;


import mx.edu.itsmt.angelus.practica_httprequest2.API.API;
import mx.edu.itsmt.angelus.practica_httprequest2.Models.City;
import mx.edu.itsmt.angelus.practica_httprequest2.R;
import mx.edu.itsmt.angelus.practica_httprequest2.API.APIServices.WheatherService;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {

    private final String APPKEY="153e97adcfb8508c735cd07a3b193c12";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //crear una instancia del servicio
        WheatherService service = API.getApi().create(WheatherService.class);
        //preparar pasando parametros
        Call<City> cityCall= service.getCity("London,UK", API.APPKEY);
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
