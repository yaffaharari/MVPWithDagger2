package com.example.user.mvpwithdaggermyexample.screens.heroes.dagger;

import com.example.user.mvpwithdaggermyexample.application.builder.AppComponent;
import com.example.user.mvpwithdaggermyexample.screens.heroes.HeroesListActivity;

import dagger.Component;

/**
 * Created by user on 12/07/2017.
 */
@HeroesScope
@Component(modules = {HeroesModule.class}, dependencies = {AppComponent.class})
public interface HeroesComponent {
    void inject(HeroesListActivity heroesListActivity);
}
