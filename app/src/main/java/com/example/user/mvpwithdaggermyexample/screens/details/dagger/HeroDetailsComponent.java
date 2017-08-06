package com.example.user.mvpwithdaggermyexample.screens.details.dagger;

import com.example.user.mvpwithdaggermyexample.screens.details.HeroDetailsActivity;

import dagger.Component;

/**
 * Created by user on 12/07/2017.
 */
@Component(modules = {HeroDetailsModule.class})
public interface HeroDetailsComponent {
    void inject(HeroDetailsActivity context);
}
