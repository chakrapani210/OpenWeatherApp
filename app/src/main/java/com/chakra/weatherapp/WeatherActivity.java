package com.chakra.weatherapp;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.FrameLayout;

import com.chakra.weatherapp.data.WeatherInfo;
import com.chakra.weatherapp.fragments.city.CityFragment;
import com.chakra.weatherapp.fragments.weatherinfo.WeatherInfoFragment;
import com.chakra.weatherapp.util.NetworkHelper;

import static android.net.ConnectivityManager.CONNECTIVITY_ACTION;

/**
 *  Main Launcher activity
 */
public class WeatherActivity extends AppCompatActivity implements IUiNavigator {

    private static final String TAG = WeatherActivity.class.getSimpleName();
    private FrameLayout mContainer;
    private IntentFilter connectivityIntentFilter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_weather);
        mContainer = (FrameLayout) findViewById(R.id.main_container);

        init(savedInstanceState);
        connectivityIntentFilter = new IntentFilter(CONNECTIVITY_ACTION);
    }


    @Override
    protected void onResume() {
        super.onResume();
        registerReceiver(connectivityBroadcastReceiver, connectivityIntentFilter);
    }

    @Override
    protected void onPause() {
        unregisterReceiver(connectivityBroadcastReceiver);
        super.onPause();
    }


    BroadcastReceiver connectivityBroadcastReceiver = new BroadcastReceiver() {
        @Override
        public void onReceive(Context context, Intent intent) {
            if (!NetworkHelper.getInstance().isNetworkAvailable(context)) {
                new ErrorHandler(WeatherActivity.this).handleNetworkError();
            }
        }
    };

    private void init(Bundle savedInstanceState) {
        if(savedInstanceState == null) {
            CityFragment fragment = new CityFragment();
            getSupportFragmentManager().beginTransaction().replace(R.id.main_container, fragment)
                    .addToBackStack(null).commit();
        }
    }

    @Override
    public void onViewWeatherInfo(WeatherInfo info) {
        Fragment fragment = WeatherInfoFragment.getInstance(info);
        replaceFragment(fragment);
    }

    private void replaceFragment(Fragment fragment) {
        getSupportFragmentManager().beginTransaction().replace(R.id.main_container, fragment)
                .addToBackStack(null).commit();
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        if(getSupportFragmentManager().findFragmentById(R.id.main_container) == null) {
            finish();
        }
    }
}
