package com.chakra.weatherapp.fragments.weatherinfo;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.chakra.weatherapp.R;
import com.chakra.weatherapp.data.MainInfo;
import com.chakra.weatherapp.data.WeatherInfo;
import com.chakra.weatherapp.mvp.BaseView;
import com.chakra.weatherapp.mvp.IBasePresenter;

/**
 * Created by chakrapani on 10/9/17.
 *
 * WeatherInfoFragment displays Weather Information to City. It shows Temperature, Humidity, Pressure etc.
 */

public class WeatherInfoFragment extends BaseView {

    private static final String ARG_WEATHER_INFO = "weather_info";
    private WeatherInfo weatherInfo;
    private RecyclerView mListView;
    private WeatherDataAdapter mAdapter;

    public static Fragment getInstance(WeatherInfo info) {
        WeatherInfoFragment fragment = new WeatherInfoFragment();
        Bundle data = new Bundle();
        data.putParcelable(ARG_WEATHER_INFO, info);
        fragment.setArguments(data);
        return fragment;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if(getArguments() != null) {
            weatherInfo = getArguments().getParcelable(ARG_WEATHER_INFO);
        } else if (savedInstanceState != null) {
            weatherInfo = savedInstanceState.getParcelable(ARG_WEATHER_INFO);
        }
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_weather_info, container, false);
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        View view = getView();
        ((TextView)view.findViewById(R.id.cityName)).setText(weatherInfo.getName());
        MainInfo main = weatherInfo.getMain();
        if(main != null) {
            ((TextView)view.findViewById(R.id.temp)).setText(main.getTemp()
                    + " ( Min. Temp: " + main.getTempMin() + ", Max. Temp: " + main.getTempMax() +" )");
            ((TextView)view.findViewById(R.id.humidity)).setText(Integer.toString(main.getHumidity()));
            ((TextView)view.findViewById(R.id.pressure)).setText(Double.toString(main.getPressure()));

        }
        mListView = (RecyclerView) view.findViewById(R.id.listView);
        mListView.setLayoutManager(new LinearLayoutManager(getActivity()));
        mAdapter = new WeatherDataAdapter(weatherInfo.getWeather(), getActivity());
        DividerItemDecoration decorator = new DividerItemDecoration(getActivity(), DividerItemDecoration.VERTICAL);
        decorator.setDrawable(getActivity().getResources().getDrawable(R.drawable.devider));
        mListView.addItemDecoration(decorator);

        mListView.setAdapter(mAdapter);
    }

    @Override
    public IBasePresenter getPresenter() {
        return null;
    }

}
