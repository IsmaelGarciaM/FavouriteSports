package com.example.favouritesports.adapter;

import android.content.Context;
import android.content.SharedPreferences;
import android.support.annotation.NonNull;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.favouritesports.R;
import com.example.favouritesports.model.Sport;
import com.example.favouritesports.repositories.SportRepository;

import java.util.List;
import java.util.Map;

/**
 * Created by usuario on 23/11/16.
 */

public class SportAdapter extends ArrayAdapter<Sport>{

    Context context;
    List<Sport> sportsList;
    SharedPreferences sp ;
    Map map;

    public SportAdapter(Context context){
        super(context, R.layout.sport_item, SportRepository.getInstance().getSports());
        sp = this.getContext().getSharedPreferences("preferences", Context.MODE_PRIVATE);

    }

    @NonNull
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View v = convertView;
        SportHolder sh;
        map = sp.getAll();

        if(v == null){

            LayoutInflater li = (LayoutInflater) getContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            v = li.inflate(R.layout.sport_item, null);
            sh = new SportHolder();

            sh.iconSport = (ImageView) v.findViewById(R.id.imgSport);

            sh.txvName = (TextView) v.findViewById(R.id.txvName);
            sh.cbxFav = (CheckBox) v.findViewById(R.id.cbxFav);

            v.setTag(sh);
        }
        else{
            sh = (SportHolder) v.getTag();
        }



        sh.iconSport.setImageResource(getItem(position).getIcon());
        sh.txvName.setText(v.getResources().getString(Integer.parseInt(getItem(position).getName())));

        if(!map.isEmpty()) {
            sh.cbxFav.setChecked((Boolean) map.get(getItem(position).getName()));
        }

        return v;


    }



    class SportHolder{
        ImageView iconSport;
        TextView txvName;
        CheckBox cbxFav;
    }

    public void setPreferences(){
        for (int i = 0; i < getCount(); i++){
            SharedPreferences.Editor editor = sp.edit();
            editor.putBoolean(getItem(i).getName(),getItem(i).isChecked());
        }
    }

}
