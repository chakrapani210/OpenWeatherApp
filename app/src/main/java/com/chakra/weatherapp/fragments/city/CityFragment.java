package com.chakra.weatherapp.fragments.city;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

import com.chakra.weatherapp.IUiNavigator;
import com.chakra.weatherapp.PreferenceManager;
import com.chakra.weatherapp.R;
import com.chakra.weatherapp.data.WeatherInfo;
import com.chakra.weatherapp.mvp.BaseView;
import com.chakra.weatherapp.mvp.IBasePresenter;

/**
 * Created by chakrapani on 10/9/17.
 *
 * CityFragment gives options to user to enter City name.
 */

public class CityFragment extends BaseView implements CityContract.View {
    private final CityPresenter mPresenter;
    private Button mGoButton;
    private EditText mEditCityName;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_city, container, false);
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        mGoButton = (Button) getView().findViewById(R.id.go);
        mEditCityName = (EditText) getView().findViewById(R.id.cityName);
        mEditCityName.setText(PreferenceManager.getCityName(getActivity().getApplicationContext()));
        mGoButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String cityName = mEditCityName.getText().toString();
                PreferenceManager.saveCityName(getActivity().getApplicationContext(), cityName);
                mPresenter.queryWeatherInfo(cityName);
            }
        });
    }

    public CityFragment() {
        mPresenter = new CityPresenter();
    }
    @Override
    public IBasePresenter getPresenter() {
        return mPresenter;
    }

    @Override
    public void updateWeatherInfo(WeatherInfo weatherInfo) {
        if(getActivity() instanceof IUiNavigator) {
            ((IUiNavigator)getActivity()).onViewWeatherInfo(weatherInfo);
        }
    }
}
