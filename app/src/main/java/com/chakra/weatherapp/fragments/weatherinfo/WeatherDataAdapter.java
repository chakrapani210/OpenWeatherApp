package com.chakra.weatherapp.fragments.weatherinfo;

import android.app.Activity;
import android.support.v4.app.FragmentActivity;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.chakra.weatherapp.R;
import com.chakra.weatherapp.data.WeatherDataInfo;

import java.util.List;

/**
 * Created by chakrapani on 10/10/17.
 */

class WeatherDataAdapter extends RecyclerView.Adapter<ViewHolder> {

    private List<WeatherDataInfo> mWeatherData;
    private Activity mContext; // Needed Activity to take advantage of Glide features

    public WeatherDataAdapter(List<WeatherDataInfo> weatherData, Activity mContext) {
        this.mWeatherData = weatherData;
        this.mContext = mContext;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(mContext).inflate(R.layout.weather_list_item, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(final ViewHolder holder, final int position) {
        WeatherDataInfo info = mWeatherData.get(position);
        Glide.with(mContext)
                .load(info.getIcon())
                .into(holder.imageView);
        holder.descTextView.setText(info.getDescription());
    }

    @Override
    public int getItemCount() {
        return mWeatherData != null ? mWeatherData.size() : 0;
    }


    public void updateList(List<WeatherDataInfo> listData) {
        mWeatherData = listData;
        notifyDataSetChanged();
    }
}


class ViewHolder extends RecyclerView.ViewHolder {
    public ImageView imageView;
    public TextView descTextView;
    public ViewHolder(View itemView) {
        super(itemView);
        imageView = (ImageView) itemView.findViewById(R.id.imageView);
        descTextView = (TextView) itemView.findViewById(R.id.description);
    }
}
