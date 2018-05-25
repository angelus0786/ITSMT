package mx.edu.itsmt.angelus.practica_httprequest2.API.APIServices;

import mx.edu.itsmt.angelus.practica_httprequest2.Models.City;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface WheatherService {

 //   http://forecast?q=M%C3%BCnchen,DE&appid=153e97adcfb8508c735cd07a3b193c12
    @GET("weather") //url
    Call<City> getCity(@Query("q") String city, @Query("appid") String key);
}
