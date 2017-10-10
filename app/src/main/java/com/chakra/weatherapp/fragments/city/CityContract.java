package com.chakra.weatherapp.fragments.city;

import com.chakra.weatherapp.data.WeatherInfo;
import com.chakra.weatherapp.mvp.IBasePresenter;
import com.chakra.weatherapp.mvp.IBaseView;

/**
 * Created by chakrapani on 10/9/17.
 *
 * CityContract defines contract between View and Presenter of CityFragment
 */

public interface CityContract {
    interface View extends IBaseView {
        /**
         * updateWeatherInfo will called from Presenter after Weather Info was received from service
         * @param weatherInfo weather information
         */
        void updateWeatherInfo(WeatherInfo weatherInfo);
    }

    interface Presenter extends IBasePresenter<View> {
        /**
         * queryWeatherInfo will be called from View for requesting wether info
         * @param cityName
         */
        void queryWeatherInfo(String cityName);
    }
}
