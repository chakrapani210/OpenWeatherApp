package com.chakra.weatherapp;

import com.chakra.weatherapp.data.WeatherInfo;

/**
 * Created by chakrapani on 10/9/17.
 *
 * Interface for UI Navigation among Fragments
 */

public interface IUiNavigator {
    void onViewWeatherInfo(WeatherInfo info);
}