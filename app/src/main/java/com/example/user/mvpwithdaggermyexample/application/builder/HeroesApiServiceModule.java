package com.example.user.mvpwithdaggermyexample.application.builder;

import com.example.user.mvpwithdaggermyexample.api.HeroApi;

import dagger.Module;
import dagger.Provides;
import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by user on 12/07/2017.
 */
@Module
public class HeroesApiServiceModule {

    private static final String BASE_URL = "http://coemygroup.fr/";

    @AppScope
    @Provides
    HeroApi provideApiService(OkHttpClient client, GsonConverterFactory gson, RxJavaCallAdapterFactory rxAdapter){
        Retrofit retrofit = new Retrofit.Builder()
                .client(client)
                .baseUrl(BASE_URL)
                .addConverterFactory(gson)
                .addCallAdapterFactory(rxAdapter)
                .build();
        return retrofit.create(HeroApi.class);
    }
}
