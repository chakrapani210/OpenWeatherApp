package com.chakra.weatherapp.mvp;

import android.content.Context;

/**
 * Gives basic implementation to Presenter interface. It gets visibility callbacks from View
 * @param <ViewT>
 */
public abstract class BasePresenter<ViewT extends IBaseView> implements IBasePresenter<ViewT> {

    protected ViewT view;

    public BasePresenter() {
        init();
    }

    @Override
    public void onViewResume(ViewT view) {
        this.view = view;
    }

    @Override
    public void onViewPause() {
        view = null;
    }

    @Override
    public ViewT getView() {
        return view;
    }

    @Override
    public boolean isViewVisible() {
        return view != null;
    }

    @Override
    public Context getContext() {
        if(isViewVisible()) {
            return getView().getContext();
        }
        return null;
    }
}
