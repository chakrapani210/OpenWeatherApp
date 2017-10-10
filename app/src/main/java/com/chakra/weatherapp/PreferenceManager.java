package com.chakra.weatherapp;

import android.content.Context;
import android.content.SharedPreferences;

/**
 * Created by chakrapani on 10/10/17.
 *
 * Utility class for managing Preferences
 */

public final class PreferenceManager {
    public static final String PREFERENCE_FILE_NAME = "preferences";

    public static final String KEY_CITY_NAME = "city_name";
    private SharedPreferences mPreferences;
    private static PreferenceManager sInstance;

    private PreferenceManager(Context context) {
        mPreferences = context.getApplicationContext()
                .getSharedPreferences(PREFERENCE_FILE_NAME, Context.MODE_PRIVATE);
    }

    public static PreferenceManager getPreferences(Context context) {
        if(sInstance == null) {
            sInstance = new PreferenceManager(context);
        }
        return sInstance;
    }

    public void put(String key, String value) {
        mPreferences.edit().putString(key, value).apply();
    }

    public String get(String key) {
        return mPreferences.getString(key, "");
    }

    public static void saveCityName(Context context, String city) {
        getPreferences(context).put(KEY_CITY_NAME, city);
    }

    public static String  getCityName(Context context) {
        return getPreferences(context).get(KEY_CITY_NAME);
    }
}
