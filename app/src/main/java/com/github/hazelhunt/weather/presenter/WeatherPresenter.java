package com.github.hazelhunt.weather.presenter;

import com.github.hazelhunt.weather.adapter.WeatherAdapter;
import com.github.hazelhunt.weather.model.WeatherInfo;
import com.github.hazelhunt.weather.view.WeatherView;
import com.hannesdorfmann.mosby.mvp.MvpBasePresenter;

import rx.Subscriber;
import rx.android.schedulers.AndroidSchedulers;

public class WeatherPresenter extends MvpBasePresenter<WeatherView> {

    public void doObtainWeather(double lat, double lon) {
        if (getView() == null) {
            return;
        }

        getView().showLoading();

        WeatherAdapter.getInstance().getCurrentWeather(lat, lon)
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Subscriber<WeatherInfo>() {
                    @Override
                    public void onCompleted() {
                    }

                    @Override
                    public void onError(Throwable e) {
                        getView().showError(e.getMessage());
                    }

                    @Override
                    public void onNext(WeatherInfo weather) {
                        getView().onWeatherObtained(weather);
                    }
                });
    }
}