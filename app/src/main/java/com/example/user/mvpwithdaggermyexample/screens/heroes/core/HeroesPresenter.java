package com.example.user.mvpwithdaggermyexample.screens.heroes.core;

import android.util.Log;

import com.example.user.mvpwithdaggermyexample.models.Hero;
import com.example.user.mvpwithdaggermyexample.utils.rx.RxSchedulers;

import java.util.ArrayList;

import rx.Subscription;
import rx.subscriptions.CompositeSubscription;

/**
 * Created by user on 12/07/2017.
 */

public class HeroesPresenter {

    HeroesView view;
    HeroesModel model;
    RxSchedulers rxSchedulers;
    CompositeSubscription subscription;
    ArrayList<Hero> heros = new ArrayList<>();

    public HeroesPresenter(RxSchedulers schedulers, HeroesModel model, HeroesView view, CompositeSubscription sub){
        this.rxSchedulers = schedulers;
        this.view = view;
        this.model = model;
        this.subscription = sub;
    }

    public void onCreate(){
        subscription.add(getHeroesList());
        subscription.add(respondToClick());
    }

    public void onDestroy(){
        subscription.clear();
    }

    private Subscription respondToClick() {
        return view.itemClicks().subscribe(integer -> model.gotoHeroDetailsActivity(heros.get(integer)));
    }

    private Subscription getHeroesList() {
        return model.isNetworkAvailable().doOnNext(isNetworkAvailable ->{
            if(!isNetworkAvailable)
                Log.d("no conn", "no connection");})
                .filter(isAvailable -> true)
                .flatMap(isAvailable -> model.provideListHeroes())
                .subscribeOn(rxSchedulers.internet())
                .observeOn(rxSchedulers.androidThread())
                .subscribe(heroes -> {
                    heros = (ArrayList<Hero>)heroes.getElements();
                    view.swapAdapter(heros);
                }, throwable -> Log.d("error occur", "error"));
    }

}
