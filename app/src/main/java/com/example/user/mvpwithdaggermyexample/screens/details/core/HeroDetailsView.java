package com.example.user.mvpwithdaggermyexample.screens.details.core;

import android.databinding.DataBindingUtil;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;

import com.bumptech.glide.Glide;
import com.example.user.mvpwithdaggermyexample.R;
import com.example.user.mvpwithdaggermyexample.databinding.ActivityHeroDetailsBinding;
import com.example.user.mvpwithdaggermyexample.models.Hero;
import com.example.user.mvpwithdaggermyexample.screens.details.HeroDetailsActivity;

/**
 * Created by user on 12/07/2017.
 */

public class HeroDetailsView {

    View view;
    ActivityHeroDetailsBinding binding;

    public HeroDetailsView(HeroDetailsActivity context, Hero hero){
        binding = DataBindingUtil.inflate(LayoutInflater.from(context), R.layout.activity_hero_details,null, false);
        view = binding.getRoot();

        Glide.with(context)
                .load(hero.getImage())
                .into(binding.heroDetailsActivityImage);
        binding.heroDetailsActivityIntro.setText(TextUtils.isEmpty(hero.getIntro()) ? "no intro" : hero.getIntro());
    }

    public View getView(){
        return view;
    }
}
