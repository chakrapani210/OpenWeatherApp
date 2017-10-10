package com.chakra.weatherapp.mvp;


import android.content.Context;

/**
 * Presenter Interface with Visibility callbacks of View
 * @param <ViewT>
 */
public interface IBasePresenter<ViewT> {

    void init();

    void onViewResume(ViewT view);

    void onViewPause();

    ViewT getView();

    boolean isViewVisible();

    Context getContext();
}
