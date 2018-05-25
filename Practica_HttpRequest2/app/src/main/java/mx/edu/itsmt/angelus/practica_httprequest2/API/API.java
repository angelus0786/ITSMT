package mx.edu.itsmt.angelus.practica_httprequest2.API;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class API {

    public static final String BASE_URL="http://api.openweathermap.org/data/2.5/";
    private static Retrofit retrofit=null;
    public static final String APPKEY="153e97adcfb8508c735cd07a3b193c12";

    //si existe la devuelve, si no, se crea
    public static Retrofit getApi() {
        if(retrofit==null){
            retrofit = new Retrofit.Builder()
                    .baseUrl(BASE_URL)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();

        }
        return retrofit;
    }

}
