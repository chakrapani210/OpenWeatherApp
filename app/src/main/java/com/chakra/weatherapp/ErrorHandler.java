package com.chakra.weatherapp;

import android.app.AlertDialog;
import android.content.Context;
import android.util.Log;

import com.chakra.weatherapp.data.Error;
import com.chakra.weatherapp.data.WeatherInfo;
import com.chakra.weatherapp.fragments.city.CityPresenter;
import com.google.gson.Gson;

import java.io.IOException;

import retrofit2.Response;

/**
 * Created by chakrapani on 10/9/17.
 *
 * This class handles Errors and shows error messages to User through Simple Dialogs
 */

public class ErrorHandler {
    private static final String TAG = ErrorHandler.class.getSimpleName();
    private Context mContext;

    public ErrorHandler(Context mContext) {
        this.mContext = mContext;
    }

    public boolean handleError(String error) {
        AlertDialog.Builder builder = new AlertDialog.Builder(mContext);
        builder.setTitle(R.string.error_title).setMessage(error)
                .setNeutralButton(R.string.ok, null);
        builder.create().show();
        return true;
    }

    public void handleNetworkError() {
        handleError(mContext.getString(R.string.internet_unavailable));
    }

    public void handleError(Context context, Response<WeatherInfo> response) {
        // To do: Should handle better Error Object conversion
        try {
            String msg = response.errorBody().string();
            Gson gson = new Gson();
            Error error = gson.fromJson(msg, Error.class);
            handleError(error.getMessage());
        } catch (IOException e) {
            Log.e(TAG, "Exception: ", e);
            handleError("Something went wrong... !!!");
        }
    }

    public void handleError(Error error) {
        handleError(error.getMessage());
    }
}
