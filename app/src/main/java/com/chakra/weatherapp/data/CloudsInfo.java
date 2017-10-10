package com.chakra.weatherapp.data;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * Created by chakrapani on 10/10/17.
 */

class CloudsInfo implements Parcelable {


    /**
     * all : 90
     */

    private int all;

    public int getAll() {
        return all;
    }

    public void setAll(int all) {
        this.all = all;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeInt(this.all);
    }

    public CloudsInfo() {
    }

    protected CloudsInfo(Parcel in) {
        this.all = in.readInt();
    }

    public static final Parcelable.Creator<CloudsInfo> CREATOR = new Parcelable.Creator<CloudsInfo>() {
        @Override
        public CloudsInfo createFromParcel(Parcel source) {
            return new CloudsInfo(source);
        }

        @Override
        public CloudsInfo[] newArray(int size) {
            return new CloudsInfo[size];
        }
    };
}
