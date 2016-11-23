package com.example.favouritesports.repositories;

import android.media.Image;
import android.preference.Preference;

import com.example.favouritesports.R;
import com.example.favouritesports.model.Sport;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by usuario on 23/11/16.
 */
public class SportRepository extends ArrayList<Sport>{


    private static SportRepository sportRepository = new SportRepository();

    public static SportRepository getInstance() {

        if(sportRepository == null)
            sportRepository = new SportRepository();

        return sportRepository;


    }

    private SportRepository() {
        add(new Sport(R.drawable.icon_basketball, String.valueOf(R.string.basket)));
        add(new Sport(R.drawable.icon_soccer, String.valueOf(R.string.soccer)));
        add(new Sport(R.drawable.icon_boxing, String.valueOf(R.string.boxing)));
        add(new Sport(R.drawable.icon_chess, String.valueOf(R.string.chess)));
        add(new Sport(R.drawable.icon_icehockey, String.valueOf(R.string.hockey)));
        add(new Sport(R.drawable.icon_baseball, String.valueOf(R.string.baseball)));
        add(new Sport(R.drawable.icon_golf, String.valueOf(R.string.golf)));
        add(new Sport(R.drawable.icon_motorbike, String.valueOf(R.string.motorbike)));
        add(new Sport(R.drawable.icon_tennis, String.valueOf(R.string.tennis)));
        add(new Sport(R.drawable.icon_american_football, String.valueOf(R.string.americanfootball)));

    }

    public List<Sport> getSports(){
        return getInstance().subList(0, getInstance().size());
    }

}
