package com.chakra.weatherapp.api;

import com.chakra.weatherapp.data.WeatherInfo;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Query;

/**
 * Created by chakrapani on 10/9/17.
 *
 * WeatherApi service handles Weather Information requests
 */

public interface WeatherApi {
    /**
     * Service API token for my app
     */
    String API = "e262084167d943b74f7195227c96f176";

    @GET("data/2.5/weather")
    Call<WeatherInfo> getWeatherInfo(@Query("q") String city, @Query("APPID") String appId);
}
