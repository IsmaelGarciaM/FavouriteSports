package com.example.favouritesports.model;

import android.media.Image;

/**
 * Created by usuario on 23/11/16.
 */

public class Sport {


    public boolean isChecked() {
        return checked;
    }

    public void setChecked(boolean checked) {
        this.checked = checked;
    }

    public int getIcon() {
        return icon;
    }

    public void setIcon(int icon) {
        this.icon = icon;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    int icon;
    String name;
    boolean checked;

    public Sport(int mIcon, String mName){
        this.icon = mIcon;
        this.name = mName;
        this.checked = false;
    }
}
