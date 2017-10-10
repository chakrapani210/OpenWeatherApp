package com.chakra.weatherapp.mvp;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.View;
import android.widget.ProgressBar;

import com.chakra.weatherapp.R;

/**
 * Gives basic implementation to View interface. It send visibility callbacks to presenter
 */
public abstract class BaseView extends Fragment implements IBaseView {

    protected ProgressBar progressBar;

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        progressBar = (ProgressBar) view.findViewById(R.id.progressBar);
        if (progressBar != null) {
            progressBar.setVisibility(View.GONE);
        }
    }

    @Override
    public void showProgressBar(boolean show) {
        if(progressBar != null) {
            if (show) {
                progressBar.setVisibility(View.VISIBLE);
            } else {
                progressBar.setVisibility(View.GONE);
            }
        }
    }

    @Override
    public void onPause() {
        if (getPresenter() != null) {
            getPresenter().onViewPause();
        }
        super.onPause();
    }

    @Override
    public void onResume() {
        super.onResume();
        if (getPresenter() != null) {
            getPresenter().onViewResume(this);
        }
    }

}
