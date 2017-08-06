package com.example.user.mvpwithdaggermyexample.application;

import android.app.Application;

import com.example.user.mvpwithdaggermyexample.BuildConfig;
import com.example.user.mvpwithdaggermyexample.application.builder.AppComponent;
import com.example.user.mvpwithdaggermyexample.application.builder.AppContextModule;
import com.example.user.mvpwithdaggermyexample.application.builder.DaggerAppComponent;

import timber.log.Timber;

/**
 * Created by user on 12/07/2017.
 */

public class AppController extends Application {

    private static AppComponent appComponent;

    @Override
    public void onCreate() {
        super.onCreate();
        initialiseLogger();
        initAppComponent();
    }

    private void initAppComponent() {
      appComponent = DaggerAppComponent.builder().appContextModule(new AppContextModule(this)).build();
    }

    private void initialiseLogger() {
        if(BuildConfig.DEBUG)
            Timber.plant(new Timber.DebugTree());
        else{
            Timber.plant(new Timber.Tree() {
                @Override
                protected void log(int priority, String tag, String message, Throwable t) {

                }
            });
            }
        }

        public static AppComponent getAppComponent(){
            return appComponent;
        }
    }

