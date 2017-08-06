package com.example.user.mvpwithdaggermyexample.screens.heroes.list;

import android.graphics.Color;
import android.support.v7.widget.RecyclerView.ViewHolder;
import android.text.TextUtils;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.user.mvpwithdaggermyexample.R;
import com.example.user.mvpwithdaggermyexample.models.Hero;

import butterknife.BindView;
import butterknife.ButterKnife;
import rx.subjects.PublishSubject;

/**
 * Created by user on 12/07/2017.
 */

public class HeroesViewHolder extends ViewHolder {

    View view;

    @BindView(R.id.item_hero_image)
    ImageView imageHero;
    @BindView(R.id.item_hero_name)
    TextView nameHero;
    @BindView(R.id.item_hero_year)
    TextView dateReleaseHero;
    @BindView(R.id.item_hero_separator)
    View separator;
    @BindView(R.id.item_hero_text)
    TextView descriptionHero;

    public HeroesViewHolder(View itemView, PublishSubject<Integer> clickSubject){
        super(itemView);
        this.view = itemView;
        ButterKnife.bind(this, view);
        itemView.setOnClickListener(v -> clickSubject.onNext(getAdapterPosition()));
    }

    void bind(Hero hero){
        Glide.with(view.getContext())
                .load(hero.getImage())
                .into(imageHero);
        nameHero.setText(TextUtils.isEmpty(hero.getTitle()) ? "missing title" : hero.getTitle());
        dateReleaseHero.setText(TextUtils.isEmpty(hero.getTitle()) ? "missing year" : hero.getYear());
        descriptionHero.setText(TextUtils.isEmpty(hero.getIntro()) ? "missing description" : hero.getIntro());
        separator.setBackgroundColor(Color.parseColor(hero.getColor()));
    }
}
