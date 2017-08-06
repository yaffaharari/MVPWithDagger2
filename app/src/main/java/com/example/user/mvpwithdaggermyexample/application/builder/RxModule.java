package com.example.user.mvpwithdaggermyexample.application.builder;

import com.example.user.mvpwithdaggermyexample.utils.rx.AppRxSchedulers;
import com.example.user.mvpwithdaggermyexample.utils.rx.RxSchedulers;

import dagger.Module;
import dagger.Provides;

/**
 * Created by user on 12/07/2017.
 */
@Module
public class RxModule {

    @Provides
    RxSchedulers provideRxSchedulers(){
        return new AppRxSchedulers();
    }
}
