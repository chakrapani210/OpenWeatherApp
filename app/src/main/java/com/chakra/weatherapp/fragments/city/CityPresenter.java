package com.chakra.weatherapp.fragments.city;

import android.text.TextUtils;
import android.util.Log;

import com.chakra.weatherapp.ErrorHandler;
import com.chakra.weatherapp.api.WeatherApi;
import com.chakra.weatherapp.data.WeatherInfo;
import com.chakra.weatherapp.mvp.BasePresenter;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;


/**
 * Created by chakrapani on 10/9/17.
 */

public class CityPresenter extends BasePresenter<CityContract.View> implements CityContract.Presenter {
    private static final String TAG = CityPresenter.class.getSimpleName();
    public static final String BASE_URL = "http://api.openweathermap.org";
    private WeatherApi weatherApi;
    @Override
    public void init() {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        weatherApi = retrofit.create(WeatherApi.class);
    }

    @Override
    public void queryWeatherInfo(String cityName) {
        if(cityName == null || cityName.trim().length() == 0) {
            return;
        }
        getView().showProgressBar(true);
        Call<WeatherInfo> call = weatherApi.getWeatherInfo(cityName, WeatherApi.API);
        call.enqueue(new Callback<WeatherInfo>() {
            @Override
            public void onResponse(Call<WeatherInfo> call, Response<WeatherInfo> response) {
                if(isViewVisible()) {
                    if(response.isSuccessful()) {
                        if(response.body().isError()) {
                            new ErrorHandler(getContext()).handleError(response.body());
                        } else {
                            getView().updateWeatherInfo(response.body());
                        }
                    } else {
                        new ErrorHandler(getContext()).handleError(getContext(), response);
                    }
                    getView().showProgressBar(false);
                }
            }

            @Override
            public void onFailure(Call<WeatherInfo> call, Throwable t) {
                Log.e(TAG, "Exception while quering for City weather info", t);
                if(isViewVisible()) {
                    getView().showProgressBar(false);

                    new ErrorHandler(getContext()).handleError("Something went wrong... !!!");
                }
            }
        });
    }
}
