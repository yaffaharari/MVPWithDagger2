package com.example.user.mvpwithdaggermyexample.screens.heroes.core;

import android.databinding.DataBindingUtil;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.FrameLayout.LayoutParams;

import com.example.user.mvpwithdaggermyexample.R;
import com.example.user.mvpwithdaggermyexample.databinding.ActivityHeroesListBinding;
import com.example.user.mvpwithdaggermyexample.models.Hero;
import com.example.user.mvpwithdaggermyexample.screens.heroes.HeroesListActivity;
import com.example.user.mvpwithdaggermyexample.screens.heroes.list.HeroesAdapter;

import java.util.ArrayList;

import rx.Observable;

/**
 * Created by user on 12/07/2017.
 */

public class HeroesView {

    ActivityHeroesListBinding binding;
    View view;
    HeroesAdapter adapter;

    public HeroesView(HeroesListActivity context){
        FrameLayout parent = new FrameLayout(context);
        parent.setLayoutParams(new LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT));
        binding = DataBindingUtil.inflate(LayoutInflater.from(context), R.layout.activity_heroes_list, parent, false);
        view = binding.getRoot();

        adapter = new HeroesAdapter();

        binding.activityHeroesListRecycleview.setAdapter(adapter);
        RecyclerView.LayoutManager mLayoutManager = new LinearLayoutManager(context);
        binding.activityHeroesListRecycleview.setLayoutManager(mLayoutManager);
    }

    public Observable<Integer> itemClicks(){
        return adapter.observeClicks();
    }

    public void swapAdapter(ArrayList<Hero> heroes){
        adapter.swapAdapter(heroes);
    }

    public View getView(){
        return view;
    }
}
