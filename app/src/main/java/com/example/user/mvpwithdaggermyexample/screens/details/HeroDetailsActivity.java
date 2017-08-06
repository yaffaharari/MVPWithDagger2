package com.example.user.mvpwithdaggermyexample.screens.details;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

import com.example.user.mvpwithdaggermyexample.models.Hero;
import com.example.user.mvpwithdaggermyexample.screens.details.core.HeroDetailsView;
import com.example.user.mvpwithdaggermyexample.screens.details.dagger.DaggerHeroDetailsComponent;
import com.example.user.mvpwithdaggermyexample.screens.details.dagger.HeroDetailsModule;

import javax.inject.Inject;

/**
 * Created by user on 12/07/2017.
 */

public class HeroDetailsActivity extends AppCompatActivity {

    @Inject
    HeroDetailsView view;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        Hero hero = (Hero)getIntent().getExtras().get("hero");
        DaggerHeroDetailsComponent.builder().heroDetailsModule(new HeroDetailsModule(this, hero)).build().inject(this);
        setContentView(view.getView());
    }
}
