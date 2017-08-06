package com.example.user.mvpwithdaggermyexample.screens.heroes.dagger;

import com.example.user.mvpwithdaggermyexample.api.HeroApi;
import com.example.user.mvpwithdaggermyexample.screens.heroes.HeroesListActivity;
import com.example.user.mvpwithdaggermyexample.screens.heroes.core.HeroesModel;
import com.example.user.mvpwithdaggermyexample.screens.heroes.core.HeroesPresenter;
import com.example.user.mvpwithdaggermyexample.screens.heroes.core.HeroesView;
import com.example.user.mvpwithdaggermyexample.utils.rx.RxSchedulers;

import dagger.Module;
import dagger.Provides;
import rx.subscriptions.CompositeSubscription;

/**
 * Created by user on 12/07/2017.
 */
@Module
public class HeroesModule {

    HeroesListActivity heroesListActivity;

    public HeroesModule(HeroesListActivity context){
        heroesListActivity = context;
    }

    @HeroesScope
    @Provides
    HeroesListActivity provideContext(){
        return heroesListActivity;
    }

    @HeroesScope
    @Provides
    HeroesView provideView(){
        return new HeroesView(heroesListActivity);
    }

    @HeroesScope
    @Provides
    HeroesPresenter providePresenter(RxSchedulers schedulers, HeroesView view, HeroesModel model){
        CompositeSubscription subscription = new CompositeSubscription();
        return new HeroesPresenter(schedulers, model, view, subscription);
    }

    @HeroesScope
    @Provides
    HeroesModel provideModel(HeroApi api){
        return new HeroesModel(heroesListActivity, api);
    }
}
