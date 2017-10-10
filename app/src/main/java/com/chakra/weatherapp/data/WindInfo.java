package com.chakra.weatherapp.data;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * Created by chakrapani on 10/10/17.
 */

class WindInfo implements Parcelable {


    /**
     * speed : 3.6
     * deg : 210
     */

    private double speed;
    private double deg;

    public double getSpeed() {
        return speed;
    }

    public double getDeg() {
        return deg;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeDouble(this.speed);
        dest.writeDouble(this.deg);
    }

    public WindInfo() {
    }

    protected WindInfo(Parcel in) {
        this.speed = in.readDouble();
        this.deg = in.readDouble();
    }

    public static final Creator<WindInfo> CREATOR = new Creator<WindInfo>() {
        @Override
        public WindInfo createFromParcel(Parcel source) {
            return new WindInfo(source);
        }

        @Override
        public WindInfo[] newArray(int size) {
            return new WindInfo[size];
        }
    };
}
