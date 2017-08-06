package com.example.user.mvpwithdaggermyexample.screens.details.dagger;

import com.example.user.mvpwithdaggermyexample.models.Hero;
import com.example.user.mvpwithdaggermyexample.screens.details.HeroDetailsActivity;
import com.example.user.mvpwithdaggermyexample.screens.details.core.HeroDetailsView;

import dagger.Module;
import dagger.Provides;

/**
 * Created by user on 12/07/2017.
 */
@Module
public class HeroDetailsModule {

    HeroDetailsActivity detailsContext;
    Hero hero;

    public HeroDetailsModule(HeroDetailsActivity detailsContext, Hero hero){
        this.detailsContext = detailsContext;
        this.hero = hero;
    }

    @Provides
    HeroDetailsView provideDetailsView(){
        return new HeroDetailsView(detailsContext, hero);
    }
}
