package com.chakra.weatherapp.mvp;


import android.content.Context;

/**
 * View Interface defines Basic view operations
 */
public interface IBaseView {

    void showProgressBar(boolean show);

    Context getContext();

    IBasePresenter getPresenter();
}
