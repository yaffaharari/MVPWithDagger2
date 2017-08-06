package com.example.user.mvpwithdaggermyexample.screens.heroes.list;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.user.mvpwithdaggermyexample.R;
import com.example.user.mvpwithdaggermyexample.models.Hero;

import java.util.ArrayList;

import rx.Observable;
import rx.subjects.PublishSubject;

/**
 * Created by user on 12/07/2017.
 */

public class HeroesAdapter extends RecyclerView.Adapter<HeroesViewHolder> {

    private final PublishSubject<Integer> itemClicks = PublishSubject.create();
    ArrayList<Hero> listHeroes = new ArrayList<>();

    @Override
    public HeroesViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
       View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_hero,parent, false);
       return new HeroesViewHolder(view, itemClicks);
    }

    @Override
    public void onBindViewHolder(HeroesViewHolder holder, int position) {
        Hero hero = listHeroes.get(position);
        holder.bind(hero);
    }

    @Override
    public int getItemCount() {
        if(listHeroes != null && listHeroes.size() > 0)
            return listHeroes.size();
        return 0;
    }

    public Observable<Integer> observeClicks(){
        return itemClicks;
    }

    public void swapAdapter(ArrayList<Hero> heroes){
        this.listHeroes.clear();
        this.listHeroes.addAll(heroes);
        notifyDataSetChanged();
    }
}
