package com.chakra.weatherapp.data;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * Created by chakrapani on 10/10/17.
 */

class SysInfo implements Parcelable {


    /**
     * type : 1
     * id : 1826
     * message : 0.0045
     * country : US
     * sunrise : 1507634235
     * sunset : 1507675500
     */

    private int type;
    private int id;
    private double message;
    private String country;
    private int sunrise;
    private int sunset;

    public int getType() {
        return type;
    }

    public int getId() {
        return id;
    }

    public double getMessage() {
        return message;
    }

    public String getCountry() {
        return country;
    }

    public int getSunrise() {
        return sunrise;
    }

    public int getSunset() {
        return sunset;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeInt(this.type);
        dest.writeInt(this.id);
        dest.writeDouble(this.message);
        dest.writeString(this.country);
        dest.writeInt(this.sunrise);
        dest.writeInt(this.sunset);
    }

    public SysInfo() {
    }

    protected SysInfo(Parcel in) {
        this.type = in.readInt();
        this.id = in.readInt();
        this.message = in.readDouble();
        this.country = in.readString();
        this.sunrise = in.readInt();
        this.sunset = in.readInt();
    }

    public static final Parcelable.Creator<SysInfo> CREATOR = new Parcelable.Creator<SysInfo>() {
        @Override
        public SysInfo createFromParcel(Parcel source) {
            return new SysInfo(source);
        }

        @Override
        public SysInfo[] newArray(int size) {
            return new SysInfo[size];
        }
    };
}
