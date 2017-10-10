package com.chakra.weatherapp.data;

import android.os.Parcel;
import android.os.Parcelable;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by chakrapani on 10/9/17.
 *
 * Weather Information Model class
 */

public class WeatherInfo extends Error implements Parcelable {

    /**
     * coord : {"lon":-78.64,"lat":35.77}
     * weather : [{"id":804,"main":"Clouds","description":"overcast clouds","icon":"04n"}]
     * base : stations
     * main : {"temp":297.37,"pressure":1018,"humidity":94,"temp_min":296.15,"temp_max":298.15}
     * visibility : 11265
     * wind : {"speed":3.6,"deg":210}
     * clouds : {"all":90}
     * dt : 1507609800
     * sys : {"type":1,"id":1826,"message":0.0045,"country":"US","sunrise":1507634235,"sunset":1507675500}
     * id : 4487042
     * name : Raleigh
     */

    private MainInfo main;
    private WindInfo wind;
    private CloudsInfo clouds;
    private SysInfo sys;
    private String name;
    private List<WeatherDataInfo> weather;

    public MainInfo getMain() {
        return main;
    }

    public WindInfo getWind() {
        return wind;
    }

    public CloudsInfo getClouds() {
        return clouds;
    }

    public SysInfo getSys() {
        return sys;
    }

    public String getName() {
        return name;
    }

    public List<WeatherDataInfo> getWeather() {
        return weather;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeParcelable(this.main, flags);
        dest.writeParcelable(this.wind, flags);
        dest.writeParcelable(this.clouds, flags);
        dest.writeParcelable(this.sys, flags);
        dest.writeString(this.name);
        dest.writeList(this.weather);
    }

    public WeatherInfo() {
    }

    protected WeatherInfo(Parcel in) {
        this.main = in.readParcelable(MainInfo.class.getClassLoader());
        this.wind = in.readParcelable(WindInfo.class.getClassLoader());
        this.clouds = in.readParcelable(CloudsInfo.class.getClassLoader());
        this.sys = in.readParcelable(SysInfo.class.getClassLoader());
        this.name = in.readString();
        this.weather = new ArrayList<WeatherDataInfo>();
        in.readList(this.weather, WeatherInfo.class.getClassLoader());
    }

    public static final Parcelable.Creator<WeatherInfo> CREATOR = new Parcelable.Creator<WeatherInfo>() {
        @Override
        public WeatherInfo createFromParcel(Parcel source) {
            return new WeatherInfo(source);
        }

        @Override
        public WeatherInfo[] newArray(int size) {
            return new WeatherInfo[size];
        }
    };

    @Override
    public String toString() {
        return "WeatherInfo{" +
                "main=" + main +
                ", wind=" + wind +
                ", clouds=" + clouds +
                ", sys=" + sys +
                ", name='" + name + '\'' +
                ", weather=" + weather +
                '}';
    }
}
