package com.chakra.weatherapp.data;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.SerializedName;

/**
 * Created by chakrapani on 10/10/17.
 */

public class MainInfo implements Parcelable {


    /**
     * temp : 297.37
     * pressure : 1018
     * humidity : 94
     * temp_min : 296.15
     * temp_max : 298.15
     */

    private double temp;
    private double pressure;
    private int humidity;

    @SerializedName("temp_min")
    private double tempMin;

    @SerializedName("temp_max")
    private double tempMax;

    public double getTemp() {
        return temp;
    }

    public double getPressure() {
        return pressure;
    }

    public int getHumidity() {
        return humidity;
    }


    public double getTempMin() {
        return tempMin;
    }

    public double getTempMax() {
        return tempMax;
    }


    @Override
    public String toString() {
        return "MainInfo{" +
                "temp=" + temp +
                ", pressure=" + pressure +
                ", humidity=" + humidity +
                ", temp_min=" + tempMin +
                ", temp_max=" + tempMax +
                '}';
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeDouble(this.temp);
        dest.writeDouble(this.pressure);
        dest.writeInt(this.humidity);
        dest.writeDouble(this.tempMin);
        dest.writeDouble(this.tempMax);
    }

    public MainInfo() {
    }

    protected MainInfo(Parcel in) {
        this.temp = in.readDouble();
        this.pressure = in.readDouble();
        this.humidity = in.readInt();
        this.tempMin = in.readDouble();
        this.tempMax = in.readDouble();
    }

    public static final Creator<MainInfo> CREATOR = new Creator<MainInfo>() {
        @Override
        public MainInfo createFromParcel(Parcel source) {
            return new MainInfo(source);
        }

        @Override
        public MainInfo[] newArray(int size) {
            return new MainInfo[size];
        }
    };
}
