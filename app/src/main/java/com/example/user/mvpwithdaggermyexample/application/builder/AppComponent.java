package com.example.user.mvpwithdaggermyexample.application.builder;

import android.content.Context;

import com.example.user.mvpwithdaggermyexample.api.HeroApi;
import com.example.user.mvpwithdaggermyexample.utils.rx.RxSchedulers;

import dagger.Component;

@AppScope
@Component(modules = {AppContextModule.class, HeroesApiServiceModule.class, NetworkModule.class, RxModule.class})
public interface AppComponent {

    Context getAppContext();

    RxSchedulers rxSchedulers();

    HeroApi apiService();

}
