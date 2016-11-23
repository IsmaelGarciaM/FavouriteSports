package com.example.favouritesports;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.view.menu.MenuAdapter;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;

import com.example.favouritesports.adapter.SportAdapter;
import com.example.favouritesports.model.Sport;

import java.util.ArrayList;
import java.util.List;

public class SportListActivity extends AppCompatActivity {

    SportAdapter adapter;
    ListView sportsList;
    Button btnOk;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sport_list);

        sportsList = (ListView) findViewById(R.id.sportsList);
        adapter = new SportAdapter(this);
        btnOk = (Button) findViewById(R.id.btnOk);
        sportsList.setAdapter(adapter);

        btnOk.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                adapter.setPreferences();
            }
        });

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.sport_menu, menu);
        return true;
    }


}
