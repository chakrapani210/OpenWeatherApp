package com.chakra.weatherapp.data;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * Created by chakrapani on 10/10/17.
 */

public class WeatherDataInfo implements Parcelable {

    public static final String BASE_ICON_URL = "http://openweathermap.org/img/w/#.png";

    /**
     * id : 804
     * main : Clouds
     * description : overcast clouds
     * icon : 04n
     */

    private int id;
    private String main;
    private String description;
    private String icon;

    public int getId() {
        return id;
    }

    public String getMain() {
        return main;
    }

    public String getDescription() {
        return description;
    }

    public String getIcon() {
        return BASE_ICON_URL.replace("#", icon);
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeInt(this.id);
        dest.writeString(this.main);
        dest.writeString(this.description);
        dest.writeString(this.icon);
    }

    public WeatherDataInfo() {
    }

    protected WeatherDataInfo(Parcel in) {
        this.id = in.readInt();
        this.main = in.readString();
        this.description = in.readString();
        this.icon = in.readString();
    }

    public static final Parcelable.Creator<WeatherDataInfo> CREATOR = new Parcelable.Creator<WeatherDataInfo>() {
        @Override
        public WeatherDataInfo createFromParcel(Parcel source) {
            return new WeatherDataInfo(source);
        }

        @Override
        public WeatherDataInfo[] newArray(int size) {
            return new WeatherDataInfo[size];
        }
    };
}
