package com.example.user.mvpwithdaggermyexample.screens.heroes;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

import com.example.user.mvpwithdaggermyexample.application.AppController;
import com.example.user.mvpwithdaggermyexample.models.Hero;
import com.example.user.mvpwithdaggermyexample.screens.details.HeroDetailsActivity;
import com.example.user.mvpwithdaggermyexample.screens.heroes.core.HeroesPresenter;
import com.example.user.mvpwithdaggermyexample.screens.heroes.core.HeroesView;
import com.example.user.mvpwithdaggermyexample.screens.heroes.dagger.DaggerHeroesComponent;
import com.example.user.mvpwithdaggermyexample.screens.heroes.dagger.HeroesModule;

import java.io.Serializable;

import javax.inject.Inject;

/**
 * Created by user on 12/07/2017.
 */

public class HeroesListActivity extends AppCompatActivity{

    @Inject
    HeroesView view;
    @Inject
    HeroesPresenter presenter;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        DaggerHeroesComponent.builder().appComponent(AppController.getAppComponent()).heroesModule(new HeroesModule(this)).build().inject(this);
        /*if(view.getView() != null){
            ((ViewGroup)view.getView().getParent()).removeView(view.getView()); // <- fix
        }*/
        setContentView(view.getView());
        presenter.onCreate();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        presenter.onDestroy();
    }

    public void showHeroDetailsActivity(Hero hero){
        Intent intent = new Intent(this, HeroDetailsActivity.class);
        intent.putExtra("hero", (Serializable)hero);
        startActivity(intent);
    }
}
