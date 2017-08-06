package com.example.user.mvpwithdaggermyexample.api;

import com.example.user.mvpwithdaggermyexample.models.Heroes;

import retrofit2.http.GET;
import rx.Observable;

/**
 * Created by user on 12/07/2017.
 */

public interface HeroApi {

    @GET("test-mobile/iOS/json/test2.json")
    Observable<Heroes> getHeroes();
}
