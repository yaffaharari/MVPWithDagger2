package com.example.user.mvpwithdaggermyexample.screens.heroes.core;


import com.example.user.mvpwithdaggermyexample.api.HeroApi;
import com.example.user.mvpwithdaggermyexample.models.Hero;
import com.example.user.mvpwithdaggermyexample.models.Heroes;
import com.example.user.mvpwithdaggermyexample.screens.heroes.HeroesListActivity;
import com.example.user.mvpwithdaggermyexample.utils.NetworkUtils;

import rx.Observable;

/**
 * Created by user on 12/07/2017.
 */

public class HeroesModel {

    HeroesListActivity context;
    HeroApi api;

    public HeroesModel(HeroesListActivity context, HeroApi api){
        this.context = context;
        this.api = api;
    }

    Observable<Boolean> isNetworkAvailable(){
        return NetworkUtils.isNetworkAvailableObservable(context);
    }

    Observable<Heroes> provideListHeroes(){
        return api.getHeroes();
    }

    public void gotoHeroDetailsActivity(Hero hero){
        context.showHeroDetailsActivity(hero);
    }
}
