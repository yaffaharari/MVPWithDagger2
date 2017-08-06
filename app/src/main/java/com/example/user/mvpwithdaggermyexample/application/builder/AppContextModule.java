package com.example.user.mvpwithdaggermyexample.application.builder;

import android.content.Context;

import dagger.Module;
import dagger.Provides;

/**
 * Created by user on 12/07/2017.
 */
@Module
public class AppContextModule {

    private final Context context;

    public AppContextModule(Context aContext){
        this.context = aContext;
    }

    @AppScope
    @Provides
    Context provideAppContext(){return context; }
}
