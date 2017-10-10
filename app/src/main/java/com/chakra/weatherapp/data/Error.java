package com.chakra.weatherapp.data;

import android.text.TextUtils;

/**
 * Created by chakrapani on 10/9/17.
 *
 * Error data model holds Error code and message
 */

public class Error {

    /**
     * cod : 401
     * message : Invalid API key. Please see http://openweathermap.org/faq#error401 for more info.
     */

    private int cod;
    private String message;

    public int getCod() {
        return cod;
    }

    public void setCod(int cod) {
        this.cod = cod;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public boolean isError() {
        return !TextUtils.isEmpty(message);
    }
}
