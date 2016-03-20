package com.github.hazelhunt.weather.view;

import com.github.hazelhunt.weather.model.WeatherInfo;
import com.hannesdorfmann.mosby.mvp.MvpView;

public interface WeatherView extends MvpView {

    void showLoading();
    void hideLoading();

    void showError(String error);

    void onWeatherObtained(WeatherInfo w);
}